package cn.tedu.back.stage.management.account.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * Author = lee
 * DATE   = 2023/6/20  23:27
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void addNew()throws Throwable {
        String url = "/content/users/add-new";

        String name = "茶叶标签";
        String userId = "1";

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .param("name", name)
                .param("enable", userId)

                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()
                );


    }

}