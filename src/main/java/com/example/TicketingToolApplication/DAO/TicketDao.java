package com.example.TicketingToolApplication.DAO;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.TicketingToolApplication.Models.Ticket;
import com.example.TicketingToolApplication.Repo.TicketRepository;


@Component
public class TicketDao {
	
	@Autowired
	public TicketRepository repo;


	public void registerTickets(Ticket t) {
		repo.save(t);
		
	}

	public List<Ticket> getAllTickets() {
		
		List<Ticket> l=repo.findAll();		
		return l;
		
	}

	public java.util.Optional<Ticket> getTicket(String ticketId) {
		java.util.Optional<Ticket> t = repo.findById(ticketId);
		return t;
	}

	public void delTicket(String ticketId) {
		
		repo.deleteById(ticketId);
	}
	
}
