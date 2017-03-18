package com.buxiaoxia.business.service;

import com.buxiaoxia.business.entity.User;
import com.buxiaoxia.business.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by xw on 2017/3/17.
 * 2017-03-17 20:13
 */
@Component
public class CustomUserService implements UserDetailsService{


	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = userRepository.findOneByUsername(s);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		System.out.println("s:"+s);
		System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
		return user;
	}
}
