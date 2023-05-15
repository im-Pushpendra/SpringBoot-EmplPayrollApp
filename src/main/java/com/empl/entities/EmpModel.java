package com.empl.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@Entity
public class EmpModel {
	
		private String name;
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private  int id;    
	    private long salary;
	    private String gender;
	    private String startDate;
	    private String note;
	    private String profilePic;
	    private String department;

}

