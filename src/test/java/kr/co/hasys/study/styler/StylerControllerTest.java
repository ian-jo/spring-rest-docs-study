package kr.co.hasys.study.styler;

import kr.co.hasys.AbstractControllerTest;
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

class StylerControllerTest extends AbstractControllerTest {

    @Test
    void getStyler() throws Exception {
        long stylerId = 1L;
        this.mockMvc
                .perform(get("/stylers/{stylerId}", stylerId))
                .andExpect(status().isOk())
                .andDo(document("get-styler",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("stylerId").description("디자이너 id")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("디자이너 id").attributes(getExampleAttribute(1)),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("디자이너명").attributes(getExampleAttribute("이안")),
                                fieldWithPath("active").type(JsonFieldType.BOOLEAN).description("활성 여부").attributes(getExampleAttribute("true")),
                                fieldWithPath("greetings").type(JsonFieldType.STRING).description("인사말").attributes(getExampleAttribute("안녕하세요.")).optional(),
                                fieldWithPath("shopId").type(JsonFieldType.NUMBER).description("매장 id").attributes(getExampleAttribute(1))
                        )
                ));
    }

    @Test
    void createStyler() throws Exception {
        StylerRequest stylerRequest = StylerRequest.builder().name("이안").greetings("안녕하세요.").shopId(1L).build();
        this.mockMvc
                .perform(
                        post("/stylers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(stylerRequest))
                )
                .andExpect(status().isOk())
                .andDo(document("create-styler",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("name").type(JsonFieldType.STRING).description("디자이너명").attributes(getExampleAttribute("이안")),
                                fieldWithPath("greetings").type(JsonFieldType.STRING).description("인사말").attributes(getExampleAttribute("안녕하세요.")).optional(),
                                fieldWithPath("shopId").type(JsonFieldType.NUMBER).description("매장 id").optional().attributes(getExampleAttribute(1))
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("디자이너 id").attributes(getExampleAttribute(1)),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("디자이너명").attributes(getExampleAttribute("이안")),
                                fieldWithPath("active").type(JsonFieldType.BOOLEAN).description("활성 여부").attributes(getExampleAttribute("true")),
                                fieldWithPath("greetings").type(JsonFieldType.STRING).description("인사말").attributes(getExampleAttribute("안녕하세요.")).optional(),
                                fieldWithPath("shopId").type(JsonFieldType.NUMBER).description("매장 id").attributes(getExampleAttribute(1))
                        )
                ));
    }

    @Test
    void updateStyler() throws Exception {
        UpdateStylerRequest updateStylerRequest = UpdateStylerRequest.builder().id(1L).name("이안").active(false).greetings("안녕하세요-2").shopId(2L).build();
        this.mockMvc
                .perform(
                        put("/stylers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(updateStylerRequest))
                )
                .andExpect(status().isOk())
                .andDo(document("update-styler",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("디자이너 id").attributes(getExampleAttribute(1)),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("디자이너명").attributes(getExampleAttribute("이안")),
                                fieldWithPath("active").type(JsonFieldType.BOOLEAN).description("활성 여부").attributes(getExampleAttribute("true")),
                                fieldWithPath("greetings").type(JsonFieldType.STRING).description("인사말").attributes(getExampleAttribute("안녕하세요.")).optional(),
                                fieldWithPath("shopId").type(JsonFieldType.NUMBER).description("매장 id").attributes(getExampleAttribute(1))
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("디자이너 id").attributes(getExampleAttribute(1)),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("디자이너명").attributes(getExampleAttribute("이안")),
                                fieldWithPath("active").type(JsonFieldType.BOOLEAN).description("활성 여부").attributes(getExampleAttribute("true")),
                                fieldWithPath("greetings").type(JsonFieldType.STRING).description("인사말").attributes(getExampleAttribute("안녕하세요.")).optional(),
                                fieldWithPath("shopId").type(JsonFieldType.NUMBER).description("매장 id").attributes(getExampleAttribute(1))
                        )
                ));
    }

    @Test
    void deleteStyler() throws Exception {
        long stylerId = 1;
        this.mockMvc
                .perform(
                        delete("/stylers/{stylerId}", stylerId)
                )
                .andExpect(status().isOk())
                .andDo(document("delete-styler",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("stylerId").description("디자이너 id")
                        )
                ));
    }
}