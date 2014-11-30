package com.ap.app.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ap.app.dao.UserDao;
import com.ap.app.entity.User;
import com.ap.base.dao.CommonDaoOSupport;

/**
 * 
 * 
 * @author sunqx
 *
 */

@Repository("userDao")
public class UserDaoImp extends CommonDaoOSupport<User> implements UserDao<User> {

	
	/**
	 * @param sessionFactory the sessionFactory to set
	 * 
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void adddData(User v) throws Exception {
		
		this.save(v);
	}

	public User getData(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeData(User v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void updateData(User v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}

