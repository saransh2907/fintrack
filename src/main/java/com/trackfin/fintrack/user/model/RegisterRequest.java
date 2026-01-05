package com.trackfin.fintrack.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String userName;
    private String password;
    private String contact;
}
