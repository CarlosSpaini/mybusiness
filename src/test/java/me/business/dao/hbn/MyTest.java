package me.business.dao.hbn;

import java.math.BigDecimal;

import me.business.model.Country;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( "classpath:/me/business/config/test-config.xml" )
@ActiveProfiles( "no-server" )
public class MyTest {

	@Autowired
	SessionFactory sessionFactory;

	@Test
	public void testAbstractHibernateDao() {
		Country country = new Country();
		country.setCountryId( new BigDecimal( 1 ) );
		country.setCode( "XX" );
		getSession().save( country );
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
