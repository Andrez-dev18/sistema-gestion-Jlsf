package com.vivo.vivoare.controler;

import com.vivo.vivoare.dto.arequipaVivo;
import com.vivo.vivoare.dto.provinciaVivo;
import com.vivo.vivoare.model.capturaPantallaVivo;
import com.vivo.vivoare.service.capturaPVivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vivo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.DELETE})
public class vivoController {


    private final capturaPVivoService service;

    public vivoController(capturaPVivoService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<capturaPantallaVivo>getListVivo(){
        return service.getListVivo();
    }

    @PostMapping("/crear")
    public ResponseEntity<capturaPantallaVivo>crearVivo(@RequestBody capturaPantallaVivo vivo){
        if(vivo.getId() != 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.saveVivo(vivo));
    }

    @GetMapping("/arequipa")
    public List<arequipaVivo>getListArequipaVivo(){
        return service.getListArequipaVivo();
    }

    @GetMapping("/provincia")
    public List<provinciaVivo>getListProvinciaVivo(){
        return service.getListProvinciaVivo();
    }

    @PutMapping("/actualizar")
    public ResponseEntity<capturaPantallaVivo> actualizarVivo(
            @RequestBody capturaPantallaVivo vivoActualizado) {

        // Buscar si el registro existe
        capturaPantallaVivo vivo = service.getVivoId(vivoActualizado.getId());
        if (vivo == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar los campos (solo los que pueden cambiar)
        vivo.setAno(vivoActualizado.getAno());
        vivo.setMes(vivoActualizado.getMes());
        vivo.setProvincia(vivoActualizado.getProvincia());
        vivo.setZona(vivoActualizado.getZona());
        vivo.setCompra(vivoActualizado.getCompra());
        vivo.setTipo_cliente(vivoActualizado.getTipo_cliente());
        vivo.setNombre(vivoActualizado.getNombre());

        // Campos de cantidades
        vivo.setGrs(vivoActualizado.getGrs());
        vivo.setRp(vivoActualizado.getRp());
        vivo.setRenzo(vivoActualizado.getRenzo());
        vivo.setFafo(vivoActualizado.getFafo());
        vivo.setSanta_angela(vivoActualizado.getSanta_angela());
        vivo.setJorge_pan(vivoActualizado.getJorge_pan());
        vivo.setMirian_g(vivoActualizado.getMirian_g());
        vivo.setVasquez(vivoActualizado.getVasquez());
        vivo.setSan_joaquin(vivoActualizado.getSan_joaquin());
        vivo.setFortunato(vivoActualizado.getFortunato());
        vivo.setRosario(vivoActualizado.getRosario());
        vivo.setPerca(vivoActualizado.getPerca());
        vivo.setGamboa(vivoActualizado.getGamboa());
        vivo.setAsoc_sondor(vivoActualizado.getAsoc_sondor());
        vivo.setPollo_lima(vivoActualizado.getPollo_lima());
        vivo.setOtras_granjas_chicas(vivoActualizado.getOtras_granjas_chicas());

        // Potenciales y observaciones
        vivo.setPotencial_minimo(vivoActualizado.getPotencial_minimo());
        vivo.setPotencial_maximo(vivoActualizado.getPotencial_maximo());
        vivo.setCondicion_ptmin(vivoActualizado.getCondicion_ptmin());
        vivo.setCondicion_ptmax(vivoActualizado.getCondicion_ptmax());
        vivo.setObservaciones(vivoActualizado.getObservaciones());

        // Guardar los cambios
        capturaPantallaVivo vivoGuardado = service.saveVivo(vivo);
        return ResponseEntity.ok(vivoGuardado);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminarVivo(@PathVariable int id){
        service.deleteVivo(id);
        return ResponseEntity.ok("Se elimino el registro correctamente");
    }

}
