package co.mlforex.forecast.repository;

import co.mlforex.forecast.model.TransaccionInfo;

import java.util.List;

public interface FullCatalogInfo {

    void guardarCatalogInfo(TransaccionInfo transaccionInfo);
    void actualizarCatalogInfo(TransaccionInfo transaccionInfo);
    List<TransaccionInfo> consultarCatalogoGeneral();
}
