package com.hoangengland.util;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	public HttpUtil(String value) {
		this.value = value;
	}
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static HttpUtil of(BufferedReader reader) {
		
		StringBuilder sb = new StringBuilder();

	    String line;
	    
	    try {
			while ((line = reader.readLine()) != null) {
			    sb.append(line);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return new HttpUtil(sb.toString());
	}
	public String getValue() {
		return value;
	}
}
