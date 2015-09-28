package cn.fyg.web.user.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class UserService {
	
	public static final String baseURL="http://localhost:8080/user";

	public List<UserDto> list() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Retv<List<UserDto>>> response = restTemplate.exchange(baseURL, HttpMethod.GET,
				null, new ParameterizedTypeReference<Retv<List<UserDto>>>() {
				});
		return response.getBody().getData();
	}
	
	public Retv<Long> create(Map<String,Object> map){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String,Object>>(map);
		ResponseEntity<Retv<Long>> response = restTemplate.exchange(baseURL+"/register", HttpMethod.POST,
				entity, new ParameterizedTypeReference<Retv<Long>>() {
				});
		return  response.getBody();
	}
	
	public Retv<UserDto> find(Long id){
		RestTemplate restTemplate = new RestTemplate();
		Retv<UserDto> retv = restTemplate.exchange(baseURL+"/"+id, HttpMethod.GET,
				null, new ParameterizedTypeReference<Retv<UserDto>>() {
				}).getBody();
		return retv;
	}
	
	
	public Retv<UserDto> update(Long id,Map<String,Object> map){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String,Object>>(map);
		ResponseEntity<Retv<UserDto>> response = restTemplate.exchange(baseURL+"/"+id, HttpMethod.POST,
				entity, new ParameterizedTypeReference<Retv<UserDto>>() {
				});
		return  response.getBody();
	}
	
	public Retv<Void> changeState(Long id,String state){
		RestTemplate restTemplate = new RestTemplate();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("state", state);
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String,Object>>(map);
		ResponseEntity<Retv<Void>> response = restTemplate.exchange(baseURL+"/"+id+"/changestate", HttpMethod.POST,
				entity, new ParameterizedTypeReference<Retv<Void>>() {
				});
		return  response.getBody();
	}
	
	public Retv<Void> resetPassword(Long id,String password){
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.add("password", password);
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(parts);
		ResponseEntity<Retv<Void>> response = restTemplate.exchange(baseURL+"/"+id+"/password", HttpMethod.POST,
				entity, new ParameterizedTypeReference<Retv<Void>>() {
				});
		return response.getBody();
	}
	
	
}
