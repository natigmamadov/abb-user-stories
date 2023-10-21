package com.company.user_stories.model.request;

import com.company.user_stories.model.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    @NonNull
    private String organizationName;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String address;
    @NonNull
    private String userName;
    @NonNull
    private String email;
    @NonNull
    private String password;




}
