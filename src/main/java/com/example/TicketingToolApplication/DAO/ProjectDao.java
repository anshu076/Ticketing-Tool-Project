package com.example.TicketingToolApplication.DAO;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.TicketingToolApplication.Models.Project;
import com.example.TicketingToolApplication.Models.Ticket;
import com.example.TicketingToolApplication.Repo.ProjectRepository;


@Component
public class ProjectDao {     
	
	@Autowired
	public ProjectRepository projectRepo;


	public Optional<Project> findProjectId(String projId) {
	
		java.util.Optional<com.example.TicketingToolApplication.Models.Project> p=projectRepo.findById(projId);
		
		return p;
		
	}


	public void saveProject(Project p) {
	
		projectRepo.save(p);
		
	}


	public Optional<Project> getProject(String projId) {
		
		Optional<Project> p=projectRepo.findById(projId);
		return null;
	}


	public void delTicket(String projId) {
		
		projectRepo.deleteById(projId);
		
	}


	public List<Project> getAllProjects() {
		List<Project> p=projectRepo.findAll();		
		return p;
		
	}

}
