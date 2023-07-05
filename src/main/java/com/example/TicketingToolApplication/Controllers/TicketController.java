package com.example.TicketingToolApplication.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.TicketingToolApplication.Models.Project;
import com.example.TicketingToolApplication.Models.Ticket;
import com.example.TicketingToolApplication.Service.ProjectService;
import com.example.TicketingToolApplication.Service.TicketService;

@Controller
public class TicketController {

	

	@Autowired
	public ProjectService projectService;
	
	@Autowired
	public TicketService ticketService;
	
	@Autowired
	public Project p;
	
	@RequestMapping("/Log")
	public String logTickets()
	{
		return "ticketInputs";
	}
	
	@PostMapping("/Register")
	public ModelAndView registerTickets(Ticket t, @RequestParam(value="projId") String projId)
	{
		ModelAndView m=ticketService.registerTickets(t,projId);
		projectService.addTicketToProject(t,projId);
		
		return m;
	}
	
	@RequestMapping("/view")
	public ModelAndView dashboard(Ticket t, @RequestParam(value="projId") String projId)
	{
		ModelAndView m=ticketService.dashboard(t,projId);
		
		return m;
	}
	
	@GetMapping("/getAllTickets")
	public ResponseEntity<List<Ticket>> getAllTickets()
	{
		List<Ticket> l=ticketService.getAllTickets();
		
		return ResponseEntity.ok(l);
		
	}
	
	@GetMapping("/getTicket/{ticketId}")
	public ResponseEntity<Optional<Ticket>> getTicket(@PathVariable String ticketId)
	{
		
		Optional<Ticket> t=ticketService.getTicket(ticketId);
		
		return ResponseEntity.ok(t);
		
	}
	
	@DeleteMapping("/delTicket/{ticketId}")
	public String delTicket(@PathVariable String ticketId)
	{
		
		return ticketService.delTicket(ticketId);
	}
	
	
	
	
}
