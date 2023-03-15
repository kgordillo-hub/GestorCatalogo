package co.mlforex.forecast.controller;

import co.mlforex.forecast.model.MiCatalogoInfo;
import co.mlforex.forecast.model.TransaccionInfo;
import co.mlforex.forecast.service.ServicioCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GestorCatalogoController {

    @Autowired
    ServicioCatalogo servicioCatalogo;

    @PostMapping("/consultarCatalogoGral")
    public ResponseEntity<List<TransaccionInfo>> consultarCatalogoGral(){
        final List<TransaccionInfo> listaCatalogo = servicioCatalogo.consultarCatalogoPublico();
        return new ResponseEntity<>(listaCatalogo, HttpStatus.OK);
    }

    @PostMapping("/agregarCatalogoGral")
    public ResponseEntity<String> agregarCatalogoGral(TransaccionInfo transaccionInfo){
        servicioCatalogo.agregarCatalogoGeneral(transaccionInfo);
        return new ResponseEntity<>("Saved", HttpStatus.OK);
    }

    @PostMapping("/actualizarCatalogoGral")
    public ResponseEntity<String> actualizarCatalogoGral(TransaccionInfo transaccionInfo){
        servicioCatalogo.actulizarCatalogoGeneral(transaccionInfo);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    //Catalogo privado

    @PostMapping("/consultarMiCatalogo")
    public ResponseEntity<List<MiCatalogoInfo>> consultarMiCatalogo(String idUsuario){
        final List<MiCatalogoInfo> miCatalogo = servicioCatalogo.consultarCatalogoPrivado(idUsuario);
        return new ResponseEntity<>(miCatalogo, HttpStatus.OK);
    }

    @PostMapping("/agregarMiCatalogo")
    public ResponseEntity<String> agregarMiCatalogo(MiCatalogoInfo miCatalogoInfo){
        servicioCatalogo.agregarCatalogoPrivado(miCatalogoInfo);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @PostMapping("/actualizarMiCatalogo")
    public ResponseEntity<String> actualizarMiCatalogo(MiCatalogoInfo miCatalogoInfo){
        servicioCatalogo.actulizarCatalogoPrivado(miCatalogoInfo);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @PostMapping("/generarLlamadoModeloMl")
    public ResponseEntity<String> generarLlamadoModeloML(MiCatalogoInfo miCatalogoInfo){
        servicioCatalogo.generarLlamadoModeloML(miCatalogoInfo);
        return new ResponseEntity<>("Mensaje generado", HttpStatus.OK);
    }

}
