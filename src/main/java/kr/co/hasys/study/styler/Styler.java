package kr.co.hasys.study.styler;

import lombok.Data;

@Data
public class Styler {
    private long id;
    private String name;
    private boolean active;
    private long shopId;
    private String greetings;
}
