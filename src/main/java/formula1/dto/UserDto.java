package formula1.dto;

import lombok.Data;

@Data
public class UserDto {
	private String userId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userBirth;
}
