package cn.fyg.web.user.service.appuser;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cn.fyg.web.user.service.user.Retv;
import cn.fyg.web.user.service.user.UserDto;

@Component
public class AppuserService {
	
	public static final String baseURL="http://localhost:8080/appuser";
	
	public List<UserDto> appUser(Long appid) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Retv<List<UserDto>>> response = restTemplate.exchange(baseURL+"/app/"+appid, HttpMethod.GET,
				null, new ParameterizedTypeReference<Retv<List<UserDto>>>() {
				});
		return response.getBody().getData();
	}

}
