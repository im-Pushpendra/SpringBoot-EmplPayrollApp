package com.empl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empl.entities.EmpModel;

@Repository
public interface EmpRepo extends JpaRepository<EmpModel,Integer> {
	

}
