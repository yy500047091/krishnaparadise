package com.yogesh.coding.payloads;



import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.yogesh.coding.entities.Role;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	 private int id;

	    @NotEmpty(message = "Username cannot be blank")
	    private String username;

	    @NotNull(message = "Mobile number cannot be null")
	    @Digits(integer = 15, fraction = 0, message = "Mobile number must be a valid number with up to 15 digits")
	    private Long mobileno;

	    @NotEmpty(message = "Email cannot be blank")
	    @Email(message = "Email should be valid")
	    private String email;

	    @NotEmpty(message = "Password cannot be blank")
	    @Size(min = 8, message = "Password should be at least 8 characters long")
	    private String password;

	    @NotEmpty(message = "Gender cannot be blank")
	    private String gender;

	    @NotNull(message = "Role cannot be null")
          private Role role;

}
