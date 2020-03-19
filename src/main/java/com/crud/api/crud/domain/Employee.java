package com.crud.api.crud.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    private static final long serialVersionUID = -7369920601847524273L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nik;
    private String name;
    private String alamat;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_jabatan",
            joinColumns =
            @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "jabatan_id", referencedColumnName = "id")
    )
    private List<Jabatan> jabatans;
}
