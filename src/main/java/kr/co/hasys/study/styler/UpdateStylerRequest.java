package kr.co.hasys.study.styler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateStylerRequest {
    private long id;
    private String name;
    private boolean active;
    private long shopId;
    private String greetings;
}
