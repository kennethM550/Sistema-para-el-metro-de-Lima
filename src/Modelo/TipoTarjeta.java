
package Modelo;

import java.io.Serializable;

public class TipoTarjeta implements Serializable{
    String nombre;
    float tarifa;

    public TipoTarjeta(String nombre, float tarifa) {
        this.nombre = nombre;
        this.tarifa = tarifa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
    
    public float getTarifa() {
        return tarifa;
    }
    
    @Override
    public String toString() {
        return  nombre ;
    }
}
