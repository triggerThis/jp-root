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

public class MessageController {
	private final MessageRepository messageRepository;

	@Autowired
	public MessageController(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@RequestMapping
	public ModelAndView list() {
		Iterable<Message> messages = this.messageRepository.findAll();
		return new ModelAndView("messages/list", "messages", messages);
	}

	@RequestMapping("{id}")
	public ModelAndView view(@PathVariable("id") Message message) {
		return new ModelAndView("messages/view", "message", message);
	}
	
	
	

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(@ModelAttribute Message message) {
		return "messages/form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@Valid Message message, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("messages/form", "formErrors", result.getAllErrors());
		}
		message = this.messageRepository.save(message);
		redirect.addFlashAttribute("globalMessage", "Successfully created a new message");
		return new ModelAndView("redirect:/{message.id}", "message.id", message.getId());
	}

	@RequestMapping("foo")
	public String foo() {
		System.out.print("now");
		return "foo now";
		//throw new RuntimeException("Expected exception in controller");
	}
	
	@RequestMapping("/foo2")
	public ModelAndView foo2() {
		System.out.print("now");
		//return "foo now";
		//throw new RuntimeException("Expected exception in controller");
		// ModelAndViewnew mav = new ModelAndView());
		Iterable<Message> messages = this.messageRepository.findAll();
		return new ModelAndView("messages/list", "messages", messages);
	}
	
	@RequestMapping("/storev2")
	public ModelAndView storev2( ) throws Exception {		
			 
		ModelAndView mv = new ModelAndView();
		 mv.setViewName("messages/view2");
		 System.out.print("storev2");
		// return mv;
		return new ModelAndView(
				"layout2", "customer",null				
				);
		
	}
	
	@RequestMapping("/storev3")
	public ModelAndView storev3( ) throws Exception {		
			 
		ModelAndView mv = new ModelAndView();
		 mv.setViewName("messages/view2");
		 System.out.print("storev3");
		// return mv;
		return new ModelAndView(
				"layout3", "customer",null				
				);
		
	}
	
	@RequestMapping("/storev4")
	public ModelAndView storev4( ) throws Exception {		
			 
		//ModelAndView mv = new ModelAndView();
		// mv.setViewName("messages/view2");
		 System.out.print("storev4 in layouts");
		// return mv;
		return new ModelAndView(
				"/layouts/layout4", "layout4",null				
				);
		
	}
	
	@RequestMapping("/storev5")
	public ModelAndView storev5( ) throws Exception {		
			 
		//ModelAndView mv = new ModelAndView();
		// mv.setViewName("messages/view2");
		 System.out.print("storev5");
		// return mv;
		return new ModelAndView(
				"layout5", "layout5",null				
				);
		
	}

}
