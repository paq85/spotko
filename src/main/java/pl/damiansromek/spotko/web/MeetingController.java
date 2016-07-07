package pl.damiansromek.spotko.web;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.damiansromek.spotko.meeting.Meeting;
import pl.damiansromek.spotko.meeting.MeetingRepository;

@Controller
@RequestMapping("/meetings")
final class MeetingController {
	
	MeetingRepository meetingRepo;
	
	@Autowired
	public MeetingController(MeetingRepository meetingRepo) {
		this.meetingRepo = meetingRepo;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showAll(Model model) {
		model.addAttribute("foo", "To jest jakieś FOO");
		
		model.addAttribute("meetings", getMeetingRepo().findAll());
		
		return "meetings/list";
	}
	
	@RequestMapping(value="/show/{meetingId}", method=RequestMethod.GET)
	public String show(@PathVariable("meetingId") String meetingId, Model model) {
		model.addAttribute("meeting", getMeetingRepo().findOne(UUID.fromString(meetingId)));
		
		return "meetings/show";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addMeeting(Model model) {
		model.addAttribute("meeting", new Meeting(UUID.randomUUID(), "", LocalDateTime.now()));
		
		return "meetings/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveMeeting(@ModelAttribute Meeting meeting, Model model) {
		getMeetingRepo().save(meeting);
		
		return "redirect:/meetings/show/" + meeting.getId();
	}
	
	private MeetingRepository getMeetingRepo() {
		return this.meetingRepo;
	}
}
