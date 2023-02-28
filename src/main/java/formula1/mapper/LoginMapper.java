package formula1.mapper;

import org.apache.ibatis.annotations.Mapper;

import formula1.dto.LoginDto;
import formula1.dto.UserDto;

@Mapper
public interface LoginMapper {
	public UserDto login(LoginDto loginDto) throws Exception;
	public int registUser(UserDto userDto) throws Exception;
	public UserDto selectUserByUserId(String userId);	
}
