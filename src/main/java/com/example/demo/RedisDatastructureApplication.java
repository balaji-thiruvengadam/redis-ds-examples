package com.example.demo;

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

	}

}
