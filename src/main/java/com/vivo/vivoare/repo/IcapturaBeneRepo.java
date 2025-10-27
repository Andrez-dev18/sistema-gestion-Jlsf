package com.vivo.vivoare.repo;

import com.vivo.vivoare.model.capturaPantallaBeneficiada;
import com.vivo.vivoare.model.capturaPantallaVivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IcapturaBeneRepo extends JpaRepository<capturaPantallaBeneficiada, Integer> {

    @Query("SELECT c FROM capturaPantallaBeneficiada c " +
            "WHERE c.tipo_proc = 'Arequipa Beneficiado'")
    List<capturaPantallaBeneficiada> findArequipaBene();

    @Query("SELECT c FROM capturaPantallaBeneficiada c " +
            "WHERE c.tipo_proc = 'Provincia Beneficiado'")
    List<capturaPantallaBeneficiada> findProvinciaBene();

}
