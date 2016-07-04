package pl.damiansromek.spotko.web;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.damiansromek.spotko.SpotkoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpotkoApplication.class)
@WebAppConfiguration
public class MeetingControllerTest {

	private MockMvc mvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void showAll() throws Exception {
		ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/meetings/"));
		actions.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1>Planned meetings</h1>")));
	}
	
	public void show() throws Exception {
		ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/meetings/1"));
		actions.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1>The first meeting</h1>")));
	}
}
