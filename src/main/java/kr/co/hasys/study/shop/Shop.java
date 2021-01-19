package kr.co.hasys.study.shop;

import kr.co.hasys.study.ServiceType;
import lombok.Data;

@Data
public class Shop {
    private long id;
    private String name;
    private ServiceType serviceType;
    private String branchName;
}
