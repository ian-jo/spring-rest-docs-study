package kr.co.hasys.study.shop;

import kr.co.hasys.study.ServiceType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {

    @GetMapping(value = "/shops/{shopId}")
    public ShopResponse getShop(@PathVariable long shopId) {
        return ShopResponse.builder()
                .id(1L)
                .name("파란헤어")
                .serviceType(ServiceType.HAIR)
                .build();
    }

    @PostMapping(value = "/shops")
    public ShopResponse createShop(@RequestBody ShopRequest shopRequest) {
        return ShopResponse.builder()
                .id(1L)
                .name("파란헤어")
                .serviceType(ServiceType.HAIR)
                .build();
    }

    @PutMapping(value = "/shops")
    public ShopResponse updateShop(@RequestBody ShopRequest shopRequest) {
        return ShopResponse.builder()
                .id(1L)
                .name("파란헤어")
                .serviceType(ServiceType.HAIR)
                .build();
    }

    @DeleteMapping(value = "/shops")
    public void deleteShop(@RequestBody long shopId) {
    }
}
