package pl.damiansromek.spotko.meeting;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Meeting {

	@Id
	@org.hibernate.annotations.Type(type="pg-uuid")
	private UUID id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private LocalDateTime startAt;
	
	@Column(nullable = true)
	private String description;
	
	public Meeting(UUID id, String name, LocalDateTime startAt)
	{
		this.id = id;
		this.name = name;
		this.startAt = startAt;
	}
	
	private Meeting() {
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setStartAt(LocalDateTime startAt) {
		this.startAt = startAt;
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
