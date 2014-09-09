package com.lihb.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lihb.dao.UserDao;
import com.lihb.domain.User;
import com.lihb.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
	private UserDao userDao;
  
	public int countAll() {
        return this.userDao.countAll();
    }

	@Override
	public void insertUser(User user) {
		this.userDao.insertUser(user);
		throw new RuntimeException("Error");
	}


	@Override
	public void update_insert(Map map,User user) {
		this.userDao.updateUser(map);
		this.userDao.insertUser(user);
		throw new RuntimeException("Error");
		
	}

	@Override
	public List<User> getByTime(String time) {
		// TODO Auto-generated method stub
		return userDao.getByTime(time);
	}

	@Override
	public List<User> getUserByCondition(Map map) {
		// TODO Auto-generated method stub
		return userDao.getUserByCondition(map);
	}
    
}

