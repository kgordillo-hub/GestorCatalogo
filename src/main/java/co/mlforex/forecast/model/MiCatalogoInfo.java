package co.mlforex.forecast.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.util.json.JSONObject;

import java.io.Serializable;
@DynamoDBTable(tableName = "MiCatalogoInfo")
public class MiCatalogoInfo implements Serializable {

    //Partition Key
    private String nombreApp;
    private String version;
    private String idUsuario;

    //Autogenerado por DB
    private Integer consecutivo;

    //Atributos
    private String IP_API;
    private Integer numeroPuerto;
    private Boolean enPreparacion;
    private Boolean enEntrenamiento;

    //Otros atributos
    private String idTransaccion;
    private byte[] dataset;
    private JSONObject openAPIFileContent;
    private String [] metricasCalcular;

    private String datasetLink;

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

    public String getIP_API() {
        return IP_API;
    }

    public void setIP_API(String IP_API) {
        this.IP_API = IP_API;
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

    public byte[] getDataset() {
        return dataset;
    }

    public void setDataset(byte[] dataset) {
        this.dataset = dataset;
    }

    public JSONObject getOpenAPIFileContent() {
        return openAPIFileContent;
    }

    public void setOpenAPIFileContent(JSONObject openAPIFileContent) {
        this.openAPIFileContent = openAPIFileContent;
    }

    public String[] getMetricasCalcular() {
        return metricasCalcular;
    }

    public void setMetricasCalcular(String[] metricasCalcular) {
        this.metricasCalcular = metricasCalcular;
    }

    public String getDatasetLink() {
        return datasetLink;
    }

    public void setDatasetLink(String datasetLink) {
        this.datasetLink = datasetLink;
    }
}
