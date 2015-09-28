package resttemplet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import cn.fyg.web.user.service.user.Retv;
import cn.fyg.web.user.service.user.UserDto;

public class TestUser {
	
	public static final String baseURL="http://localhost:8080/user";
	
	@Test
	public void postForEntity(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uname", "uname123");
		RestTemplate restTemplate = new RestTemplate();
		try{
			ResponseEntity<String> postForEntity = restTemplate.postForEntity( baseURL+"/register", map, String.class);
			System.out.println(postForEntity);
		}catch(HttpClientErrorException e){
			System.out.println(e);
			System.out.println(e.getResponseBodyAsString());
		}
		
	}
	

	@Test
	public  void exchange() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uname", "uname123");
		RestTemplate restTemplate = new RestTemplate();
		try{
			/*HttpHeaders headers = new HttpHeaders();
			 headers.setContentType(MediaType.APPLICATION_JSON);*/
			 HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String,Object>>(map);


			ResponseEntity<Retv<Long>> response = restTemplate.exchange(baseURL+"/register", HttpMethod.POST,
					entity, new ParameterizedTypeReference<Retv<Long>>() {
					});
			System.out.println(response);
		}catch(HttpClientErrorException e){
			//System.out.println(e);
			//System.out.println(e.getResponseBodyAsString());
		}
	}
	
	@Test
	public void getForObject(){
		RestTemplate restTemplate = new RestTemplate();
		UserDto forObject = restTemplate.getForObject(baseURL+"/10",UserDto.class);
		System.out.println(forObject);
	}
	
	@Test
	public void find(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Retv<UserDto>> forObject = restTemplate.exchange(baseURL+"/1", HttpMethod.GET,
				null, new ParameterizedTypeReference<Retv<UserDto>>() {
				});
		System.out.println(forObject);
	}
	
	@Test
	public void list() {
		RestTemplate restTemplate = new RestTemplate();
		try{
		ResponseEntity<Retv<List<UserDto>>> response = restTemplate.exchange(baseURL, HttpMethod.GET,
				null, new ParameterizedTypeReference<Retv<List<UserDto>>>() {
				});
		
		System.out.println(response);
		}catch(HttpClientErrorException e){
			System.out.println(e);
			System.out.println(e.getResponseBodyAsString());
		}

	}
	
	@Test
	public void changeState(){
		RestTemplate restTemplate = new RestTemplate();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("state", "on");
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String,Object>>(map);
		ResponseEntity<Retv<Void>> response = restTemplate.exchange(baseURL+"/1/changestate", HttpMethod.POST,
				entity, new ParameterizedTypeReference<Retv<Void>>() {
				});
		System.out.println(response);
	}
	
	@Test
	public void resetPassword(){
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.add("password", "123");
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(parts);
		ResponseEntity<Retv<Void>> response = restTemplate.exchange(baseURL+"/1/password", HttpMethod.POST,
				entity, new ParameterizedTypeReference<Retv<Void>>() {
				});
		System.out.println(response);
	}

}
