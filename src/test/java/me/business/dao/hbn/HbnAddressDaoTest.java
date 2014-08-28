package me.business.dao.hbn;

import static org.junit.Assert.*;
import me.business.dao.AddressDao;
import me.business.dao.CountryDao;
import me.business.model.Address;
import me.business.model.Country;

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
public class HbnAddressDaoTest {
	@Autowired CountryDao countryDao;
	@Autowired AddressDao addressDao;
	
	@Test
	public void testCreate() {
		Country country = countryDao.getByCode("BE");
		Address address = new Address();
		address.setCountry(country);
		addressDao.create(address);
		assertEquals(country.getCountryId(), addressDao.get(address.getAddressId()).getCountry().getCountryId());
		
	}
}
