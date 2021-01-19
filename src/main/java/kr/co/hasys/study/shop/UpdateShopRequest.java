package kr.co.hasys.study.shop;

import kr.co.hasys.study.ServiceType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateShopRequest {
    private long id;
    private String name;
    private ServiceType serviceType;
    private String branchName;
}
