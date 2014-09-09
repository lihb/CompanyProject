package com.lihb.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihb.domain.User;
import com.lihb.service.UserService;

public class UserServiceTest {
    
    @Test
    public void userServiceTest(){
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)context.getBean("userService");
        int num = userService.countAll();
        System.out.println("数目："+num);
        User user =new User();
        user.setId("003");
        user.setName("樱木花道");
        
        Map<String, Object> map=new HashMap<String, Object>();
        List<String> ids = new ArrayList<String>();
        for (int i = 1; i <= 100000; i++) {
			ids.add(String.valueOf(i));
		}
        map.put("time", "8:00");
        map.put("ids", ids);
        List<User> list  = userService.getUserByCondition(map);
        //List<User> list  = userService.getByTime("14:00");
        for (int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i));
        	user = list.get(i);
        	System.out.println(user.toString());
		}
        
        try {
        	 // System.out.println(userService.countAll());
        	//userService.update_insert(map, user);
        //	 userService.insertUser(user);//
		} catch (Exception e) {
			e.printStackTrace();
		}
       
      
    }
}