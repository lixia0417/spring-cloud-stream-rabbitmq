package com.buxiaoxia;

import com.buxiaoxia.system.ConsulConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by xw on 2017/2/20.
 * 2017-02-20 16:51
 */
@Data
@ConfigurationProperties("test")
@EnableDiscoveryClient
@SpringBootApplication
public class Application implements CommandLineRunner{

	private String conf1;

	private String conf2;

	private String conf3;


	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("从[config/application/test]获取conf1配置值：" + this.getConf1());
		System.out.println("从[config/application/test]获取conf2配置值：" + this.getConf2());
		System.out.println("从[config/application/test]获取conf2配置值：" + this.getConf3());
	}
}
