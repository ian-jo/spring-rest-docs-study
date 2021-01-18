package kr.co.hasys.study.shop;

import kr.co.hasys.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
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
                .andDo(document.document(
                        pathParameters(
                                parameterWithName("shopId").description("매장 id")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("매장 id"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("매장명")
                        )
                ));
    }
}