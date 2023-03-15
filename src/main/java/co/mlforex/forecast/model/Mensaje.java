package co.mlforex.forecast.model;

import java.io.Serializable;

public class Mensaje implements Serializable {

    Boolean esPublico;
    private String idUsuario;

    public Boolean getEsPublico() {
        return esPublico;
    }

    public void setEsPublico(Boolean esPublico) {
        this.esPublico = esPublico;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
