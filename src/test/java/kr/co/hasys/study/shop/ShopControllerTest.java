package kr.co.hasys.study.shop;

import kr.co.hasys.AbstractControllerTest;
import kr.co.hasys.study.ServiceType;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import static kr.co.hasys.DocsAttributeProvider.getExampleAttribute;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ShopControllerTest  extends AbstractControllerTest {

    @Test
    public void getShop() throws Exception {
        long shopId = 1L;
        this.mockMvc
                .perform(get("/shops/{shopId}", shopId))
                .andExpect(status().isOk())
                .andDo(document("get-shop",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("shopId").description("매장 id")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("매장 id").attributes(getExampleAttribute(1)),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("매장명").attributes(getExampleAttribute("이안헤어")),
                                fieldWithPath("serviceType").type(JsonFieldType.STRING).description("서비스 종류").attributes(getExampleAttribute("HAIR")),
                                fieldWithPath("branchName").type(JsonFieldType.STRING).description("지점명").optional().attributes(getExampleAttribute("강남점"))
                        )
                ));

    }

    @Test
    void createShop() throws Exception {
        ShopRequest shopRequest = ShopRequest.builder().name("이안헤어").serviceType(ServiceType.HAIR).branchName("강남점").build();
        this.mockMvc
                .perform(
                        post("/shops")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shopRequest))
                )
                .andExpect(status().isOk())
                .andDo(document("create-shop",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("name").type(JsonFieldType.STRING).description("매장명").attributes(getExampleAttribute("이안헤어")),
                                fieldWithPath("serviceType").type(JsonFieldType.STRING).description("서비스 종류").attributes(getExampleAttribute("HAIR")),
                                fieldWithPath("branchName").type(JsonFieldType.STRING).description("지점명").optional().attributes(getExampleAttribute("강남점"))
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("매장 id").attributes(getExampleAttribute(1)),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("매장명").attributes(getExampleAttribute("이안헤어")),
                                fieldWithPath("serviceType").type(JsonFieldType.STRING).description("서비스 종류").attributes(getExampleAttribute("HAIR")),
                                fieldWithPath("branchName").type(JsonFieldType.STRING).description("지점명").optional().attributes(getExampleAttribute("강남점"))
                        )
                ));
    }

    @Test
    void updateShop() throws Exception {
        UpdateShopRequest updateShopRequest = UpdateShopRequest.builder().id(1L).name("이안헤어-2").serviceType(ServiceType.NAIL).branchName("교대점").build();
        this.mockMvc
                .perform(
                        put("/shops")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(updateShopRequest))
                )
                .andExpect(status().isOk())
                .andDo(document("update-shop",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("매장 id").attributes(getExampleAttribute(1)),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("매장명").attributes(getExampleAttribute("이안헤어-2")),
                                fieldWithPath("serviceType").type(JsonFieldType.STRING).description("서비스 종류").attributes(getExampleAttribute("NAIL")),
                                fieldWithPath("branchName").type(JsonFieldType.STRING).description("지점명").optional().attributes(getExampleAttribute("교대점"))
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("매장 id").attributes(getExampleAttribute(1)),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("매장명").attributes(getExampleAttribute("이안헤어-2")),
                                fieldWithPath("serviceType").type(JsonFieldType.STRING).description("서비스 종류").attributes(getExampleAttribute("NAIL")),
                                fieldWithPath("branchName").type(JsonFieldType.STRING).description("지점명").optional().attributes(getExampleAttribute("교대점"))
                        )
                ));
    }

    @Test
    void deleteShop() throws Exception {
        long shopId = 1;
        this.mockMvc
                .perform(
                        delete("/shops/{shopId}", shopId)
                )
                .andExpect(status().isOk())
                .andDo(document("delete-shop",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("shopId").description("매장 id")
                        )
                ));
    }
}