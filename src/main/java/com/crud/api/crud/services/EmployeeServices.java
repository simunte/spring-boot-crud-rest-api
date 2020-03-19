package com.crud.api.crud.services;


import com.crud.api.crud.dto.EmployeeDTO;

import javax.swing.text.StyledEditorKit;
import java.util.List;

public interface EmployeeServices {
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getEmployeeByNik(String nik);
    Boolean saveEmployee(EmployeeDTO employeeDTO) throws Exception;
    Boolean deleteEmployee(Long id);
}
