package com.bhavna.oms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bhavna.oms.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>{


}
