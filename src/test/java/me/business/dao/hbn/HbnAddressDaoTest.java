package me.business.dao.hbn;

import me.business.dao.AddressDao;
import me.business.dao.CountryDao;
import me.business.model.Address;
import me.business.model.Country;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
		address.setCountry(new Country("BE"));
		// 1) is there any way for hibernate to automatically load country object?
		addressDao.create(address);
		// 2) country is constant in database. so, these two values should be equal
		assertEquals(country.getCountryId(), address.getCountry().getCountryId());
		
	}
}
