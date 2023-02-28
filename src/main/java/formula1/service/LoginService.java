package formula1.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import formula1.dto.LoginDto;
import formula1.dto.UserDto;

public interface LoginService extends UserDetailsService {
	public UserDto login(LoginDto loginDto) throws Exception;
	public int registUser(UserDto userDto) throws Exception;
}
