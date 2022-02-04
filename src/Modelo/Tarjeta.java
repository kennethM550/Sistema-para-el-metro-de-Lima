
package Modelo;

import Datos.Repositorio;
import java.io.Serializable;
import java.util.Date;

public class Tarjeta implements Serializable{
    private int numero;
    private String contraseña;
    private String estado;
    private TipoTarjeta tipo; 
    private float saldo;
    private Viaje viajes[];
    private int indiceV;
    private Recarga recargas[];
    private int indiceR;
    private static int cantidad=1;
    private final String[] cabeceraR =  {"FECHA","MONTO",
                            "ESTACION",};
    private final String[] cabeceraV =  {"FECHA","ESTACION DE INICIO",
                            "ESTACION DE LLEGADA","RUTA"};
    
    public Tarjeta(String contraseña,TipoTarjeta tipo) {
        this.numero = 220000+cantidad++;
        this.estado = "Bueno";
        this.contraseña=contraseña;
        this.tipo=tipo;
        this.saldo = 5f;
        this.viajes = new Viaje[100];
        this.indiceV = 0;
        this.recargas = new Recarga[100];
        this.indiceR=0;
        Repositorio.modelotarjetas.agregarTarjeta(this);
    }
    
    public boolean agregarV(Viaje viaje){
        boolean result = false;
        if(estaLlenoV()){
            crecerArregloV(viaje);
        }
        this.viajes[this.indiceV] = viaje;
        this.indiceV++;
        result= true;
        return result;
    }
    private void crecerArregloV(Viaje viaje){
        Viaje nuevoviajes[] = new Viaje[this.indiceV+1];
         nuevoviajes[this.indiceV] = viaje;
         for(int i =0 ; i<this.indiceV;i++){
             nuevoviajes[i]= this.viajes[i];
         }
         this.viajes = nuevoviajes;
    }
    
    private boolean estaLlenoV(){
        boolean result = false;
            if(this.indiceV!=0){
                result=true;
            }   
        return result; 
    }
    public boolean agregarR(Recarga recarga){
        boolean result = false;
        if(estaLlenoR()){
            crecerArregloR(recarga);
        }
        this.recargas[this.indiceR] = recarga;
        this.indiceR++;
        result= true;
        return result;
    }
    private void crecerArregloR(Recarga recarga){
        Recarga nuevorecargas[] = new Recarga[this.indiceR+1];
         nuevorecargas[this.indiceR] = recarga;
         for(int i =0 ; i<this.indiceR;i++){
             nuevorecargas[i]= this.recargas[i];
         }
         this.recargas = nuevorecargas;
    }
    
    private boolean estaLlenoR(){
        boolean result = false;
            if(this.indiceR!=0){
                result=true;
            }   
        return result; 
    }
    
    public boolean Recargar(float monto,Estacion estacion){
        boolean result=false;
        if("Bueno".equals(this.estado) && monto>0){
            this.saldo+= monto;
            result=true;
            Recarga r = new Recarga(monto,estacion);
            agregarR(r);
        }   
        return result;
    }
    public boolean PagarViaje(Estacion estaciona, Estacion estacionb, Ruta ruta){
        boolean result=false;
        if("Bueno".equals(this.estado) && this.saldo>=this.tipo.getTarifa()){
            this.saldo-=this.tipo.getTarifa();
            result=true;
            Viaje v = new Viaje(estaciona,estacionb,ruta);
            agregarV(v);
        }
        return result;
    }
    
    public Object[][] getDatosR(){
        Object resultado[][] = new Object[this.indiceR][3];
        if(!isVacio()){
            for(int indice = 0; indice< this.indiceR;indice++){
                resultado[indice][0] = this.recargas[indice].getFecha();
                resultado[indice][1] = this.recargas[indice].getMonto();
                resultado[indice][2] = this.recargas[indice].getEstacion();
            }
        }
        return resultado;
    }
    public String[] getCabeceraR() {
        return cabeceraR;
    }
    public Object[][] getDatosV(){
        Object resultado[][] = new Object[this.indiceV][4];
        if(!isVacioV()){
            for(int indice = 0; indice< this.indiceV;indice++){
                resultado[indice][0] = this.viajes[indice].getFecha();
                resultado[indice][1] = this.viajes[indice].getEstacioninicio();
                resultado[indice][2] = this.viajes[indice].getEstacionllegada();
                resultado[indice][3] = this.viajes[indice].getRuta();
            }
        }
        return resultado;
    }
    public String[] getCabeceraV() {
        return cabeceraV;
    }
    public boolean isVacio() {
        return this.indiceR==0;
    }
    public boolean isVacioV() {
        return this.indiceV==0;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    
    public int getNumero() {
        return numero;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoTarjeta getTipo() {
        return tipo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        String imprimirRecargas="";
        for(int i=0; i< this.indiceR; i++ ){
            imprimirRecargas +=this.recargas[i]+ "  "; 
        }
        String imprimirViajes="";
        for(int i=0; i< this.indiceV; i++ ){
            imprimirViajes +=this.viajes[i]+ "  "; 
        }
        return "Tarjeta: " + "\nnumero=" + numero + 
                ", \nestado=" + estado + ", "
                + "\ntipo=" + tipo.nombre + ","
                + "\nsaldo=" + saldo + ","
                + "\nrecargas=" + imprimirRecargas
                + "\nviajes=" + imprimirViajes;
    }

}
