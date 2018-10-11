package com.tsao.blog.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;

@Component("passwordHelper")
public class PasswordHelper {
	private String algorithmName = "md5";
    private int hashIterations = 2;
    private String salt = "abc";
    
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String encryptPassword(String password, String salt){
    	String encryptString = new SimpleHash(this.algorithmName, 
    			password, 
    			salt, 
    			this.hashIterations).toHex();
    	return encryptString;
    }
    
}
