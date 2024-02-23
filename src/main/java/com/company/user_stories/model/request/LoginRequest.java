package com.company.user_stories.model.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NonNull
    private String userName;
    @NonNull
    private String password;
}
