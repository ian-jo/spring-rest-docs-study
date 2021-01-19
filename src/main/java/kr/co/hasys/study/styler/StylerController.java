package kr.co.hasys.study.styler;

import org.springframework.web.bind.annotation.*;

@RestController
public class StylerController {

    @GetMapping(value = "/stylers/{stylerId}")
    public StylerResponse getStyler(@PathVariable long stylerId) {
        return StylerResponse.builder()
                .id(stylerId)
                .name("이안")
                .active(true)
                .shopId(1L)
                .greetings("안녕하세요.")
                .build();
    }

    @PostMapping(value = "/stylers")
    public StylerResponse createStyler(@RequestBody StylerRequest stylerRequest) {
        return StylerResponse.builder()
                .id(1L)
                .name(stylerRequest.getName())
                .active(true)
                .shopId(stylerRequest.getShopId())
                .greetings(stylerRequest.getGreetings())
                .build();
    }

    @PutMapping(value = "/stylers")
    public StylerResponse updateStyler(@RequestBody UpdateStylerRequest updateStylerRequest) {
        return StylerResponse.builder()
                .id(updateStylerRequest.getId())
                .name(updateStylerRequest.getName())
                .active(updateStylerRequest.isActive())
                .shopId(updateStylerRequest.getShopId())
                .greetings(updateStylerRequest.getGreetings())
                .build();
    }

    @DeleteMapping(value = "/stylers/{stylerId}")
    public void deleteStyler(@PathVariable long stylerId) {
    }
}
