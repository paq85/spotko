package pl.damiansromek.spotko.meeting;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;

public class MeetingRepository {
	HashMap<Integer, Meeting> meetings;
	
	public MeetingRepository() {
		meetings = new HashMap<Integer, Meeting>();
		
		Meeting meeting = new Meeting(1, "The first meeting", LocalDateTime.of(2015, 6, 13, 20, 45));
		meeting.setDescription("This will be a very exciting meeting.");
		meetings.put(meeting.getId(), meeting);
		
		meeting = new Meeting(2, "Meeting number two", LocalDateTime.of(2015, 7, 3, 10, 15));
		meeting.setDescription("Another cool meeting.");
		meetings.put(meeting.getId(), meeting);
	}
	
	public Collection<Meeting> findAll() {		
		return meetings.values();
	}
	
	public Meeting find(int meetingId) {
		return meetings.get(meetingId);
	}
}
