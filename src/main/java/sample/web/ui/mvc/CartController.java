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

package sample.web.ui.mvc;

import javax.validation.Valid;

import sample.web.ui.Message;
import sample.web.ui.MessageRepository;

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

import com.at.mul.domain.customer.Customer;
import com.at.mul.domain.order.Order;
import com.at.mul.service.StoreService;

/**
 * @author Rob Winch
 */
@Controller
@RequestMapping("/Cart")

public class CartController {
	private final MessageRepository messageRepository;

	@Autowired
	public CartController(MessageRepository messageRepository) {
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
	
	
	@RequestMapping("store")
	public ModelAndView store( ) throws Exception {
		
		cOrderData();
		
		////return "messages/view2";
		//	cOrderData()
		//		);
		return new ModelAndView(
				new RedirectView("messages/view2"), "customer",
				cOrderData()
				);
	}
	
	@RequestMapping("storeS")
	public String storeS( ) throws Exception {
		
		cOrderData();
		
		return "messages/view2";
		//return new ModelAndView("messages/view2", "customer",
		//		cOrderData()
		//		);
	}
	
	@RequestMapping("storeL")
	public ModelAndView storeL( ) throws Exception {		
		cOrderData();	 
		ModelAndView mv = new ModelAndView();
		 mv.setViewName("messages/view2");//layout2");
		 
		// return mv;
		return new ModelAndView(
				"messages/view2", "customer",
				cOrderData()
				);
		
	}
	@RequestMapping("storev2")
	public ModelAndView storev2( ) throws Exception {		
		cOrderData();	 
		ModelAndView mv = new ModelAndView();
		 mv.setViewName("messages/view2");
		 System.out.print("storev2");
		// return mv;
		return new ModelAndView(
				"layout2", "customer",
				cOrderData()
				);
		
	}
	//@Autowired
		//private StoreService storeService;
	private Customer cOrderData() throws Exception{
		Customer c = new Customer();
		c.setName("test");
		c.setAge(30);
		c.setId(100);

		Order o = new Order();
		o.setCode(1);
		o.setQuantity(7);
		
		return c;
		//StoreService storeService;
		//storeService.store(c, o);
		
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
		
		Iterable<Message> messages = this.messageRepository.findAll();
		return new ModelAndView("messages/list", "messages", messages);
	}

}
