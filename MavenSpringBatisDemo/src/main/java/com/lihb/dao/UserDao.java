package com.lihb.dao;

import java.util.List;
import java.util.Map;

import com.lihb.domain.User;

public interface UserDao {
	    public int countAll();
	    public void insertUser(User user);
	    public List<User> getAllUser();
	    public User getById(String id);
	    public List<User> getByTime(String time);
	    public void deleteUser(String id);
	    public void updateUser(Map<String,Object> map);
	    public List<User> getUserByCondition(Map<String,Object> map);

}
