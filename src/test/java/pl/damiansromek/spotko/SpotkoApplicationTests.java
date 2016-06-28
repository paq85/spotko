package pl.damiansromek.spotko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpotkoApplication.class)
@WebAppConfiguration
public class SpotkoApplicationTests {

	@Test
	public void contextLoads() {
		assertTrue("It should pass", true);
	}

}
