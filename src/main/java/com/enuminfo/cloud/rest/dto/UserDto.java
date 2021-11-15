package com.enuminfo.cloud.rest.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserDto extends BaseDto {
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private long phone;
	private String password;
	private String access;
	private String username;
	private boolean loggedIn;
}
