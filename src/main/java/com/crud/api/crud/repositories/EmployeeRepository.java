package com.crud.api.crud.repositories;

import com.crud.api.crud.domain.Employee;
import com.crud.api.crud.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Optional<Employee> findByNik(String nik);
}
