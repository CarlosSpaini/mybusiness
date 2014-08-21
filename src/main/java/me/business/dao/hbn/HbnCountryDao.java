package me.business.dao.hbn;

import me.business.api.hibernate.AbstractHibernateDao;
import me.business.dao.CountryDao;
import me.business.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public class HbnCountryDao extends AbstractHibernateDao<Country> implements CountryDao {
    
}
