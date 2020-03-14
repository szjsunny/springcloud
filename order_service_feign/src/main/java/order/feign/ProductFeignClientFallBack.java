package order.feign;

import order.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientFallBack implements ProductFeignClient{

    /**
     * 这个方法就是熔断降级的方法
     */
    @Override
    public Product findById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setProductDesc("熔断降级的方法");
        return product;
    }
}
