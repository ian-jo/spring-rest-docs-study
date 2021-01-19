package kr.co.hasys.study.styler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StylerResponse {
    private Long id;
    private String name;
    private Boolean active;
    private Long shopId;
    private String greetings;
}
