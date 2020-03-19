package com.crud.api.crud.controller;


import com.crud.api.crud.dto.EmployeeDTO;
import com.crud.api.crud.services.EmployeeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("employee")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        List<EmployeeDTO> employeeDTOS = employeeServices.getAllEmployee();
        return ResponseEntity.ok().body(employeeDTOS);
    }

    @GetMapping("employee/{nik}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmployeeDTO> getAllEmployee(@PathVariable String nik) {
        EmployeeDTO employeeDTOS = employeeServices.getEmployeeByNik(nik);
        return ResponseEntity.ok().body(employeeDTOS);
    }

    @PostMapping("employee")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws Exception{
        return ResponseEntity.ok().body(employeeServices.saveEmployee(employeeDTO));
    }

    @PutMapping("employee")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws Exception{
        return ResponseEntity.ok().body(employeeServices.saveEmployee(employeeDTO));
    }

    @DeleteMapping("employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok().body(employeeServices.deleteEmployee(id));
    }
}
