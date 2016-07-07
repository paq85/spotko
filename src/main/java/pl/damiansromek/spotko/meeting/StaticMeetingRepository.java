package pl.damiansromek.spotko.meeting;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class StaticMeetingRepository {
	HashMap<UUID, Meeting> meetings;
	
	public StaticMeetingRepository() {
		meetings = new HashMap<UUID, Meeting>();
		
		Meeting meeting = new Meeting(UUID.randomUUID(), "The first meeting", LocalDateTime.of(2015, 6, 13, 20, 45));
		meeting.setDescription("This will be a very exciting meeting.");
		meetings.put(meeting.getId(), meeting);
		
		meeting = new Meeting(UUID.randomUUID(), "Meeting number two", LocalDateTime.of(2015, 7, 3, 10, 15));
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
