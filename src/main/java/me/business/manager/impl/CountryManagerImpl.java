package me.business.manager.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import me.business.dao.CountryDao;
import me.business.manager.CountryManager;
import me.business.model.Country;

@Component
@Transactional
public class CountryManagerImpl implements CountryManager {

	@Autowired CountryDao countryDao;
	
	Map<String, Country> map = new HashMap<String, Country>();
	
	@Override
	public Country getByCode( String code ) {
		
		if (map.containsKey( code )) {
			return map.get( code );
		}
		
		Country countryToReturn = countryDao.getByCode( code );
		map.put( code, countryToReturn );
		return countryToReturn;
		
	}

}
