package co.mlforex.forecast.repository;

import co.mlforex.forecast.config.DynamoDBConfig;
import co.mlforex.forecast.model.MiCatalogoInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyCatalogInfoImp implements MyCatalogInfo {

    @Autowired
    DynamoDBConfig dynamoDBConfig;

    @Override
    public void guardarMyCatalogInfo(MiCatalogoInfo miCatalogoInfo) {

    }

    @Override
    public void actualizarMyCatalogInfo(MiCatalogoInfo miCatalogoInfo) {

    }

    @Override
    public List<MiCatalogoInfo> consultarMiCatalogo() {
        return null;
    }
}
