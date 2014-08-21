package me.business.dao.hbn;

import java.math.BigDecimal;
import java.util.Date;
import me.business.api.Dao;
import me.business.api.hibernate.AbstractHibernateDao;
import me.business.dao.CountryDao;

import me.business.model.Country;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( "classpath:/me/business/config/test-config.xml" )
@ActiveProfiles( "no-server" )
@Transactional
public class MyTest {

	@Autowired
	private SessionFactory sessionFactory;

        @Autowired
        private CountryDao countryRepository;
        
	@Test
	public void testAbstractHibernateDao() {
		Country country = new Country();
		country.setCode( "XX" );
                long countBefore = countryRepository.count();
                countryRepository.create(country);
                Assert.assertEquals(countBefore + 1, countryRepository.count());
                country.setCode("YY");
                Date timeBeforeUpdate = country.getModifiedOn();
                countryRepository.update(country);
                Assert.assertNotSame(timeBeforeUpdate, country.getModifiedOn());
                countryRepository.getAll();
                
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
