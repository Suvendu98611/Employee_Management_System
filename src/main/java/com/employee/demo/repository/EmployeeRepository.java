package com.employee.demo.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.demo.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE "
            + "CONCAT(e.id, '') LIKE %:searchQuery% "
            + "OR e.firstName LIKE %:searchQuery% "
            + "OR e.lastName LIKE %:searchQuery% "
            + "OR e.email LIKE %:searchQuery% "
            + "OR e.role LIKE %:searchQuery% "
            + "OR CONCAT(e.dateOfJoining, '') LIKE %:searchQuery%")
    List<Employee> searchEmployees(@Param("searchQuery") String searchQuery);
    Optional<Employee> findByEmployeeId(String employeeId);
    Optional<Employee> findByEmail(String email);
}




