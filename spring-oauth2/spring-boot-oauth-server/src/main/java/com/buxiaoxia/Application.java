package com.buxiaoxia;

import com.buxiaoxia.business.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;

/**
 * Created by xw on 2017/2/20.
 * 2017-02-20 16:51
 */
@RestController
@SpringBootApplication
@EnableAuthorizationServer
public class Application {

	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public ResponseEntity getUser(OAuth2Authentication authentication){
		return new ResponseEntity<>(new HashMap<String,String>(){{
			put("name",authentication.getName());
			put("loginName",((User)authentication.getDetails()).getUsername());
		}}, HttpStatus.OK);
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
