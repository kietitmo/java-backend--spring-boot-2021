package com.kietnguyen.kotiki.web;

import com.kietnguyen.enums.CatBreed;
import com.kietnguyen.enums.CatColor;
import com.kietnguyen.models.Cat;
import com.kietnguyen.services.impl.CatServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
public class ControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private JacksonTester<List<Cat>> jsCat;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @MockBean
    private CatServiceImpl catService;

    @Test
    public void getCatsByColor_Exist() throws Exception {
        Cat cat1 = new Cat();
        cat1.setColor(CatColor.RED);
        Cat cat2 = new Cat();
        cat1.setColor(CatColor.RED);

        // given
        given(catService.getCatByColor(CatColor.RED))
                .willReturn(Arrays.asList(cat1, cat2));

        // when
        String url = "http://localhost:8080/cat/getByColor?color=RED";
        MockHttpServletResponse response = mockMvc.perform(get(url)
                        .accept(MediaType.APPLICATION_JSON))
                        .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsCat.write(Arrays.asList(cat1, cat2)).getJson()
        );
    }

    @Test
    public void getCatsByBreed_Exist() throws Exception {
        Cat cat1 = new Cat();
        cat1.setBreed(CatBreed.AUSTRALIAN);
        Cat cat2 = new Cat();
        cat1.setBreed(CatBreed.AUSTRALIAN);

        // given
        given(catService.getCatByBreed(CatBreed.AUSTRALIAN))
                .willReturn(Arrays.asList(cat1, cat2));

        // when
        String url = "http://localhost:8080/cat/getByBreed?breed=AUSTRALIAN";
        MockHttpServletResponse response = mockMvc.perform(get(url)
                        .accept(MediaType.APPLICATION_JSON))
                        .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsCat.write(Arrays.asList(cat1, cat2)).getJson());
    }

    @Test
    public void getCatsByBreed_NotExist() throws Exception {
        // given
        given(catService.getCatByBreed(CatBreed.AUSTRALIAN))
                .willReturn(null);

        // when
        String url = "http://localhost:8080/cat/getByBreed?breed=AUSTRALIAN";
        MockHttpServletResponse response = mockMvc.perform(get(url)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("");
    }

    @Test
    public void getCatsByColor_NotExist() throws Exception {
        // given
        given(catService.getCatByColor(CatColor.RED))
                .willReturn(null);

        // when
        String url = "http://localhost:8080/cat/getByColor?color=RED";
        MockHttpServletResponse response = mockMvc.perform(get(url)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("");
    }
}
