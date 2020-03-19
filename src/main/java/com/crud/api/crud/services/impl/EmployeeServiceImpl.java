package com.crud.api.crud.services.impl;

import com.crud.api.crud.domain.Employee;
import com.crud.api.crud.domain.Jabatan;
import com.crud.api.crud.dto.EmployeeDTO;
import com.crud.api.crud.dto.JabatanDTO;
import com.crud.api.crud.repositories.EmployeeRepository;
import com.crud.api.crud.repositories.JabatanRepository;
import com.crud.api.crud.services.EmployeeServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeServices{
    private final EmployeeRepository employeeRepository;
    private final JabatanRepository jabatanRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, JabatanRepository jabatanRepository) {
        this.employeeRepository = employeeRepository;
        this.jabatanRepository = jabatanRepository;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository.findAll().stream().map(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setNik(employee.getNik());
            employeeDTO.setName(employee.getName());
            employeeDTO.setAlamat(employee.getAlamat());
            employeeDTO.setJabatans(
                    employee.getJabatans().stream().map(jabatan -> {
                        JabatanDTO jabatanDTO = new JabatanDTO();
                        jabatanDTO.setId(jabatan.getId());
                        jabatanDTO.setKodeJabatan(jabatan.getKodeJabatan());
                        jabatanDTO.setNamaJabatan(jabatan.getNamaJabatan());
                        jabatanDTO.setKeteranganJabatan(jabatan.getKeteranganJabatan());
                        return jabatanDTO;
                    }).collect(Collectors.toCollection(LinkedList::new))
            );
            return employeeDTO;
        }).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public EmployeeDTO getEmployeeByNik(String nik) {
        return employeeRepository.findByNik(nik).map(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setNik(employee.getNik());
            employeeDTO.setName(employee.getName());
            employeeDTO.setAlamat(employee.getAlamat());
            employeeDTO.setJabatans(
                    employee.getJabatans().stream().map(jabatan -> {
                        JabatanDTO jabatanDTO = new JabatanDTO();
                        jabatanDTO.setId(jabatan.getId());
                        jabatanDTO.setKodeJabatan(jabatan.getKodeJabatan());
                        jabatanDTO.setNamaJabatan(jabatan.getNamaJabatan());
                        jabatanDTO.setKeteranganJabatan(jabatan.getKeteranganJabatan());
                        return jabatanDTO;
                    }).collect(Collectors.toCollection(LinkedList::new))
            );
            return employeeDTO;
        }).get();
    }

    @Override
    public Boolean saveEmployee(EmployeeDTO employeeDTO) throws Exception {
        if (employeeDTO.getId() == null){
            Employee employee = new Employee();
            employee.setNik(employeeDTO.getNik());
            employee.setName(employeeDTO.getName());
            employee.setAlamat(employeeDTO.getAlamat());
            employee.setJabatans(
                    employeeDTO.getJabatans().stream().map(jabatanDTO -> {
                    Optional<Jabatan> jabatan = jabatanRepository.findById(jabatanDTO.getId());
                    if (!jabatan.isPresent()){
                        try {
                            throw new Exception("Jabatan with id : "+jabatanDTO.getId()+" Not Found");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return jabatan.get();
                }).collect(Collectors.toCollection(LinkedList::new))
            );
            employeeRepository.save(employee);
        }else {
            Employee employee = employeeRepository.findById(employeeDTO.getId()).orElseThrow(()->new Exception("Employee Not Found"));
            employee.setNik(employeeDTO.getNik());
            employee.setName(employeeDTO.getName());
            employee.setAlamat(employeeDTO.getAlamat());
            employee.setJabatans(
                    employeeDTO.getJabatans().stream().map(jabatanDTO -> {
                        Optional<Jabatan> jabatan = jabatanRepository.findById(jabatanDTO.getId());
                        if (!jabatan.isPresent()){
                            try {
                                throw new Exception("Jabatan with id : "+jabatanDTO.getId()+" Not Found");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        return jabatan.get();
                    }).collect(Collectors.toCollection(LinkedList::new))
            );
            employeeRepository.save(employee);
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        employeeRepository.delete(employeeRepository.findById(id).get());
        return Boolean.TRUE;
    }
}
