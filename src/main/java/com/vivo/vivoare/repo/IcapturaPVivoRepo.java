package com.vivo.vivoare.repo;

import com.vivo.vivoare.model.capturaPantallaVivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IcapturaPVivoRepo extends JpaRepository<capturaPantallaVivo, Integer> {

    @Query("SELECT c FROM capturaPantallaVivo c " +
            "WHERE c.tipo_proc = 'Arequipa Vivo'")
    List<capturaPantallaVivo> findArequipaVivo();

    @Query("SELECT c FROM capturaPantallaVivo c " +
            "WHERE c.tipo_proc = 'Provincia Vivo'")
    List<capturaPantallaVivo> findProvinciaVivo();

}
