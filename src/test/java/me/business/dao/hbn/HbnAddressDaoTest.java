package me.business.dao.hbn;

import me.business.dao.AddressDao;
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
	@Autowired AddressDao addressDao;
	
	@Test
	public void testCreate() {
		Address address = new Address();
		address.setCountry(new Country("BE"));
		addressDao.create(address);
		
	}
}
