package com.example.TicketingToolApplication.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.TicketingToolApplication.Models.Project;
import com.example.TicketingToolApplication.Models.Ticket;
import com.example.TicketingToolApplication.Service.ProjectService;

@Controller
public class ProjectController {
	
	
	
	@Autowired
	public ProjectService projService;
	
	@Autowired
	public Project project;
	
	
	@RequestMapping("/ProjectGen")
	public String generateProject()
	{
		return "projectInputs";
	}
	
	@RequestMapping("/ProjectReg")
	public ModelAndView createProject(Project p)
	{
		ModelAndView mv=projService.createProject(p);
		
		return mv;
	}

	@GetMapping("/getAllTickets")
	public ResponseEntity<List<Project>> getAllTickets()
	{
		List<Project> l=projService.getAllProjects();
		
		return ResponseEntity.ok(l);
		
	}
	
	@GetMapping("/getProject/{projId}")
	public ResponseEntity<Optional<Project>> getTicket(@PathVariable String projId)
	{
		
		Optional<Project> t=projService.getProject(projId);
		
		return ResponseEntity.ok(t);
		
	}
	
	@DeleteMapping("/delProject/{projId}")
	public String delTicket(@PathVariable String projId)
	{
		
		return projService.delProject(projId);
	}
}
