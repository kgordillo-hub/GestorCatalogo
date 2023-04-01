package co.mlforex.forecast.gestorCatalogo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
@DynamoDBTable(tableName = "MiCatalogoInfo")
public class MiCatalogoInfo implements Serializable {

    private String UID;
    @DynamoDBAttribute
    private String nombreApp;
    @DynamoDBAttribute
    private String version;
    @DynamoDBAttribute
    private String idUsuario;

    @DynamoDBAttribute
    private Integer consecutivo;

    //Atributos
    @DynamoDBAttribute
    private String ipAPI;
    @DynamoDBAttribute
    private Integer numeroPuerto;
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
    @DynamoDBAttribute
    private Boolean enPreparacion;
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
    @DynamoDBAttribute
    private Boolean enEntrenamiento;

    //Otros atributos
    @DynamoDBIgnore
    private String idTransaccion;

    @DynamoDBIgnore
    private String endPoint;

    @DynamoDBAttribute
    private String descripcion;


    public String getNombreApp() {
        return nombreApp;
    }

    public void setNombreApp(String nombreApp) {
        this.nombreApp = nombreApp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getIpAPI() {
        return ipAPI;
    }

    public void setIpAPI(String ipAPI) {
        this.ipAPI = ipAPI;
    }

    public Integer getNumeroPuerto() {
        return numeroPuerto;
    }

    public void setNumeroPuerto(Integer numeroPuerto) {
        this.numeroPuerto = numeroPuerto;
    }

    public Boolean getEnPreparacion() {
        return enPreparacion;
    }

    public void setEnPreparacion(Boolean enPreparacion) {
        this.enPreparacion = enPreparacion;
    }

    public Boolean getEnEntrenamiento() {
        return enEntrenamiento;
    }

    public void setEnEntrenamiento(Boolean enEntrenamiento) {
        this.enEntrenamiento = enEntrenamiento;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    @DynamoDBHashKey(attributeName = "UID")
    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }


    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String generateUID(){
        return DigestUtils.md5Hex(nombreApp.toLowerCase()+":"+version+":"+idUsuario+":"+consecutivo);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
