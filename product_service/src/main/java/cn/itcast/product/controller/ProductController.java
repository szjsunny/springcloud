package cn.itcast.product.controller;

import cn.itcast.product.entity.Product;
import cn.itcast.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		Product product = productService.findById(id);
		return product;
	}

	@RequestMapping(value = "",method = RequestMethod.POST)
	public String save(@RequestBody Product product) {
		productService.save(product);
		return "保存成功";
	}

	@Value("${name}")
	private String name;

	@RequestMapping(value = "/test")
	public String test() {
		return name;
	}
}
