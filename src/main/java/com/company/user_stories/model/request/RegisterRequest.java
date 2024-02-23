package com.company.user_stories.model.request;

import lombok.*;


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
