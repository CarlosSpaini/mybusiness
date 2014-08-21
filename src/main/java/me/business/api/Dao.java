/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package me.business.api;

import java.io.Serializable;
import java.util.List;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface Dao<T extends Object> {

	void create( T t );
	
	T get( Serializable id );

	List<T> getAll();
	
}
