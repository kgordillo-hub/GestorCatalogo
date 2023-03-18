package co.mlforex.forecast.gestorCatalogo.repository;

import co.mlforex.forecast.gestorCatalogo.model.MiCatalogoInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface MyCatalogInfo extends CrudRepository<MiCatalogoInfo, String> {


}
