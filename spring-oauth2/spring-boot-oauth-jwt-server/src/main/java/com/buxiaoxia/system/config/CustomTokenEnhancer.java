package com.buxiaoxia.system.config;

import com.buxiaoxia.business.entity.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * 自定义token生成方式
 *
 */
public class CustomTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		final Map<String, Object> additionalInfo = new HashMap<>();
		User user = (User) authentication.getUserAuthentication().getPrincipal();
		additionalInfo.put("name", user.getName());
		additionalInfo.put("username", user.getUsername());
		additionalInfo.put("authorities", user.getAuthorities());
		additionalInfo.put("createAt", user.getCreateAt());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		return accessToken;
	}

}
