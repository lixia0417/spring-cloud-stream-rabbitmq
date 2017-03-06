package com.buxiaoxia.business.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by xw on 2017/3/6.
 * 2017-03-06 13:52
 */
@Service
public class HelloService {

	private Random random = new Random();

	/**
	 * 调用异常，方法降级默认处理
	 *
	 */
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String getHello() {
		int randomInt= random.nextInt(10) ;
		if(randomInt<3){  //模拟调用失败情况
			throw new RuntimeException("call getHello service fail.");
		}else{
			return "hello:"+randomInt;
		}
	}

	public String helloFallback(){
		return "default hello:0";
	}
}
