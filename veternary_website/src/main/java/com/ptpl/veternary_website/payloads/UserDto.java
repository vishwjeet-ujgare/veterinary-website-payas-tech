package com.ptpl.veternary_website.payloads;

import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
    private Long userId;

    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, message = "First name should have at least 2 characters")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 2, message = "Last name should have at least 2 characters")
    private String lastName;

    @Size(min = 10, max = 15, message = "Mobile number must be between 10 and 15 characters")
    private String mblNo;

    private String cityNation;

    @Email(message = "Invalid email format")
    private String emailId;

    @NotEmpty(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",message = "Password must be 8-20 characters and contain at least one digit, one lowercase letter, one uppercase letter, and one special character")
   
    private String password;

    @NotEmpty(message = "User role cannot be empty")
    private String userRole;
}
