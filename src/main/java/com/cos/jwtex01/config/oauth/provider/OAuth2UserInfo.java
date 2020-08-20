package com.cos.jwtex01.config.oauth.provider;

public interface OAuth2UserInfo {
	String getProviderId();
	String getProvider();
	String getEmail();
	String getName();
}
