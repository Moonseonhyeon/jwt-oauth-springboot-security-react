package com.cos.jwtex01.config.oauth.provider;

import java.util.Map;

public class GoogleUser implements OAuth2UserInfo{
	
	private Map<String, Object> attribute;
	
	public GoogleUser (Map<String, Object> attribute) {
		this.attribute = attribute;
	}

	@Override
	public String getProviderId() {
		
		return (String)attribute.get("googleId"); //이 부분은 조심 프로바이더들 마다 다를 수 있음
	}

	@Override
	public String getProvider() {
		
		return "google";
	}

	@Override
	public String getEmail() {
		
		return (String)attribute.get("email");
	}

	@Override
	public String getName() {
		
		return (String)attribute.get("name");
	}

}
