//package com.company.user_stories.service.impl;
//
//import com.company.user_stories.exception.*;
//import com.company.user_stories.dao.entity.Organization;
//import com.company.user_stories.dao.entity.Task;
//import com.company.user_stories.dao.entity.User;
//import com.company.user_stories.model.request.CreateTaskRequest;
//import com.company.user_stories.model.request.CreateUserRequest;
//import com.company.user_stories.model.request.LoginRequest;
//import com.company.user_stories.model.request.RegisterRequest;
//import com.company.user_stories.model.response.OperationResponse;
//import com.company.user_stories.repository.OrganizationRepository;
//import com.company.user_stories.repository.TaskRepository;
//import com.company.user_stories.repository.UserRepository;
//import com.company.user_stories.service.UserStoriesService;
//import com.company.user_stories.util.PasswordEncrypter;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//public class UserStoriesServiceImpl implements UserStoriesService {
//
//    private final OrganizationRepository organizationRepository;
//
//    private final UserRepository userRepository;
//
//    private final TaskRepository taskRepository;
//
//    public UserStoriesServiceImpl(OrganizationRepository organizationRepository,
//                                  UserRepository userRepository,
//                                  TaskRepository taskRepository) {
//        this.organizationRepository = organizationRepository;
//        this.userRepository = userRepository;
//        this.taskRepository = taskRepository;
//    }
//
//    @Override
//    public OperationResponse registerOrganization(RegisterRequest request) {
//        Organization organization = organizationRepository.findByUserNameAndEmail(request.getUserName(), request.getEmail());
//        if(Objects.isNull(organization)){
//            Organization newOrganization = Organization.builder()
//                    .userName(request.getUserName())
//                    .organizationName(request.getOrganizationName())
//                    .phoneNumber(request.getPhoneNumber())
//                    .address(request.getAddress())
//                    .email(request.getEmail())
//                    .password(PasswordEncrypter.encryptPassword(request.getPassword()))
//                    .build();
//            organizationRepository.save(newOrganization);
//            return OperationResponse.builder().successful(true).build();
//        }
//        throw new AlreadyRegisteredException("This user with name : " + request.getUserName() + " have already registered");
//    }
//
//    @Override
//    public OperationResponse createUser(CreateUserRequest request) {
//        User user = userRepository.findByEmail(request.getEmail());
//        if(!Objects.isNull(user)){
////          throw new AlreadyCreatedException("This email : " +request.getEmail() + " has already used");
//        }
//         user = User.builder()
//                .name(request.getName())
//                .surname(request.getSurname())
//                .email(request.getEmail())
//                .defaultPassword(substring(request.getName()) + substring((request.getSurname())) +"123")
//                .organization(Organization.builder().id(request.getOrganizationId()).build())
//                .build();
//        userRepository.save(user);
//        return OperationResponse.builder().successful(true).build();
//    }
//
//    @Override
//    public OperationResponse loginByPassword(LoginRequest request) throws WrongCredentials {
//        Organization organization = organizationRepository.findByUserNameAndPassword(request.getUserName(), request.getPassword());
//        if(Objects.isNull(request.getUserName()) || Objects.isNull(request.getPassword())){
////            throw new ValidateInputParamException("UserName or password is empty");
//        }
//        if(request.getPassword().length() < 6){
////            throw new PasswordMinCountException("Password length is less than 6");
//        }
//        if (Objects.isNull(organization)){
//            throw new WrongCredentials("Wrong username or password.");
//        }
//        return OperationResponse.builder().successful(true).build();
//    }
//
//    @Override
//    public List<User> getUsersByOrgId(Long id) {
//        List<User> users = userRepository.findByOrganization(Organization.builder().id(id).build());
//        return users;
//    }
//
//    @Override
//    public List<Task> getAllTasks() {
//        List<Task> tasks = taskRepository.findAll();
//        return tasks;
//    }
//
//    @Override
//    public Task createTask(CreateTaskRequest request) {
//        Task task = Task.builder()
//                .title(request.getTitle())
//                .deadline(request.getDeadline())
//                .description(request.getDescription())
//                .status(request.getStatus())
//                .build();
//        taskRepository.save(task);
//        return task;
//    }
//
////    @Override
////    public OperationResponse assignTask(Long taskId, Long userId) {
////        Optional<Task> task = taskRepository.findById(taskId);
////
////        if(task.isPresent()){
////            Long presentUserId = task.get().getUserId();
////            if(presentUserId.equals("") || presentUserId.equals(null)){
////                Task presentTask = task.get();
////                presentTask.setUserId(userId);
////                taskRepository.setUserIdForPresentTask(taskId,userId);
////            }else{
////                createTask(CreateTaskRequest.builder()
////                    .deadline(task.get().getDeadline())
////                    .userId(userId)
////                    .title(task.get().getTitle())
////                    .description(task.get().getDescription())
////                    .status(task.get().getStatus())
////                    .build());
////
////            }
////
////        }
////
////        return OperationResponse.builder().successful(true).build();
////    }
//
//    private String substring(String userInfo){
//        return userInfo.substring(0,3);
//    }
//}
