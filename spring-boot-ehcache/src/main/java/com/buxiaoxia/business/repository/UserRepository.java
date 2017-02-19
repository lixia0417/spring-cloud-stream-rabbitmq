package com.buxiaoxia.business.repository;

import com.buxiaoxia.business.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2017-02-19 22:05.
 * author xiaw
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User,Integer> {

	@Cacheable(key = "#p0", condition = "#p0.length() < 10")
	User findByName(String name);

}
