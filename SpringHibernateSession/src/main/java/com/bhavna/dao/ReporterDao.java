package com.bhavna.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhavna.entity.Channel;
import com.bhavna.entity.Reporter;

@Repository
public class ReporterDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
    @SuppressWarnings("unchecked")
    public List<Reporter> getReporters() {
    	Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Reporter").list();
    }
    
    public void addReporter(Reporter repo) {
    	Session session = sessionFactory.getCurrentSession();
        session.save(repo);
    }
	
}
