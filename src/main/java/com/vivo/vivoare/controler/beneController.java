package com.vivo.vivoare.controler;
import com.vivo.vivoare.dto.arequipaBene;
import com.vivo.vivoare.dto.provinciaBene;
import com.vivo.vivoare.model.capturaPantallaBeneficiada;
import com.vivo.vivoare.service.capturaPBeneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiado")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class beneController {

    private final capturaPBeneService service;

    public beneController(capturaPBeneService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<capturaPantallaBeneficiada> getListBene(){
        return service.getListBene();
    }

    @PostMapping("/crear")
    public ResponseEntity<capturaPantallaBeneficiada> crearBene(@RequestBody capturaPantallaBeneficiada bene){
        if(bene.getId() != 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.saveBene(bene));
    }

    @GetMapping("/arequipa")
    public List<arequipaBene>getListArequipaBene(){
        return service.getListArequipaBene();
    }

    @GetMapping("/provincia")
    public List<provinciaBene>getListProvinciaBene(){
        return service.getListProvinciaBene();
    }

    @PutMapping("/actualizar")
    public ResponseEntity<capturaPantallaBeneficiada> actualizarBeneficiada(
            @RequestBody capturaPantallaBeneficiada beneficiadaActualizada) {

        // Buscar si el registro existe
        capturaPantallaBeneficiada beneficiada = service.getBeneId(beneficiadaActualizada.getId());
        if (beneficiada == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar los campos generales
        beneficiada.setTipo_proc(beneficiadaActualizada.getTipo_proc());
        beneficiada.setAno(beneficiadaActualizada.getAno());
        beneficiada.setMes(beneficiadaActualizada.getMes());
        beneficiada.setProvincia(beneficiadaActualizada.getProvincia());
        beneficiada.setZona(beneficiadaActualizada.getZona());
        beneficiada.setCompraGrs(beneficiadaActualizada.getCompraGrs());
        beneficiada.setTipoCliente(beneficiadaActualizada.getTipoCliente());
        beneficiada.setNombre(beneficiadaActualizada.getNombre());

        // Campos de producción y beneficiado
        beneficiada.setGrs(beneficiadaActualizada.getGrs());
        beneficiada.setRp(beneficiadaActualizada.getRp());
        beneficiada.setGrs_vivo(beneficiadaActualizada.getGrs_vivo());
        beneficiada.setSanta_elena(beneficiadaActualizada.getSanta_elena());
        beneficiada.setGranjas_chicas(beneficiadaActualizada.getGranjas_chicas());
        beneficiada.setRosario(beneficiadaActualizada.getRosario());
        beneficiada.setSanfern_lima(beneficiadaActualizada.getSanfern_lima());
        beneficiada.setAvicola_renzo(beneficiadaActualizada.getAvicola_renzo());

        // Campos adicionales específicos de beneficiado
        beneficiada.setAvelino(beneficiadaActualizada.getAvelino());
        beneficiada.setPeladores(beneficiadaActualizada.getPeladores());
        beneficiada.setAvicruz(beneficiadaActualizada.getAvicruz());
        beneficiada.setRafael(beneficiadaActualizada.getRafael());
        beneficiada.setMatilde(beneficiadaActualizada.getMatilde());
        beneficiada.setAvirox(beneficiadaActualizada.getAvirox());
        beneficiada.setJulia(beneficiadaActualizada.getJulia());
        beneficiada.setSimon(beneficiadaActualizada.getSimon());
        beneficiada.setYesica(beneficiadaActualizada.getYesica());
        beneficiada.setGabriel(beneficiadaActualizada.getGabriel());
        beneficiada.setArturo(beneficiadaActualizada.getArturo());
        beneficiada.setNicolas(beneficiadaActualizada.getNicolas());
        beneficiada.setLuis_f(beneficiadaActualizada.getLuis_f());
        beneficiada.setMirella(beneficiadaActualizada.getMirella());
        beneficiada.setOtros(beneficiadaActualizada.getOtros());

        // Potenciales y observaciones
        beneficiada.setPotencialMinimo(beneficiadaActualizada.getPotencialMinimo());
        beneficiada.setPotencialMaximo(beneficiadaActualizada.getPotencialMaximo());
        beneficiada.setCondicionPtmin(beneficiadaActualizada.getCondicionPtmin());
        beneficiada.setCondicionPtmax(beneficiadaActualizada.getCondicionPtmax());
        beneficiada.setObservaciones(beneficiadaActualizada.getObservaciones());

        // Guardar cambios
        capturaPantallaBeneficiada beneficiadaGuardada = service.saveBene(beneficiada);
        return ResponseEntity.ok(beneficiadaGuardada);
    }


    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminarBene(@PathVariable int id){
        service.deleteBene(id);
        return ResponseEntity.ok("Se elimino el registro correctamente");
    }

}
