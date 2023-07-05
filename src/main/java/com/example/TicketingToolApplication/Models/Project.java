package com.example.TicketingToolApplication.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Project {


	public Project(String projId, String projName, List<Ticket> tlist) {
		super();
		this.projId = projId;
		this.projName = projName;
		this.tlist = tlist;
	}
	@Id
	@GeneratedValue
	private String projId;
	private String projName;
	private List<Ticket> tlist;
	
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		projName = projName;
	}
	public List<Ticket> getTlist() {
		return tlist;
	}
	public void setTlist(List<Ticket> tlist) {
		this.tlist = tlist;
	}
	@Override
	public String toString() {
		return "Project [ProjId=" + projId + ", ProjName=" + projName + ", tlist=" + tlist + "]";
	}

}
