
package Modelo;

import java.io.Serializable;
import java.util.Date;


public class Viaje implements Serializable{
    private Date fecha;
    private Estacion estacioninicio;
    private Estacion estacionllegada;
    private Ruta ruta; 
    
    public Viaje(Estacion estaciona, Estacion estacionb, Ruta ruta ) {
        this.fecha = new Date();
        this.estacioninicio = estaciona;
        this.estacionllegada = estacionb;
        this.ruta = ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public Estacion getEstacioninicio() {
        return estacioninicio;
    }

    public void setEstacioninicio(Estacion estacioninicio) {
        this.estacioninicio = estacioninicio;
    }

    public Estacion getEstacionllegada() {
        return estacionllegada;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setEstacionllegada(Estacion estacionllegada) {
        this.estacionllegada = estacionllegada;
    }

    @Override
    public String toString() {
        return "Viaje{" + "fecha=" + fecha + ""
                + ",estacioninicio=" + estacioninicio.getNombre() + 
                ", estacionllegada=" + estacionllegada.getNombre() + 
                "ruta="+ruta.getLinea() +
                '}';
    }

   
      
}
