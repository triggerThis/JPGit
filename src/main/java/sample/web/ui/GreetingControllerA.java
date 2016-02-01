package sample.web.ui;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.at.mul.domain.customer.Customer;
import com.at.mul.domain.order.Order;
import com.at.mul.service.StoreService;
import com.at.mul.service.StoreServiceImpl;

@RestController
//@ComponentScan
//@Scope("prototype")
@RequestMapping("/h") 
//@EnableAutoConfiguration  
public class GreetingControllerA {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting",method=RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/store",method=RequestMethod.GET)
    public Greeting store(@RequestParam(value="name", defaultValue="World") String name) throws Exception {
      
    	cOrderData();SpringContextUtils.getApplicationContext();
    	String s ="";
    	//s= SpringContextUtils.getBeanByClass(StoreServiceImpl.class).toString();
    	System.out.println(s);
    	return new Greeting(counter.incrementAndGet(),
                             String.format(template, name)  + Calendar.getInstance().getTime());
    }
    
  @Autowired
  private StoreService storeService;
  	private void cOrderData() throws Exception{
  		Customer c = new Customer();
  		c.setName("test" +  Calendar.SECOND + Calendar.getInstance().getTime());
  		c.setAge(30);

  		Order o = new Order();
  		o.setCode(1);
  		o.setQuantity(7);
  		
  		//StoreService storeService;
  		storeService.store(c, o);
  		
  	}
}
