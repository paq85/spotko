package pl.damiansromek.spotko.meeting;

import java.time.LocalDateTime;

public class Meeting {
	private int id;
	
	private String name;
	
	private LocalDateTime startAt;
	
	private String description;
	
	public Meeting(int id, String name, LocalDateTime startAt)
	{
		this.id = id;
		this.name = name;
		this.startAt = startAt;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDateTime getStartAt() {
		return startAt;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
