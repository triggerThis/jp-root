/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jp.webtestb;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.annotation.Resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.context.support.WebApplicationContextUtils;

import org.jp.domain.a.*;
import org.jp.service.*;
//import org.jp.domain.a.MessageRepository;
//import org.jp.domain.a.InMemoryMessageRepository;
//import org.jp.domain.a.Message;
//@SpringApplicationConfiguration(classes = MainConfig.class)
//@SpringBootApplication
//@TransactionConfiguration(transactionManager = "transactionManager")
//@EnableConfigurationProperties(com.at.mul.MainConfig.class)
//@EnableAutoConfiguration( MainConfig.class, exclude={DataSourceAutoConfiguration.class})
//@SpringApplicationConfiguration(classes = MainConfig.class)
//@TransactionConfiguration(transactionManager = "transactionManager")

//@EnableAutoConfiguration(exclude ={ DataSourceAutoConfiguration.class, 
//		DataSourceTransactionManagerAutoConfiguration.class,
//		org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class}) 
//@Configuration 
//@ComponentScan(basePackages = "com.at.mul.domain.*") 
//@EnableJpaRepositories({ "com.at.mul.customer.CustomerRepository","com.at.mul.order.OrderRepository"}) 
//@EnableAutoConfiguration
@SpringBootApplication
//@Import({MvcConfig.class}) //
@EnableAspectJAutoProxy //： 激活Aspect自动代理 <aop:aspectj-autoproxy/>
@EnableAutoConfiguration
@ComponentScan( basePackages = {"org.jp.webtestb","org.jp.domain.a"})

//可以扫描多个自动装配类
//@ComponentScan( basePackages = {"org.jp.webtestb", "com.lqspring.rest","sample.web"})
//@ComponentScan(basePackages="...")
public class SampleWebUiApplication {
	
//	@Autowired
//	private PlatformTransactionManager transactionManager;
//
	//@Autowired
	//private StoreService storeService;
//
//	@Autowired
//	private CustomerRepository customerRepository;
//
//	@Autowired
//	private OrderRepository orderRepository;

	@Bean
	public MessageRepository messageRepository() {
		return new InMemoryMessageRepository();
	}

	@Bean
	public Converter<String, Message> messageConverter() {
		return new Converter<String, Message>() {
			@Override
			public Message convert(String id) {
				return messageRepository().findMessage(Long.valueOf(id));
			}
		};
	}
	
	@Bean
	public MessageService messageService{
		return new MessageService();
	}
	//@Autowired
	//private MainConfig mainConfig;
	//@Bean
	//@Resource(name="appCtx")     
	 
	//public ApplicationContext appCtx;
 
	public static void main(String[] args) throws Exception {
		//SpringApplication.run(SampleWebUiApplication.class, args);
		//com.at.mul.MainConfig.class
		//SpringApplication.run(com.at.mul.MainConfig.class, args);
		//SpringApplication.run([SampleWebUiApplication.class], args);
		// SpringApplication app = new SpringApplication(SampleWebUiApplication.class); 
		// ApplicationContext ctx = 
			//	 app.run();
	      //  ApplicationContext ac2 ;
	        //ac2 = WebApplicationContext.
	        ApplicationContext ctx =  SpringApplication.run(SampleWebUiApplication.class);
	       // appCtx =ctx;
	      // (new SpringContextUtils()).setApplicationContext(ctx);
	      //  System.out.println((StoreServiceImpl.class).toString());
		//SampleWebUiApplication sa = new SampleWebUiApplication();
		//sa.testStore();
	       // ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(ServletContext sc);
	        System.out.println("Let's inspect the beans provided by Spring Boot:");

	        String[] beanNames = ctx.getBeanDefinitionNames();
	        Arrays.sort(beanNames);
	        for (String beanName : beanNames) {
	            System.out.println(beanName);
	        }
	}
	
	

}
