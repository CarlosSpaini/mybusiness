package me.business.dao.hbn;

import static org.junit.Assert.*;

import java.util.HashSet;

import me.business.dao.AddressDao;
import me.business.dao.CountryDao;
import me.business.dao.PersonAddressDao;
import me.business.dao.SomeIdDao;
import me.business.manager.CountryManager;
import me.business.model.Address;
import me.business.model.Country;
import me.business.model.Person;
import me.business.model.SomeId;

import org.junit.Before;
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
	@Autowired CountryManager countryManager;
	@Autowired PersonAddressDao personAddressDao;
	@Autowired SomeIdDao someIdDao;
	
	private Person personOne;
	private Person personTwo;
	private Person personThree;
	private Address address1;
	private Address address2;
	private SomeId someId1;
	private SomeId someId2;
	
	@Before
	public void initialize() {
		// address
		this.address1 = new Address();
		this.address1.setCountry(countryManager.getByCode( "BE" ));
		this.address2 = new Address();
		this.address2.setCountry(countryManager.getByCode( "HR" ));
		// persons
		this.personOne = new Person();
		this.personTwo = new Person();
		this.personThree = new Person();
		this.personOne.getAddress().add( address1 );
		this.personOne.getAddress().add( address2 );
		// adding to address2 other 2 persons
		this.address2.getPersons().add( personTwo );
		this.address2.getPersons().add( personThree );
		// someIds
		this.someId1 = new SomeId();
		this.someId1.setSomeId( "ID1" );
		this.someId2 = new SomeId();
		this.someId2.setSomeId( "ID2" );
	}
	
	@Test
	public void testCreate() {
		Address address = new Address();
		address.setCountry(countryManager.getByCode( "BE" ));
		addressDao.create(address);
		assertEquals("BE", addressDao.get(address.getAddressId()).getCountry().getCode());
		
	}
	
	@Test
	public void testJoinTable() {
		addressDao.create( address1 );
		addressDao.create( address2 );
		Address address = addressDao.get( address2.getAddressId() );
		assertTrue("address2 don't have 3 persons as expected", address.getPersons().size() == 3);
		long numberOfRecordsInJoinTable = personAddressDao.count();
		assertTrue( "join table PERSON_ADDRESS is not used by Hibernate", numberOfRecordsInJoinTable > 0 );
	}
	
	@Test
	public void testLoadEverything() {
		address1.setSomeIds( new HashSet<SomeId>() );
		address1.getSomeIds().add( someId1 );
		address1.getSomeIds().add( someId2 );
		addressDao.create( address1 );
		long numberOfRecordsInSomeIdTable = someIdDao.count();
		assertTrue("someIds are not persisted", numberOfRecordsInSomeIdTable > 0);
	}
}
