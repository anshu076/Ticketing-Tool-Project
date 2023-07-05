package com.example.TicketingToolApplication.Service;

import java.util.*;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.example.TicketingToolApplication.DAO.ProjectDao;
import com.example.TicketingToolApplication.Models.Project;
import com.example.TicketingToolApplication.Models.Ticket;


@Service
public class ProjectService {

	
	@Autowired
	public ProjectDao projectDao;

	public ModelAndView createProject(Project p) {
		
		
		ModelAndView mv=new ModelAndView ("projectDetails");
		ModelMap mp=new ModelMap();
		
		mp.addAttribute("projName",p.getProjName());
		mp.addAttribute("projid",p.getProjId());
		mv.addObject("projectInfo",mp);
		
		projectDao.saveProject(p);
		
		return mv;
	
	}

	public void addTicketToProject(Ticket t, String projId) {
	
		Optional<Project> p=getProject(projId);
		Project pr=p.get();
		List<Ticket> l=pr.getTlist();
		l.add(t);
	}

	public List<Project> getAllProjects() {
		
		List<Project> p=projectDao.getAllProjects();
		return p;
		
	}

	public Optional<Project> getProject(String projId) {
		
		Optional<Project> p=projectDao.getProject(projId);
		
		return p;
	}

	public String delProject(String projId) {
		Optional<Project> p=projectDao.getProject(projId);
		if(p==null) return "Bad response";
		projectDao.delTicket(projId);
		return "Ticket:"+projId+"is deleted!";
	}

}
