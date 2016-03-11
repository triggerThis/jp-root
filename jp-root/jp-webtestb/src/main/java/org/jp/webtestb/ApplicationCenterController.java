/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.jp.webtestb;

import javax.validation.Valid;

import org.jp.domain.a.Message;
import org.jp.domain.a.MessageRepository;

import sample.data.jpa.domain.City;
import sample.data.jpa.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;



/**
 * @author Rob Winch
 */
@Controller
@RequestMapping("/")

public class ApplicationCenterController {
	//private final OtApplicationRepository messageRepository;

	//@Autowired
	//public OtApplicationController(OtApplicationRepository otApplicationRepository) {
		//this.messageRepository = otApplicationRepository;
	//}
//	private final MessageRepository messageRepository;
//
//	@Autowired
//	public MessageController(MessageRepository messageRepository) {
//		this.messageRepository = messageRepository;
//	}
	
	//以下仍可参照 message类的设计方法
	//ApplicationCenter 与用户间的关系， HCS， HOS可以做为商品
	//客户仍是客户， 客户可使用商品的待办功能
	//ac.hcs.todo(user, task)
	//CustomerService
	//csc.hcs.suport(user, question)
	//cs.hos.trace(user, question)
	//cs.myself.trace(
	//domain : ask, task, question, activity, 
	//customer: firstFrom, nowAs, visitedHistory
	//anliyerOfCustomer: can 奖励它， 关心它的问题，问候它
	
	//如果现有系统已经有数据库

	//出于成本， 我们的微系统是mysql, 公司的业务系统是SQL SERVER
//	@RequestMapping
//	public ModelAndView list() {
//		Iterable<Message> messages = this.messageRepository.findAll();
//		return new ModelAndView("messages/list", "messages", messages);
//	}
//
//	@RequestMapping("{menuid}")
//	public ModelAndView view(@PathVariable("id") Message message) {
//		return new ModelAndView("messages/view", "message", message);
//	}
//	
//	
//	@RequestMapping(params = "form", method = RequestMethod.GET)
//	public String createForm(@ModelAttribute Message message) {
//		return "messages/form";
//	}
//
//	//form like binding wechart account, asking something
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView create(@Valid Message message, BindingResult result,
//			RedirectAttributes redirect) {
//		if (result.hasErrors()) {
//			return new ModelAndView("messages/form", "formErrors", result.getAllErrors());
//		}
//		message = this.messageRepository.save(message);
//		redirect.addFlashAttribute("globalMessage", "Successfully created a new message");
//		return new ModelAndView("redirect:/{message.id}", "message.id", message.getId());
//	}
//
//	@RequestMapping("test")
//	public String foo() {
//		System.out.print("test for");
//		return "** test success";
//		//throw new RuntimeException("Expected exception in controller");
//	}
//	
//	@RequestMapping("/foo2")
//	public ModelAndView foo2() {
//		System.out.print("now");
//		//return "foo now";
//		//throw new RuntimeException("Expected exception in controller");
//		
//		Iterable<Message> messages = this.messageRepository.findAll();
//		return new ModelAndView("messages/list", "messages", messages);
//	}
//	
//	@RequestMapping("/appcenter")
//	public ModelAndView bindingAccountTo(
//			Enterprise enter, wechart 
//			) throws Exception {		
//			 
//		ModelAndView mv = new ModelAndView();
//		 mv.setViewName("messages/view2");
//		 System.out.print("storev2");
//		// return mv;
//		return new ModelAndView(
//				"layout2", "customer",null				
//				);
//		
//	}
//	
//	@RequestMapping("/storev3")
//	public ModelAndView storev3( ) throws Exception {		
//			 
//		ModelAndView mv = new ModelAndView();
//		 mv.setViewName("messages/view2");
//		 System.out.print("storev3");
//		// return mv;
//		return new ModelAndView(
//				"layout3", "customer",null				
//				);
//		
//	}
//	
//	@RequestMapping("/storev4")
//	public ModelAndView storev4( ) throws Exception {		
//			 
//		//ModelAndView mv = new ModelAndView();
//		// mv.setViewName("messages/view2");
//		 System.out.print("storev4 in layouts");
//		// return mv;
//		return new ModelAndView(
//				"/layouts/layout4", "layout4",null				
//				);
//		
//	}
//	
//	@RequestMapping("/storev5")
//	public ModelAndView storev5( ) throws Exception {		
//			 
//		//ModelAndView mv = new ModelAndView();
//		// mv.setViewName("messages/view2");
//		 System.out.print("storev5");
//		// return mv;
//		return new ModelAndView(
//				"layout5", "layout5",null				
//				);
//		
//	}
	
	
	//private final  CityRepository  cityRepository;
	//private final sample.data.jpa.service.CityRepository cityRepository;
	
	@Autowired
	private  CityService cityService;
	
	@RequestMapping("/appcenter")
	public ModelAndView f5( ) throws Exception {		
			 
		//ModelAndView mv = new ModelAndView();
		// mv.setViewName("messages/view2");
		 System.out.print("f5");
		// return mv;
		
		//Iterable<City> citys = this.cityService.getCity("Bath", "UK");
		 City city = this.cityService.getCity("Bath", "UK");
		return new ModelAndView("/appcenter/task.index", "city", city);//city);
		
		//
		//return new ModelAndView(
		//		"/appcenter/task.index", "taskModel",null				
		//		);
	}
	
	@RequestMapping("/appcenter/index")
	public ModelAndView f6( ) throws Exception {		
			 
		//ModelAndView mv = new ModelAndView();
		// mv.setViewName("messages/view2");
		 System.out.print("f5");
		// return mv;
		return new ModelAndView(
				"/appcenter/index", "City",null				
				);
		
	}

}
