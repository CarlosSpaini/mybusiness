/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package me.business.api.hibernate;


import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import me.business.api.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public abstract class AbstractHibernateDao<T extends Object> implements Dao<T> {

	@Autowired SessionFactory sessionFactory;

	private Class<T> domainClass;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings( "unchecked" )
	private Class<T> getDomainClass() {
		if( domainClass == null ) {
			ParameterizedType thisType = ( ParameterizedType )getClass().getGenericSuperclass();
			this.domainClass = ( Class<T> )thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	private String getDomainClassName() {
		return getDomainClass().getName();
	}

	@Override
	public void create( T t ) {

		Method method = ReflectionUtils.findMethod( getDomainClass(), "setCreatedOn", new Class[] { Date.class } );
		if( method != null ) {
			try {
				method.invoke( t, new Date() );
			}
			catch( Exception e ) {
				// skip
			}
		}

		getSession().save( t );
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public T get( Serializable id ) {
		return ( T )getSession().get( getDomainClass(), id );
	}
        
        @Override
	public long count() {
		return ( Long )getSession().createQuery( "select count(*) from " + getDomainClassName() ).uniqueResult();
	}
        
        @Override
        @SuppressWarnings( "unchecked" )
	public List<T> getAll() {
		return getSession().createQuery( "from " + getDomainClassName() ).list();
	}
        
        @Override
	public void update( T t ) {
                // If there's a setModifiedOn() method, then set the date.
		Method method = ReflectionUtils.findMethod( getDomainClass(), "setModifiedOn", new Class[] { Date.class } );
		if( method != null ) {
			try {
				method.invoke( t, new Date() );
			}
			catch( Exception e ) {
				// Ignore any exception here; simply abort the setDate() attempt
			}
		}
		getSession().update( t );
	}

}
