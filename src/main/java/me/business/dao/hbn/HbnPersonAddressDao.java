package me.business.dao.hbn;

import me.business.api.hibernate.AbstractHibernateDao;
import me.business.dao.PersonAddressDao;
import me.business.model.PersonAddress;

import org.springframework.stereotype.Repository;

@Repository
public class HbnPersonAddressDao extends AbstractHibernateDao<PersonAddress> implements PersonAddressDao {
    
}
