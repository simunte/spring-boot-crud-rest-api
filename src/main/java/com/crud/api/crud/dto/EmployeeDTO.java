package com.crud.api.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {
    private Long id;
    private String nik;
    private String name;
    private String alamat;
    @JsonProperty(value = "list_jabatan")
    private List<JabatanDTO> jabatans;
}
