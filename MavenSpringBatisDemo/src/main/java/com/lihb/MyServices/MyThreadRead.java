package com.lihb.MyServices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.lihb.domain.User;
import com.lihb.util.JedisClient;
import com.lihb.util.ListTranscoder;

public class MyThreadRead implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*try {
			System.setOut(new PrintStream(new File("e:\\FromRedis.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Jedis jedis;
		jedis = JedisClient.getJedis();
		ListTranscoder<User> listTranscoder = new ListTranscoder<User>();
		List<User> newList;
        //从redis中读取数据并解序列化
		synchronized (MyThreadRead.class) {
			byte[] bufOut = jedis.lpop("ReminderData".getBytes());
			jedis.close();
			newList = listTranscoder.deserialize(bufOut);
		}
        
        
        System.out.println("开始从redis取数据");
        if (newList!=null) {
        	 for (int i = 0; i < newList.size(); i++) {
     			//System.out.println(list.get(i));
             	User user = newList.get(i);
             	System.out.println(Thread.currentThread().getName()+"取出数据....."+user.toString());
     		}
		}else {
			System.out.println("没取到数据");
		}
       
		
	}

}
