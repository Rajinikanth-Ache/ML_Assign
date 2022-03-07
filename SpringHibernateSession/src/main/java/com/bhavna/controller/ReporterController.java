package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.entity.Channel;
import com.bhavna.entity.Reporter;
import com.bhavna.service.ReporterService;

@RestController
@RequestMapping("/reporter")
public class ReporterController {

	@Autowired
	ReporterService serv;
	
	@RequestMapping(value="/getRepo",method = RequestMethod.GET)
	public List<Reporter> getReporters(){
		return serv.getReporters();
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String addReporter( @RequestBody Reporter repo) {
		serv.addReporter(repo);
		return "added";
	}
}
