package com.nagarro.HRManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.HRManagement.dlo.EmployeeDetails;
import com.nagarro.HRManagement.repository.EmployeeDetailsRepository;

@Service
public class EmployeeServices {
	@Autowired
	EmployeeDetailsRepository er;

	public void addEmployee(EmployeeDetails ed) {
		er.save(ed);
	}

	public List<EmployeeDetails> populateList() {
		return er.findAll();
	}

	public void deleteEmployee(int employeeid) {
		er.deleteById(employeeid);
	}

	public boolean editDetails(EmployeeDetails newed) {
		EmployeeDetails olded = er.findById(newed.getEmployeeCode()).get();

		if (!newed.getName().isEmpty()) {
			newed.setName(olded.getName());
		}
		if (!newed.getEmail().isEmpty()) {
			newed.setEmail(olded.getEmail());
		}

		if (!newed.getDob().isEmpty()) {
			newed.setDob(olded.getDob());
		}
		if (!newed.getLocation().isEmpty()) {
			newed.setLocation(olded.getLocation());
		}
		System.out.println("in edit");
		er.delete(olded);
		er.save(newed);
		System.out.println(newed);
		return true;
	}
}
