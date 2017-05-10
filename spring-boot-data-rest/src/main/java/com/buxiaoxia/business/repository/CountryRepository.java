package com.buxiaoxia.business.repository;

import com.buxiaoxia.business.entity.Country;
import com.buxiaoxia.business.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 * Created by xw on 2017/5/10.
 * 2017-05-10 13:55
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {
}


