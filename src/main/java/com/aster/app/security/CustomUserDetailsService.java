package com.aster.app.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aster.app.entity.Employee;
import com.aster.app.repo.EmployeeRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<Employee> employees=this.employeeRepo.findByUserName(username);
		if(employees.size()>0) {
			return new CustomEmployee(employees.get(0));
		}
		else {
			throw new UsernameNotFoundException("Username not found");
		}
	}
	

}
