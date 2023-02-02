package com.aster.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aster.app.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

	List<Employee> findByUserName(String username);
	
}
