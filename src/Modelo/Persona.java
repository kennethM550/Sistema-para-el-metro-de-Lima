
package Modelo;

import java.io.Serializable;


public abstract class Persona implements Serializable{
    private String paterno;
    private String materno;
    private String nombres;
    private String tipoDocumento;
    private String numDocumento;

    public Persona(String paterno, String materno, String nombres, String tipoDocumento, String numDocumento) {
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
    
}
