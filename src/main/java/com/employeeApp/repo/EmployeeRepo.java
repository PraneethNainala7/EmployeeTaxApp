package com.employeeApp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeeApp.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from employee where to_char(date_of_joining,'yyyy-mm')  between :fyFrom and :fyTo", nativeQuery = true)
	public Optional<List<Employee>> getEmployeeData(@Param("fyFrom") String fyFrom, @Param("fyTo") String fyTo);
}
