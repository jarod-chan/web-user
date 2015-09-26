package cn.fyg.web.user.service.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Retv<T> {
	private T data;
	private boolean success;
	private String info;
	
	public boolean success(){
		return this.success;
	}
	
	public boolean fail(){
		return !this.success;
	}
	
}
