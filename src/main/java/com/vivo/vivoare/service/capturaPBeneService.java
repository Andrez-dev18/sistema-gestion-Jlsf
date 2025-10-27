package com.vivo.vivoare.service;

import com.vivo.vivoare.dto.arequipaBene;
import com.vivo.vivoare.dto.arequipaVivo;
import com.vivo.vivoare.dto.provinciaBene;
import com.vivo.vivoare.dto.provinciaVivo;
import com.vivo.vivoare.model.capturaPantallaBeneficiada;
import com.vivo.vivoare.model.capturaPantallaVivo;
import com.vivo.vivoare.repo.IcapturaBeneRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class capturaPBeneService {

    private final IcapturaBeneRepo repo;

    public capturaPBeneService(IcapturaBeneRepo repo){
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public List<capturaPantallaBeneficiada> getListBene(){
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public capturaPantallaBeneficiada getBeneId(int id){
        return repo.getReferenceById(id);
    }

    @Transactional(readOnly = true)
    public List<arequipaBene> getListArequipaBene(){

        List<capturaPantallaBeneficiada> listBene = repo.findArequipaBene();
        List<arequipaBene> listAreBene = new ArrayList<>();

        for (capturaPantallaBeneficiada bene : listBene) {
            arequipaBene areBene = new arequipaBene();

            areBene.setId(bene.getId());
            areBene.setAno(bene.getAno());
            areBene.setMes(bene.getMes());
            areBene.setProvincia(bene.getProvincia());
            areBene.setZona(bene.getZona());
            areBene.setCompraGrs(bene.getCompraGrs());
            areBene.setTipoCliente(bene.getTipoCliente());
            areBene.setNombre(bene.getNombre());
            areBene.setGrs(bene.getGrs());
            areBene.setRp(bene.getRp());


            areBene.setAvicola_renzo(bene.getAvicola_renzo());
            areBene.setAvelino(bene.getAvelino());
            areBene.setPeladores(bene.getPeladores());
            areBene.setAvicruz(bene.getAvicruz());
            areBene.setRafael(bene.getRafael());
            areBene.setMatilde(bene.getMatilde());
            areBene.setAvirox(bene.getAvirox());
            areBene.setJulia(bene.getJulia());
            areBene.setSimon(bene.getSimon());
            areBene.setYesica(bene.getYesica());
            areBene.setGabriel(bene.getGabriel());
            areBene.setArturo(bene.getArturo());
            areBene.setNicolas(bene.getNicolas());
            areBene.setLuis_f(bene.getLuis_f());
            areBene.setMirella(bene.getMirella());
            areBene.setOtros(bene.getOtros());


            areBene.setPotencialMinimo(bene.getPotencialMinimo());
            areBene.setPotencialMaximo(bene.getPotencialMaximo());
            areBene.setCondicionPtmax(bene.getCondicionPtmax());

            listAreBene.add(areBene);
        }
        Collections.reverse(listAreBene);
        return listAreBene;
    }

    public List<provinciaBene> getListProvinciaBene() {

        List<capturaPantallaBeneficiada> listBene = repo.findProvinciaBene();
        List<provinciaBene> listProvBene = new ArrayList<>();

        for (capturaPantallaBeneficiada bene : listBene) {

            provinciaBene provBene = new provinciaBene();

            provBene.setId(bene.getId());
            provBene.setAno(bene.getAno());
            provBene.setMes(bene.getMes());
            provBene.setProvincia(bene.getProvincia());
            provBene.setZona(bene.getZona());
            provBene.setCompraGrs(bene.getCompraGrs());
            provBene.setTipoCliente(bene.getTipoCliente());
            provBene.setNombre(bene.getNombre());

            // 🐔 Campos de Provincia
            provBene.setGrs(bene.getGrs());
            provBene.setRp(bene.getRp());
            provBene.setGrs_vivo(bene.getGrs_vivo());
            provBene.setSanta_elena(bene.getSanta_elena());
            provBene.setGranjas_chicas(bene.getGranjas_chicas());
            provBene.setRosario(bene.getRosario());
            provBene.setSanfern_lima(bene.getSanfern_lima());
            provBene.setAvicola_renzo(bene.getAvicola_renzo());
            provBene.setOtros(bene.getOtros());

            // ⚙️ Potenciales y observaciones
            provBene.setPotencialMinimo(bene.getPotencialMinimo());
            provBene.setPotencialMaximo(bene.getPotencialMaximo());
            provBene.setCondicionPtmin(bene.getCondicionPtmin());
            provBene.setCondicionPtmax(bene.getCondicionPtmax());
            provBene.setObservaciones(bene.getObservaciones());

            listProvBene.add(provBene);

        }
        Collections.reverse(listProvBene);
        return listProvBene;
    }

    public capturaPantallaBeneficiada saveBene(capturaPantallaBeneficiada vivo){
        return repo.save(vivo);
    }

    public void deleteBene(int id){
        repo.deleteById(id);
    }

}
