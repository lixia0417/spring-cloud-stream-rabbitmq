package com.buxiaoxia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Created by xw on 2017/2/20.
 * 2017-02-20 16:51
 */
@SpringBootApplication
@EnableAuthorizationServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
