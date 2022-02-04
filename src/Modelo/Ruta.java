
package Modelo;

import java.io.Serializable;

public class Ruta implements Serializable {
    private String linea;

    public Ruta(String linea) {
        this.linea = linea;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return  linea ;
    }
}
