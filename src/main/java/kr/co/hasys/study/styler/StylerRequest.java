package kr.co.hasys.study.styler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StylerRequest {
    private String name;
    private long shopId;
    private String greetings;
}
