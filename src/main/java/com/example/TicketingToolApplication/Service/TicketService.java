package com.example.TicketingToolApplication.Service;

import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import com.example.TicketingToolApplication.DAO.ProjectDao;
import com.example.TicketingToolApplication.DAO.TicketDao;
import com.example.TicketingToolApplication.Models.Project;
import com.example.TicketingToolApplication.Models.Ticket;


@Service
public class TicketService {

	
	@Autowired
	public Ticket t;
	
	@Autowired
	public TicketDao td;
	
	@Autowired
	public ProjectDao pd;
	
	
	public ModelAndView registerTickets(Ticket t, String projId) {
		
		ModelAndView m=new ModelAndView("ticketDetails");
		
		ModelMap mp=new ModelMap();
		mp.addAttribute("ticketId",t.getTicketId());
		mp.addAttribute("ticketDesc",t.getTicketDesc());
		mp.addAttribute("ticketDate",t.getTicketDate());
		mp.addAttribute("projId",projId);
		m.addObject("ticketInfo",mp);
		
		td.registerTickets(t);
		
		return m;
	}


	public ModelAndView dashboard(Ticket t2, String projId) {
		ModelAndView mv=new ModelAndView("ticketViews");
		if(projId==null) 
			{
			mv.addObject("tickets",td.getAllTickets());
			}
		else {
			Optional<Project> project=pd.findProjectId(projId);
			Project p=project.get();
			p.getTlist().add(t2);
			mv.addObject("tickets",p.getTlist());
			}
		
		return mv;
		
	}

    public List<Ticket> getAllTickets() {
		
		List<Ticket> l=td.getAllTickets();
		return l;
	}


	public Optional<Ticket> getTicket(String ticketId) {
		
		Optional<Ticket> t= td.getTicket(ticketId);
		return t;
	}


	public String delTicket(String ticketId) {
	
		Optional<Ticket> t=td.getTicket(ticketId);
		if(t==null) return "Bad response";
		td.delTicket(ticketId);
		return "Ticket:"+ticketId+"is deleted!";
	}

}
