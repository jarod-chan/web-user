package cn.fyg.web.user.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class UserService {
	
	public static final String baseURL="http://localhost:8080/user";

	public List<UserDto> list() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<UserDto>> response = restTemplate.exchange(baseURL, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<UserDto>>() {
				});
		return response.getBody();
	}
	
	public Retv<Long> create(Map<String,Object> map){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Retv<Long>> response = restTemplate.exchange(baseURL+"/register", HttpMethod.POST,
				null, new ParameterizedTypeReference<Retv<Long>>() {
				},map);
		return  response.getBody();
	}
	
	public static void main1(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uname", "uname123");
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<String> postForEntity = restTemplate.postForEntity( baseURL+"/register", map, String.class);
		}catch(HttpClientErrorException e){
			System.out.println(e);
			System.out.println(e.getResponseBodyAsString());
		}
	}
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uname", "uname123");
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<Retv<Long>> response = restTemplate.exchange(baseURL+"/register", HttpMethod.POST,
					null, new ParameterizedTypeReference<Retv<Long>>() {
					},map);
		}catch(HttpClientErrorException e){
			System.out.println(e);
			System.out.println(e.getResponseBodyAsString());
		}
	}

}
