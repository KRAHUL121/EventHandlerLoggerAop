package com.kgisl.Eventhandler.Eventhandler.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Event  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long eventId;

	@Column
	private int edition;

	@Column
	private String date;

	@Column
	private String location;

	@Column
	private Boolean isActive;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "eventId")
	private List<Agenda> agenda;
	//private Agenda ag;

	
	

	public Long getId() {
		return eventId;
	}

	public void setId(Long eventId) {
		this.eventId = eventId;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}

}