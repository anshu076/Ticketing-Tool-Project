package com.example.TicketingToolApplication.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {

	public Ticket(String ticketId, String ticketDesc, String ticketDate) {
		super();
		this.ticketId = ticketId;
		this.ticketDesc = ticketDesc;
		this.ticketDate = ticketDate;
	}

	@Id
	@GeneratedValue
	private String ticketId;
	private String ticketDesc;
	private String ticketDate;
	
	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketDesc() {
		return ticketDesc;
	}

	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}

	public String getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketDesc=" + ticketDesc + ", ticketDate=" + ticketDate + "]";
	}

}
