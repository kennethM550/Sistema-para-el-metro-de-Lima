
package Modelo;

import java.io.Serializable;
import java.util.Date;


public class Recarga implements Serializable{
    private Date fecha;
    private float monto;
    private Estacion estacion;

    public Recarga(float monto,Estacion estacion) {
        this.fecha = new Date();
        this.monto = monto;
        this.estacion=estacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    @Override
    public String toString() {
        return "Recarga{" + "fecha=" + fecha + ", monto=" + monto + ", estacion=" + estacion.getNombre() + '}';
    }
    
    
}
