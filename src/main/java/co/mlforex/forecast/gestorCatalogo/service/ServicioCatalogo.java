package co.mlforex.forecast.gestorCatalogo.service;

import co.mlforex.forecast.gestorCatalogo.model.TransaccionInfo;
import co.mlforex.forecast.gestorCatalogo.model.MiCatalogoInfo;

import java.util.List;

public interface ServicioCatalogo {

    Boolean agregarCatalogoGeneral(TransaccionInfo transaccionInfo);


    List<TransaccionInfo> consultarCatalogoPublico();

    //Informacion de catalogo interno
    Boolean agregarCatalogoPrivado(MiCatalogoInfo catalogoInfo);


    List<MiCatalogoInfo> consultarCatalogoPrivado(String idUsuario);

    void actualizarMiCatalogo(MiCatalogoInfo miCatalogoInfo, String evento);

}
