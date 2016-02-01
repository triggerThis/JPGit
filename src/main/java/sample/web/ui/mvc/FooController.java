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
@RequestMapping("/")
public class FooController {
	//private final MessageRepository messageRepository;
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
}
