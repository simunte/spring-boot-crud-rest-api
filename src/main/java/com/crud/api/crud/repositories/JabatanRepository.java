package com.crud.api.crud.repositories;

import com.crud.api.crud.domain.Jabatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JabatanRepository extends JpaRepository<Jabatan, Long>{
}
