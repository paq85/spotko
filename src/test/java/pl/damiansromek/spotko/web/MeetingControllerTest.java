package pl.damiansromek.spotko.web;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.UUID;

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
import pl.damiansromek.spotko.meeting.Meeting;
import pl.damiansromek.spotko.meeting.MeetingRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpotkoApplication.class)
@WebAppConfiguration
public class MeetingControllerTest {

// INFO: https://github.com/spring-projects/spring-mvc-showcase/blob/master/src/test/java/org/springframework/samples/mvc/form/FormControllerTests.java

	private MockMvc mvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Autowired
	MeetingRepository meetingRepo;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void showAll() throws Exception {
		ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/meetings/list"));
		actions.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1>Planned meetings</h1>")));
	}
	
	@Test
	public void show() throws Exception {
		Meeting meeting = new Meeting(UUID.randomUUID(), "The first meeting", LocalDateTime.now());
		meetingRepo.save(meeting);
		
		ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/meetings/show/" + meeting.getId()));
		actions.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1>The first meeting</h1>")));
	}
	
	@Test
	public void add() throws Exception {
		ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/meetings/add"));
		
		actions
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("<h1>Add a meeting</h1>")));
	}
	
	@Test
	public void save() throws Exception {
		ResultActions actions = mvc.perform(
				MockMvcRequestBuilders.post("/meetings/add")
					.param("id", UUID.randomUUID().toString())
					.param("name", "Event name")
					.param("startAt", "7/6/16 10:45 AM")
					.param("description", "")
				);
		
		actions
			.andExpect(status().is3xxRedirection());
	}
}
