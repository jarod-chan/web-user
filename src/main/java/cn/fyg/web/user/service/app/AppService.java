package cn.fyg.web.user.service.app;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cn.fyg.web.user.service.user.Retv;

@Component
public class AppService {
	
	public static final String baseURL="http://localhost:8080/app";

	public List<AppDto> list() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Retv<List<AppDto>>> response = restTemplate.exchange(baseURL, HttpMethod.GET,
				null, new ParameterizedTypeReference<Retv<List<AppDto>>>() {
				});
		return response.getBody().getData();
	}

	public Retv<Long> create(Map<String, Object> map) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String,Object>>(map);
		ResponseEntity<Retv<Long>> response = restTemplate.exchange(baseURL, HttpMethod.POST,
				entity, new ParameterizedTypeReference<Retv<Long>>() {
				});
		return  response.getBody();
	}

	public Retv<AppDto> find(Long id){
		RestTemplate restTemplate = new RestTemplate();
		Retv<AppDto> retv = restTemplate.exchange(baseURL+"/"+id, HttpMethod.GET,
				null, new ParameterizedTypeReference<Retv<AppDto>>() {
				}).getBody();
		return retv;
	}

	public Retv<AppDto> update(Long id, Map<String, Object> map) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String,Object>>(map);
		ResponseEntity<Retv<AppDto>> response = restTemplate.exchange(baseURL+"/"+id, HttpMethod.POST,
				entity, new ParameterizedTypeReference<Retv<AppDto>>() {
				});
		return  response.getBody();
	}

	public Retv<Void> delete(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Retv<Void>> response = restTemplate.exchange(baseURL+"/"+id, HttpMethod.DELETE,
				null, new ParameterizedTypeReference<Retv<Void>>() {
				});
		return  response.getBody();
	}
	
}
