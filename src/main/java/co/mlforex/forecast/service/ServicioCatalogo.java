package co.mlforex.forecast.service;

import co.mlforex.forecast.model.MiCatalogoInfo;
import co.mlforex.forecast.model.TransaccionInfo;

import java.util.List;

public interface ServicioCatalogo {

    Boolean agregarCatalogoGeneral(TransaccionInfo transaccionInfo);

    Boolean actulizarCatalogoGeneral(TransaccionInfo transaccionInfo);

    List<TransaccionInfo> consultarCatalogoPublico();

    //Informacion de catalogo interno
    Boolean agregarCatalogoPrivado(MiCatalogoInfo catalogoInfo);

    Boolean actulizarCatalogoPrivado(MiCatalogoInfo catalogoInfo);

    List<MiCatalogoInfo> consultarCatalogoPrivado(String idUsuario);

    void generarLlamadoModeloML(MiCatalogoInfo miCatalogoInfo);


}
