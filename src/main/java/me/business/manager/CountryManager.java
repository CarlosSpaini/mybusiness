package me.business.manager;

import me.business.model.Country;

public interface CountryManager {
	
	public Country getByCode( String code );
	
}
