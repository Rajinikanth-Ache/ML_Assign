package com.bhavna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bhavna.dao.ReporterDao;
import com.bhavna.entity.Channel;
import com.bhavna.entity.Reporter;

@Service
@Transactional
public class ReporterService {
	
	@Autowired
	ReporterDao dao;
	
	public List<Reporter> getReporters() {
		return dao.getReporters();
	}
	
	public void addReporter(Reporter repo) {
		 dao.addReporter(repo);
	}
}
