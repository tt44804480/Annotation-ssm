package com.test;

import com.config.DataSourceConfig;
import com.config.RootConfig;
import com.config.ServletConfig;
import com.project.service.TestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @author liutianyang
 * @create 2018-11-2018/11/29
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class,RootConfig.class, ServletConfig.class})
public class SpringTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    public void before(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test1() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/testController/test2")
                .param("userId", "liuliuliu")
                .param("pageNum", "1")
                .param("pageSize", "3")).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}
