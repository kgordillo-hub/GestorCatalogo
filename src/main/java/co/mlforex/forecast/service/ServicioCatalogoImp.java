package co.mlforex.forecast.service;

import co.mlforex.forecast.logic.DatasetManager;
import co.mlforex.forecast.model.MiCatalogoInfo;
import co.mlforex.forecast.model.TransaccionInfo;
import co.mlforex.forecast.repository.FullCatalogInfo;
import co.mlforex.forecast.repository.MyCatalogInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServicioCatalogoImp implements ServicioCatalogo{

    @Autowired
    FullCatalogInfo fullCatalogInfo;

    @Autowired
    MyCatalogInfo myCatalogInfo;

    @Override
    public Boolean agregarCatalogoGeneral(TransaccionInfo transaccionInfo) {
        fullCatalogInfo.guardarCatalogInfo(transaccionInfo);
        return null;
    }

    @Override
    public Boolean actulizarCatalogoGeneral(TransaccionInfo transaccionInfo) {
        fullCatalogInfo.actualizarCatalogInfo(transaccionInfo);
        return null;
    }

    @Override
    public List<TransaccionInfo> consultarCatalogoPublico() {
        return fullCatalogInfo.consultarCatalogoGeneral();
    }

    @Override
    public Boolean agregarCatalogoPrivado(MiCatalogoInfo catalogoInfo) {
        myCatalogInfo.guardarMyCatalogInfo(catalogoInfo);
        return null;
    }

    @Override
    public Boolean actulizarCatalogoPrivado(MiCatalogoInfo catalogoInfo) {
        myCatalogInfo.actualizarMyCatalogInfo(catalogoInfo);
        return null;
    }

    @Override
    public List<MiCatalogoInfo> consultarCatalogoPrivado(String idUsuario) {
        return myCatalogInfo.consultarMiCatalogo();
    }

    @Override
    public void generarLlamadoModeloML(MiCatalogoInfo miCatalogoInfo) {
        DatasetManager dtm = new DatasetManager();
        String datsetLink = dtm.subirDataset(miCatalogoInfo.getDataset());
        //Generar mensaje y notificar
    }
}
