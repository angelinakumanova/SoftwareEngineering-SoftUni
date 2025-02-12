package com.paintingscollectors.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotNull(message = "Username mustn't be null!")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;

    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Email must contain @")
    private String email;


    @NotNull(message = "Password mustn't be null!")
    @Size(min = 3, max= 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotNull(message = "Password mustn't be null!")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String confirmPassword;
}
