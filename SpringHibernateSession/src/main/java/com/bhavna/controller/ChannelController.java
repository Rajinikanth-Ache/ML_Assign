package com.bhavna.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.entity.Channel;
import com.bhavna.service.ChannelService;

@RestController
@RequestMapping("/channel")
public class ChannelController {

	@Autowired
	ChannelService serv;
	
	@RequestMapping(value="/get",method = RequestMethod.GET)
	public String get() {
		return "hello mr.bean";
	}
	
	@RequestMapping(value="/getChannels",method = RequestMethod.GET)
	public List<Channel> getChannels(){
		return serv.getChannels();
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Channel getChannel(@PathVariable Integer id) {
		return serv.getChannel(id);
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String addChannel(@RequestBody Channel channel) {
		serv.addChannel(channel);
		return "added";
	}
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Channel updateChannel(@RequestBody Channel channel) {
		return serv.updateChannel(channel);
	
	}
}
