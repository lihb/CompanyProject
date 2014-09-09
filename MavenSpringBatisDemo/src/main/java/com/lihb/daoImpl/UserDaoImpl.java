package com.lihb.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lihb.dao.UserDao;
import com.lihb.domain.User;
import com.lihb.mapper.UserMapper;

@Service("userDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	private UserMapper userMapper;
	
	public int countAll() {
		return  this.userMapper.countAll();
	}

	@Override
	public void insertUser(User user) {
		 this.userMapper.insertUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return this.userMapper.getAllUser();
	}

	@Override
	public User getById(String id) {
		return this.userMapper.getById(id);
	}
	
	@Override
	public List<User> getByTime(String time) {
		
		return this.userMapper.getByTime(time);
	}

	@Override
	public void deleteUser(String id) {
		this.userMapper.deleteUser(id);
		
	}

	@Override
	public void updateUser(Map<String, Object> map) {
		this.userMapper.updateUser(map);
	}

	@Override
	public List<User> getUserByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.userMapper.getUserByCondition(map);
	}

	

}
