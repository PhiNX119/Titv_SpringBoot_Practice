package com.xuanphi.securityjpa.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterUser {
    @NotBlank(message = "Mandatory information.")
    @Size(min = 1, message = "Minimum length is 1.")
    private String username;
    @NotBlank(message = "Mandatory information.")
//    @Size(min = 8, message = "Minimum length is 8.")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
//            message = "Minimum eight characters, at least one letter, one number and one special character.")
    private String password;
    @NotBlank(message = "Mandatory information.")
    private String firstName;
    @NotBlank(message = "Mandatory information.")
    private String lastName;
    @NotBlank(message = "Mandatory information.")
    @Email(message = "Invalid Email.")
    private String email;

    public RegisterUser() {
    }

    public RegisterUser(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
