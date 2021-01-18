package kr.co.hasys.study.shop;

import kr.co.hasys.AbstractControllerTest;
import kr.co.hasys.study.ServiceType;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ShopControllerTest  extends AbstractControllerTest {

    @Test
    public void getShop() throws Exception {
        long shopId = 1L;
        this.mockMvc
                .perform(get("/shops/{shopId}", shopId))
                .andExpect(status().isOk())
                .andDo(document.document(
                        pathParameters(
                                parameterWithName("shopId").description("매장 id")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("매장 id"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("매장명"),
                                fieldWithPath("serviceType").type(ServiceType.class).description("서비스 종류")
                        )
                ));
    }

    @Test
    void createShop() throws Exception {
        ShopRequest shopRequest = ShopRequest.builder().name("파란헤어").serviceType(ServiceType.HAIR).build();
        this.mockMvc
                .perform(
                        post("/shops")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shopRequest))
                )
                .andExpect(status().isOk())
                .andDo(document.document(
                        requestFields(
                                fieldWithPath("name").type(JsonFieldType.STRING).description("매장명"),
                                fieldWithPath("serviceType").type(ServiceType.class)
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("매장 id"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("매장명"),
                                fieldWithPath("serviceType").type(ServiceType.class).description("서비스 종류")
                        )
                ))
                .andExpect(jsonPath("id", is(notNullValue())));
    }

//    @Test
//    void updateShop() {
//    }
//
//    @Test
//    void deleteShop() {
//    }
}