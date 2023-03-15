package co.mlforex.forecast.repository;

import co.mlforex.forecast.model.MiCatalogoInfo;

import java.util.List;

public interface MyCatalogInfo {

    void guardarMyCatalogInfo(MiCatalogoInfo miCatalogoInfo);
    void actualizarMyCatalogInfo(MiCatalogoInfo miCatalogoInfo);
    List<MiCatalogoInfo> consultarMiCatalogo();

}
