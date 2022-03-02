package com.bhavna.oms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhavna.oms.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{

}
