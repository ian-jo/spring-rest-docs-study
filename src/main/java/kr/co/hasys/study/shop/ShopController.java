package kr.co.hasys.study.shop;

import kr.co.hasys.study.ServiceType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {

    @GetMapping(value = "/shops/{shopId}")
    public ShopResponse getShop(@PathVariable long shopId) {
        return ShopResponse.builder()
                .id(1L)
                .name("이안헤어")
                .serviceType(ServiceType.HAIR)
                .branchName("강남점")
                .build();
    }

    @PostMapping(value = "/shops")
    public ShopResponse createShop(@RequestBody ShopRequest shopRequest) {
        return ShopResponse.builder()
                .id(1L)
                .name(shopRequest.getName())
                .serviceType(shopRequest.getServiceType())
                .branchName(shopRequest.getBranchName())
                .build();
    }

    @PutMapping(value = "/shops")
    public ShopResponse updateShop(@RequestBody UpdateShopRequest updateShopRequest) {
        return ShopResponse.builder()
                .id(updateShopRequest.getId())
                .name(updateShopRequest.getName())
                .serviceType(updateShopRequest.getServiceType())
                .branchName(updateShopRequest.getBranchName())
                .build();
    }

    @DeleteMapping(value = "/shops/{shopId}")
    public void deleteShop(@PathVariable long shopId) {
    }
}
