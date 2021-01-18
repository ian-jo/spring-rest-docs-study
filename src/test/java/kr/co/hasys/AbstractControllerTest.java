package kr.co.hasys;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public abstract class AbstractControllerTest {

    @Autowired
    public WebApplicationContext context;

    @Autowired
    public ObjectMapper objectMapper;

    public RestDocumentationResultHandler document;

    public MockMvc mockMvc;

    @BeforeEach
    public void setup(RestDocumentationContextProvider restDocumentation) {
        this.document = document("{ClassName}/{methodName}", preprocessResponse(prettyPrint()));

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(restDocumentation).uris()
                        .withScheme("http")
                        .withHost("127.0.0.1")
                        .withPort(8080)
                )
                .build();
    }

}
