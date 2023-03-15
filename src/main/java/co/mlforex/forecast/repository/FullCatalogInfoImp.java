package co.mlforex.forecast.repository;

import co.mlforex.forecast.config.DynamoDBConfig;
import co.mlforex.forecast.model.TransaccionInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FullCatalogInfoImp implements FullCatalogInfo {

    @Autowired
    DynamoDBConfig dynamoDBConfig;

    @Override
    public void guardarCatalogInfo(TransaccionInfo transaccionInfo) {

    }

    @Override
    public void actualizarCatalogInfo(TransaccionInfo transaccionInfo) {

    }

    @Override
    public List<TransaccionInfo> consultarCatalogoGeneral() {
        return null;
    }
}
