package kr.co.hasys.study.shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @GetMapping(value = "/shops/{shopId}")
    public Shop getShop(@PathVariable String shopId) {
        Shop shop = new Shop();
        shop.setId(1L);
        shop.setName("매장명");
        return shop;
    }
}
