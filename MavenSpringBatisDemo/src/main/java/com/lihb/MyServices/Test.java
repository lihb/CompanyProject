package com.lihb.MyServices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import com.lihb.domain.User;
import com.lihb.util.JedisClient;
import com.lihb.util.ListTranscoder;

import redis.clients.jedis.Jedis;
/**
 * 
 * 测试类：从redis对列中读取数据
 * @author lihb
 *
 */

public class Test {

	public static void main(String[] args) {

		Jedis jedis = JedisClient.getJedis();
		ListTranscoder<User> listTranscoder = new ListTranscoder<User>();
		try {
			System.setOut(new PrintStream(new File("e:\\fromRedis.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> newList;
		// 从redis中读取数据并解序列化
		long start = System.currentTimeMillis();
		for (int i = 0; i < 52; i++) {
			byte[] bufOut = jedis.lpop(("ReminderData"+i).getBytes());
			//jedis.close();
			newList = listTranscoder.deserialize(bufOut);

			// System.out.println("开始从redis取数据");

			for (int j = 0; j < newList.size(); j++) {
				// System.out.println(list.get(i));
				User user = newList.get(j);
				System.out.println(Thread.currentThread().getName() + "取出数据....."
						+ user.toString());
			}
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start)+"ms");
		

	}

}
