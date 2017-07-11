package com.dgit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.SimProject;
import com.dgit.service.SimProjectService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	SimProjectService service;
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String listAllGET(Model model) throws Exception{
		String resultStartDate = null;
		String resultEndDate = null;
		
		List<SimProject> list = service.selectList();
		
		SimpleDateFormat d_format = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<SimProject> viewSimProjectList = new ArrayList<SimProject>();
		
		for(SimProject s : list){
			resultStartDate = d_format.format(s.getStart_date());
			resultEndDate = d_format.format(s.getEnd_date());
			SimProject getData = new SimProject(s.getNumber(), s.getName(), 
					s.getContent(), resultStartDate, resultEndDate, s.getState());
			viewSimProjectList.add(getData);
		}
		
		model.addAttribute("viewSimProjectList", viewSimProjectList);
		return "simProjectList";
	}
}
