package me.business.dao.hbn;

import me.business.api.hibernate.AbstractHibernateDao;
import me.business.dao.SomeIdDao;
import me.business.model.SomeId;

import org.springframework.stereotype.Repository;

@Repository
public class HbnSomeIdDao extends AbstractHibernateDao<SomeId> implements SomeIdDao {
    
}
