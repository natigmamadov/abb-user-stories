package com.company.user_stories.model.request;

import com.company.user_stories.model.entity.Organization;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String email;
    //It'll take from token
    private Long organizationId;


}
