package com.zk.demo;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: garychen
 * @Date: 2018/7/18 16:40
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestNGDemo {


    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("custom");

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void test01() throws Exception {
            //RestDocumentationResultHandler
            String ss = "{\"str\":\"abcdefg\"}";
            this.mockMvc.perform(post("/api/test")
                    .param("str","aaaaa")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(ss)
                    )
                    .andExpect(status().isOk())
                    .andDo(document("index",
                            requestParameters(
                                    parameterWithName("str").description("入参")
                            )
                            )
                    );
    }
}
