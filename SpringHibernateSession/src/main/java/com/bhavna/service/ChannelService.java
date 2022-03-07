package com.bhavna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bhavna.dao.ChannelDao;
import com.bhavna.entity.Channel;
import com.bhavna.entity.Reporter;

@Service
@Transactional
public class ChannelService {

	@Autowired
	ChannelDao dao;

	public List<Channel> getChannels() {
		return dao.getChannnels();
	}

	public Channel getChannel(Integer id) {
		return dao.getChannel(id);
	}
	
	public void addChannel(Channel ch) {
		 dao.addChannel(ch);
	}
	
	public Channel updateChannel(Channel ch) {
		return dao.updateChannel(ch);
	}
}
