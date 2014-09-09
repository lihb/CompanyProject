package com.lihb.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisClient {
	
	public static Jedis getJedis(){
		
		JedisPool pool;
        Jedis jedis;      
        pool = new JedisPool(new JedisPoolConfig(), "localhost");
        jedis = pool.getResource();
        
        return jedis;
	}

}
