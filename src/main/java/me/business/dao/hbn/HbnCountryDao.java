package me.business.dao.hbn;

import me.business.api.hibernate.AbstractHibernateDao;
import me.business.dao.CountryDao;
import me.business.model.Country;
import org.springframework.stereotype.Repository;
import static org.springframework.util.Assert.notNull;

@Repository
public class HbnCountryDao extends AbstractHibernateDao<Country> implements CountryDao {
    
	public Country getByCode( String code ) {
		notNull( code, "code can't be null" );
		return (Country)getSession().getNamedQuery( "findCountryByCode" ).setString( "code", "%" + code + "%" ).uniqueResult();
	}
}
