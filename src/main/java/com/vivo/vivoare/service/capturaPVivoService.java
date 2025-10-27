package com.vivo.vivoare.service;

import com.vivo.vivoare.dto.arequipaVivo;
import com.vivo.vivoare.dto.provinciaVivo;
import com.vivo.vivoare.model.capturaPantallaVivo;
import com.vivo.vivoare.repo.IcapturaPVivoRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class capturaPVivoService  {

    private final IcapturaPVivoRepo repo;

    public capturaPVivoService(IcapturaPVivoRepo repo){
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public List<capturaPantallaVivo> getListVivo(){
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public List<arequipaVivo> getListArequipaVivo(){

        List<capturaPantallaVivo> listVivo = repo.findArequipaVivo();
        List<arequipaVivo> listAreVivo = new ArrayList<>();

        for (capturaPantallaVivo vivo : listVivo) {
            arequipaVivo areVivo = new arequipaVivo();

            areVivo.setId(vivo.getId());
            areVivo.setAno(vivo.getAno());
            areVivo.setMes(vivo.getMes());
            areVivo.setProvincia(vivo.getProvincia());
            areVivo.setZona(vivo.getZona());
            areVivo.setCompra(vivo.getCompra());
            areVivo.setTipo_cliente(vivo.getTipo_cliente());
            areVivo.setNombre(vivo.getNombre());

            // Campos específicos de Arequipa
            areVivo.setGrs(vivo.getGrs());
            areVivo.setRp(vivo.getRp());
            areVivo.setRenzo(vivo.getRenzo());
            areVivo.setFafo(vivo.getFafo());
            areVivo.setSanta_angela(vivo.getSanta_angela());
            areVivo.setRosario(vivo.getRosario());
            areVivo.setPollo_lima(vivo.getPollo_lima());
            areVivo.setOtras_granjas_chicas(vivo.getOtras_granjas_chicas());

            // Potenciales y observaciones
            areVivo.setPotencial_minimo(vivo.getPotencial_minimo());
            areVivo.setPotencial_maximo(vivo.getPotencial_maximo());
            areVivo.setCondicion_ptmin(vivo.getCondicion_ptmin());
            areVivo.setCondicion_ptmax(vivo.getCondicion_ptmax());
            areVivo.setObservaciones(vivo.getObservaciones());

            listAreVivo.add(areVivo);
        }

        Collections.reverse(listAreVivo);
        return listAreVivo;
    }

    public List<provinciaVivo> getListProvinciaVivo() {

        List<capturaPantallaVivo> listVivo = repo.findProvinciaVivo(); // JPQL o Native Query
        List<provinciaVivo> listProvVivo = new ArrayList<>();

        for (capturaPantallaVivo vivo : listVivo) {
            provinciaVivo provVivo = new provinciaVivo();

            provVivo.setId(vivo.getId());
            provVivo.setAno(vivo.getAno());
            provVivo.setMes(vivo.getMes());
            provVivo.setProvincia(vivo.getProvincia());
            provVivo.setZona(vivo.getZona());
            provVivo.setCompra(vivo.getCompra());
            provVivo.setTipo_cliente(vivo.getTipo_cliente());
            provVivo.setNombre(vivo.getNombre());

            // Campos específicos de Provincia
            provVivo.setGrs(vivo.getGrs());
            provVivo.setRp(vivo.getRp());
            provVivo.setRenzo(vivo.getRenzo());
            provVivo.setFafo(vivo.getFafo());
            provVivo.setSanta_angela(vivo.getSanta_angela());
            provVivo.setJorge_pan(vivo.getJorge_pan());
            provVivo.setMirian_g(vivo.getMirian_g());
            provVivo.setVasquez(vivo.getVasquez());
            provVivo.setSan_joaquin(vivo.getSan_joaquin());
            provVivo.setFortunato(vivo.getFortunato());
            provVivo.setRosario(vivo.getRosario());
            provVivo.setPerca(vivo.getPerca());
            provVivo.setGamboa(vivo.getGamboa());
            provVivo.setAsoc_sondor(vivo.getAsoc_sondor());
            provVivo.setOtras_granjas_chicas(vivo.getOtras_granjas_chicas());

            // Potenciales y observaciones
            provVivo.setPotencial_minimo(vivo.getPotencial_minimo());
            provVivo.setPotencial_maximo(vivo.getPotencial_maximo());
            provVivo.setCondicion_ptmax(vivo.getCondicion_ptmax());
            provVivo.setObservaciones(vivo.getObservaciones());

            listProvVivo.add(provVivo);
        }
        Collections.reverse(listVivo);
        return listProvVivo;
    }


    @Transactional(readOnly = true)
    public capturaPantallaVivo getVivoId(int id){
        return repo.getReferenceById(id);
    }

    public capturaPantallaVivo saveVivo(capturaPantallaVivo vivo){
        return repo.save(vivo);
    }

    public void deleteVivo(int id){
        repo.deleteById(id);
    }

}
