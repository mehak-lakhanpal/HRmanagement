package com.nagarro.HRManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.HRManagement.dlo.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

}
