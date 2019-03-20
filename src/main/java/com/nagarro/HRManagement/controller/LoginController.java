package com.nagarro.HRManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.HRManagement.dlo.EmployeeDetails;
import com.nagarro.HRManagement.service.EmployeeServices;
import com.nagarro.HRManagement.service.UserServices;

@RestController
public class LoginController {

	@Autowired
	UserServices us;

	@Autowired
	EmployeeServices es;

	@RequestMapping(value = { "/login" })
	public ResponseEntity<String> userAuthentication(@RequestParam String username, @RequestParam String password) {
		System.out.println(username);
		
		if (us.authenticate(username, password)) {
			System.out.println("here");
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("failure", HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = { "/list" })
	public List<EmployeeDetails> getList() {
		System.out.println(es.populateList());
		return es.populateList();
	}

	@RequestMapping(value = { "EmployeeServices" })
	public List<EmployeeDetails> addEmployee(@ModelAttribute("emplyeeDetails") EmployeeDetails ed) {
		es.addEmployee(ed);
		return getList();
	}

	@RequestMapping(value = { "DeleteEmployee" })
	public List<EmployeeDetails> deleteEmployee(@RequestParam("employeeid") int employeeid) {
		es.deleteEmployee(employeeid);
		return getList();
	}

	@RequestMapping(value = { "/editdetails" })
	public List<EmployeeDetails> editEmployeeDetails(@RequestParam String empCode,@RequestParam String empName,@RequestParam String empLoc,
			@RequestParam String empMail,@RequestParam String empDob) {
		EmployeeDetails ed=new EmployeeDetails();
		System.out.println(empCode);
		System.out.println(empName);
		ed.setEmployeeCode(Integer.parseInt(empCode));
		ed.setName(empName);
		ed.setLocation(empLoc);
		ed.setEmail(empMail);
		ed.setDob(empDob);
		es.editDetails(ed);
		System.out.println("in empolyee edit");
		return getList();
	}
}
