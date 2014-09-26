package me.business.dao.hbn;

import me.business.api.hibernate.AbstractHibernateDao;
import me.business.dao.AddressDao;
import me.business.model.Address;

import org.springframework.stereotype.Repository;

@Repository
public class HbnAddressDao extends AbstractHibernateDao<Address> implements AddressDao {
    
}
