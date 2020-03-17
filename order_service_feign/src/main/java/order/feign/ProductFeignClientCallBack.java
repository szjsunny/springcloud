package order.feign;

import order.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientCallBack implements ProductFeignClient{
    @Override
    public Product findById(Long id) {
        Product product = new Product();
        product.setProductDesc("异常降级的方法");
        return product;
    }
}
