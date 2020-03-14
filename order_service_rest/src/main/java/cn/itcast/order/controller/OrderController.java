package cn.itcast.order.controller;

import cn.itcast.order.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    //@HystrixCommand(fallbackMethod = "orderFallBack")
    @HystrixCommand //就算有默认的@DefaultProperties,也需要这个注解,我认为他的意思就是为这个类所有的@HystrixCommand增添Properties
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        Product product = restTemplate.getForObject("http://service-product/product/1", Product.class);
        return product;
    }

    //在里面写熔断的方法,参数可以拿到被熔断方法的,返回值需要和被保护的方法一致
    public Product orderFallBack(Long id){
        Product product = new Product();
        product.setId(id);
        product.setProductDesc("触发熔断降级的方法");
        return product;
    }

    public Product defaultFallback(){
        Product product = new Product();
        product.setProductDesc("===全局的===触发熔断降级的方法");
        return product;
    }

}
