package co.mlforex.forecast.gestorCatalogo.controller;

import co.mlforex.forecast.gestorCatalogo.model.MiCatalogoInfo;
import co.mlforex.forecast.gestorCatalogo.model.TransaccionInfo;
import co.mlforex.forecast.gestorCatalogo.service.ServicioCatalogo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GestorCatalogoController {

    Logger logger = LoggerFactory.getLogger(GestorCatalogoController.class);

    @Autowired
    ServicioCatalogo servicioCatalogo;

    @GetMapping("/consultarCatalogoGral")
    public ResponseEntity<List<TransaccionInfo>> consultarCatalogoGral() {
        try {
            final List<TransaccionInfo> listaCatalogo = servicioCatalogo.consultarCatalogoPublico();
            return new ResponseEntity<>(listaCatalogo, HttpStatus.OK);
        } catch (final Exception e) {
            logger.error("Error en GestorCatalogoController:consultarCatalogoGral" + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/agregarCatalogoGral")
    public ResponseEntity<String> agregarCatalogoGral(@RequestBody TransaccionInfo transaccionInfo) {
        try {
            if(servicioCatalogo.agregarCatalogoGeneral(transaccionInfo)){
                return new ResponseEntity<>("Saved", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Application already added", HttpStatus.ALREADY_REPORTED);
            }
        } catch (final Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Catalogo privado

    @GetMapping("/consultarMiCatalogo/{idUsuario}")
    public ResponseEntity<List<MiCatalogoInfo>> consultarMiCatalogo(@PathVariable String idUsuario) {
        try{
            final List<MiCatalogoInfo> miCatalogo = servicioCatalogo.consultarCatalogoPrivado(idUsuario);
            return new ResponseEntity<>(miCatalogo, HttpStatus.OK);
        }catch(final Exception e){
            logger.error("Error en GestorCatalogoController:consultarMiCatalogo "+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/agregarMiCatalogo")
    public ResponseEntity<String> agregarMiCatalogo(@RequestBody MiCatalogoInfo miCatalogoInfo) {
        try{
            if(servicioCatalogo.agregarCatalogoPrivado(miCatalogoInfo)){
                return new ResponseEntity<>("Added", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Application already added in personal catalog", HttpStatus.ALREADY_REPORTED);
            }
        }catch(final Exception e){
            logger.error("Error en GestorCatalogoController:agregarMiCatalogo "+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/actualizarMiCatalogo/{event}")
    public ResponseEntity<String> actualizarMiCatalogo(@RequestBody MiCatalogoInfo miCatalogoInfo, @PathVariable String event) {
        try{
            servicioCatalogo.actualizarMiCatalogo(miCatalogoInfo, event);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } catch(final Exception e){
            logger.error("Error en GestorCatalogoController:actualizarMiCatalogo "+e.getMessage());
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
