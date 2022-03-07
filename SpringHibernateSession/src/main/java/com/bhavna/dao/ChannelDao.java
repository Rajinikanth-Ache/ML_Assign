package com.bhavna.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhavna.entity.Channel;
import com.bhavna.entity.Reporter;

@Repository
public class ChannelDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
    @SuppressWarnings("unchecked")
    public List<Channel> getChannnels() {
    	Session session = sessionFactory.openSession();
        List<Channel> res= session.createQuery("from Channel").list();
        session.close();
        return res;
       
    }
    
    public Channel getChannel(Integer id) {
    	Session session = sessionFactory.openSession();
    	Channel ch = (Channel) session.get(Channel.class, id);
    	session.close();
        return ch;
    }
    
    public void addChannel(Channel ch) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
        session.save(ch);
    	session.getTransaction().commit();
    	session.close();
    }
    
    
    public Channel updateChannel(Channel ch) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
        session.saveOrUpdate(ch);
    	session.getTransaction().commit();
    	session.close();
    	return ch;
    }
    
    

}
