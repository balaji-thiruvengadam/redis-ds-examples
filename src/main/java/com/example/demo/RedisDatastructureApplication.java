package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.Jedis;

@SpringBootApplication
public class RedisDatastructureApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisDatastructureApplication.class, args);
	}

	@Bean
	public static void testRedisDS() {
		Jedis jedis = new Jedis("localhost");
		jedis.set("string-key", "redis training"); // String
		System.out.println(jedis.get("string-key"));

		jedis.lpush("list-key", "traing","day1","day2"); // List
		System.out.println(jedis.lrange("list-key",0,-1));
		
		Map<String, String> siteCount = new HashMap<>();
		siteCount.put("google", "100000");
		siteCount.put("yahoo", "30000");
		siteCount.put("linkedin", "50000");
		
		jedis.hset("site-count", siteCount); //Hash 
		System.out.println(jedis.hgetAll("site-count"));
		
		jedis.sadd("countries", "USA","UK","India","Argentina","Brazil","Canada","Mexico","Argentina","Germany"); //set
		System.out.println(jedis.smembers("countries"));
		
		jedis.zadd("site-rank-visits", 100000,"google"); //sorted set


	}

}
