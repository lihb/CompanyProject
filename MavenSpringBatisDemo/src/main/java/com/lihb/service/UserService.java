package com.lihb.service;

import java.util.List;
import java.util.Map;

import com.lihb.domain.User;

public interface UserService {
    public int countAll();
    public void insertUser(User user);
    public void update_insert(Map map,User user);
    public List<User> getByTime(String time);
    public List<User> getUserByCondition(Map map);

}