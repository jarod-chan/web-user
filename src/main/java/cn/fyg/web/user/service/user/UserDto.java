package cn.fyg.web.user.service.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
	
	private Long   fyid;
	private String uname;
	private String uemail;
	private String uphone;
	private String realname;
	private String state;

	
}
