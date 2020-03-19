package com.crud.api.crud;

import com.crud.api.crud.domain.Employee;
import com.crud.api.crud.domain.Jabatan;
import com.crud.api.crud.repositories.EmployeeRepository;
import com.crud.api.crud.repositories.JabatanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Bootstrap implements CommandLineRunner {

    private final JabatanRepository jabatanRepository;
    private final EmployeeRepository employeeRepository;

    public Bootstrap(JabatanRepository jabatanRepository, EmployeeRepository employeeRepository) {
        this.jabatanRepository = jabatanRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args){
        System.out.println("Start Boot Data");
//        this.addNewJabatan();
//        this.addEmployee();
        System.out.println("End Boot Data");
    }

    public void addNewJabatan(){
        Random random = new Random();
        List<String> jabatanList = new ArrayList<>();
        jabatanList.add("Supervisor");
        jabatanList.add("Manager");
        jabatanList.add("Pegawai Tetap");
        jabatanList.forEach(s -> {
            Jabatan jabatan = new Jabatan();
            jabatan.setKodeJabatan("Jab"+ random.nextInt(10));
            jabatan.setNamaJabatan(s);
            jabatan.setKeteranganJabatan(s);
            jabatanRepository.save(jabatan);
        });
    }

    public void addEmployee(){
        Employee employee = new Employee();
        employee.setNik("123");
        employee.setName("Johansen");
        employee.setAlamat("Jakarta");
        employeeRepository.save(employee);
    }
}
