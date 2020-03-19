package com.crud.api.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JabatanDTO {
    private Long id;
    @JsonProperty(value = "kode_jabatan")
    private String kodeJabatan;
    @JsonProperty(value = "nama_jabatan")
    private String namaJabatan;
    @JsonProperty(value = "keterangan_jabatan")
    private String keteranganJabatan;
}
