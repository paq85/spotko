package pl.damiansromek.spotko.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.damiansromek.spotko.meeting.MeetingRepository;

@Controller
@RequestMapping("/meetings")
final class MeetingController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showAll(Model model) {
		model.addAttribute("foo", "To jest jakieś FOO");
		
		model.addAttribute("meetings", getMeetingRepo().findAll());
		
		return "meetings/list";
	}
	
	@RequestMapping(value="/{meetingId}", method=RequestMethod.GET)
	public String show(@PathVariable("meetingId") String meetingId, Model model) {
		model.addAttribute("meeting", getMeetingRepo().find(Integer.parseInt(meetingId)));
		
		return "meetings/show";
	}
	
	private MeetingRepository getMeetingRepo() {
		MeetingRepository meetingRepo = new MeetingRepository();
		
		return meetingRepo;
	}
}
