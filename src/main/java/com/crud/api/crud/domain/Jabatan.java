package com.crud.api.crud.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jabatan")
public class Jabatan {
    private static final long serialVersionUID = -7369920601847524273L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "kode_jabatan")
    private String kodeJabatan;
    @Column(name = "nama_jabatan")
    private String namaJabatan;
    @Column(name = "keterangan_jabatan")
    private String keteranganJabatan;
}
