package co.mlforex.forecast.gestorCatalogo.repository;

import co.mlforex.forecast.gestorCatalogo.model.TransaccionInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface FullCatalogInfo extends CrudRepository<TransaccionInfo, String> {

}
