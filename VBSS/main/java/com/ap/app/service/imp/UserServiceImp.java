package com.ap.app.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.app.dao.UserDao;
import com.ap.app.entity.User;
import com.ap.app.service.UserService;
/**
 * 用户服务层
 * 
 * @author sunqx
 *
 */

@Service("userService")
public class UserServiceImp implements UserService<User>{
	
	@Autowired
	private UserDao<User> userDao;
	
	public void addUser(User v) throws Exception {
		userDao.adddData(v);
	}

}
