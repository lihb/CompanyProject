package com.lihb.MyServices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;

import com.lihb.domain.User;
import com.lihb.service.UserService;
import com.lihb.util.JedisClient;
import com.lihb.util.ListTranscoder;

public class MyThreadWrite implements Runnable {

	ApplicationContext context;
	int start;
	int end;
	int currentNum;

	public MyThreadWrite(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public MyThreadWrite(int i) {
		// TODO Auto-generated constructor stub
		super();
		this.start = i * GetThreadNum.RECORD_NUM + 1;
		this.end = i * GetThreadNum.RECORD_NUM + GetThreadNum.RECORD_NUM;
		this.currentNum = i;
	}

	public MyThreadWrite(ApplicationContext context) {
		super();
		this.context = context;
	}

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+"。。。。。开始执行。。。。。"+ new Date());
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		List<User> list;

		UserService userService = (UserService) context.getBean("userService");
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> ids = new ArrayList<String>();
		for (int i = start; i <= end; i++) {
			ids.add(String.valueOf(i));
		}
		map.put("time", "8:00");
		map.put("ids", ids);
		list = userService.getUserByCondition(map);     //从数据库中获取数据
		Jedis jedis = JedisClient.getJedis();
		/*try {
			System.setOut(new PrintStream(new File("e:\\toRedis.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// 将list序列化并存入到redis中
		// System.out.println("开始往redis放数据,当前线程："+currentNum);

		ListTranscoder<User> listTranscoder = new ListTranscoder<User>();
		byte[] bufIn = listTranscoder.serialize(list);
		jedis.lpush(("ReminderData" + currentNum).getBytes(), bufIn);
		
		/*释放资源*/
		ids = null;
		map= null;
		list = null;
		listTranscoder = null;
		bufIn = null;
		jedis.close();
		System.out.println(Thread.currentThread().getName()+"#######################执行完毕################################"+ new Date());
		

		/*for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			// System.out.println(Thread.currentThread().getName()+" "+currentNum+"存入数据....."+user.toString());
			System.out.println(currentNum + "存入数据....." + user.toString());
		}*/
		// Thread.currentThread().interrupt();
	}

}
