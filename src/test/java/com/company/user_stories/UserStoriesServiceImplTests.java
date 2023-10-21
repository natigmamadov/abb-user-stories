package com.company.user_stories;

import com.company.user_stories.controller.TasksController;
import com.company.user_stories.controller.UserStoriesController;
import com.company.user_stories.error.ValidateInputParamException;
import com.company.user_stories.error.WrongCredentials;
import com.company.user_stories.model.entity.Organization;
import com.company.user_stories.model.entity.Task;
import com.company.user_stories.model.entity.User;
import com.company.user_stories.model.request.CreateTaskRequest;
import com.company.user_stories.model.request.CreateUserRequest;
import com.company.user_stories.model.request.LoginRequest;
import com.company.user_stories.model.request.RegisterRequest;
import com.company.user_stories.model.response.OperationResponse;
import com.company.user_stories.repository.OrganizationRepository;
import com.company.user_stories.repository.TaskRepository;
import com.company.user_stories.repository.UserRepository;
import com.company.user_stories.service.impl.UserStoriesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserStoriesServiceImplTests {

	private UserStoriesServiceImpl userStoriesService;
	private TasksController tasksController;
	private UserStoriesController userStoriesController;
	private OrganizationRepository organizationRepository;
	private TaskRepository taskRepository;
	private UserRepository userRepository;



	@BeforeEach
	void setUp(){
		organizationRepository = mock(OrganizationRepository.class);
		taskRepository = mock(TaskRepository.class);
		userRepository = mock(UserRepository.class);
		userStoriesService = new UserStoriesServiceImpl(organizationRepository,userRepository,taskRepository);
		tasksController = new TasksController(userStoriesService);
		userStoriesController = new UserStoriesController(userStoriesService);

	}

	@Test
	public void test_createTask_validInput() {
		// Arrange
		CreateTaskRequest request = CreateTaskRequest.builder()
				.userId(1L)
				.title("Task 1")
				.description("Test")
				.deadline("20230101")
				.status("Backlog")
				.build();

		// Act
		Task response = userStoriesService.createTask(request);

		// Assert

		assertNotNull(response);
		assertEquals(request.getUserId(), response.getUserId());
		assertEquals(request.getTitle(), response.getTitle());
		assertEquals(request.getDescription(), response.getDescription());
		assertEquals(request.getDeadline(), response.getDeadline());
		assertEquals(request.getStatus(), response.getStatus());
	}



	@Test
	public void test_assignTask_validUserId() {
		// Arrange
		Long taskId = 1L;
		Long userId = 1L;

		// Act
		ResponseEntity<OperationResponse> response = tasksController.assignTask(taskId, userId);

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().isSuccessful());
	}

	@Test
	public void test_returns_all_tasks_when_tasks_exist() {
		// Arrange
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(1L, "Task 1", "Description 1", "20230101", "Pending", 1L, new ArrayList<>()));
		tasks.add(new Task(2L, "Task 2", "Description 2", "20230201", "Done", 2L, new ArrayList<>()));
		when(userStoriesService.getAllTasks()).thenReturn(tasks);

		// Act
		ResponseEntity<List<Task>> response = tasksController.getAllTasks();

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(tasks, response.getBody());
	}

	@Test
	public void test_successfully_register_organization() {
		RegisterRequest request = RegisterRequest.builder()
				.organizationName("Organization")
				.phoneNumber("0512222222")
				.address("Street")
				.userName("testuser")
				.email("test@gmail.com")
				.password("password")
				.build();

		OperationResponse expectedResponse = OperationResponse.builder()
				.successful(true)
				.build();

		when(userStoriesService.registerOrganization(request)).thenReturn(expectedResponse);

		ResponseEntity<OperationResponse> response = userStoriesController.registerOrganization(request);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedResponse, response.getBody());
	}
	@Test
	public void test_createUser_validInputData() {
		// Arrange
		CreateUserRequest request = new CreateUserRequest("Test", "Test", "test@gmail.com", 1L);

		// Act
		ResponseEntity<OperationResponse> response = userStoriesController.createUser(request);

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().isSuccessful());
	}


	@Test
	public void test_validate_input_login_request() throws WrongCredentials {

		UserStoriesController userStoriesController = new UserStoriesController(userStoriesService);

		LoginRequest request = new LoginRequest(null, null);


		assertThatThrownBy(() -> userStoriesController.loginByPassword(request))
				.isInstanceOf(ValidateInputParamException.class)
				.hasMessageContaining("UserName or password is empty");
	}

	@Test
	public void test_return_list_of_users_with_valid_organization_id() {
		// Arrange
		Long organizationId = 1L;
		List<User> expectedUsers = new ArrayList<>();
		expectedUsers.add(new User(1L, "Test1", "Test1", "test@gmail.com", "password", new Organization(), new ArrayList<>()));
		expectedUsers.add(new User(2L, "Test2", "Test2", "test2@gmail.com", "password", new Organization(), new ArrayList<>()));
		when(userStoriesService.getUsersByOrgId(organizationId)).thenReturn(expectedUsers);

		// Act
		List<User> actualUsers = userStoriesController.getUsersByOrgOid(organizationId);

		// Assert
		assertEquals(expectedUsers, actualUsers);
	}



}
