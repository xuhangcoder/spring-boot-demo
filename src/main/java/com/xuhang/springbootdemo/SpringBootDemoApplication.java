package com.xuhang.springbootdemo;

import com.xuhang.springbootdemo.test.TestRedis;
//import com.xxl.job.core.handler.annotation.JobEnable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCaching
//@JobEnable
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootDemoApplication.class, args);
		TestRedis redis = ctx.getBean(TestRedis.class);
		redis.testRedis();
	}
}
