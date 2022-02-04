
package Modelo;

import java.io.Serializable;

public class TipoTarjetaArreglo implements Serializable{
    private int indice,tamaño;
    private TipoTarjeta tipoTarjetas[];
   

    public TipoTarjetaArreglo() {
        this.indice = 0;
        this.tamaño = 2;
        this.tipoTarjetas = new TipoTarjeta[this.tamaño];
        this.agregar(new TipoTarjeta("Estandar",1.5f));
        this.agregar(new TipoTarjeta("Medio",0.75f));
    }
    public boolean agregar(TipoTarjeta tipotarjeta){
        boolean result = false;
        if(!TipoTarjetaRegistrada(tipotarjeta.getNombre(),tipotarjeta.getTarifa())){
            if(EstaLleno()){
               crecerArreglo(tipotarjeta);
            }
            this.tipoTarjetas[this.indice] = tipotarjeta;
            this.indice++;
            result= true;
        }
        return result;
    }
    public Object[] getDatosCombo() {
        Object resultado[] = null;
        if(!EstaVacio()){
            resultado = new Object[this.indice];
            for(int indice=0; indice < this.indice; indice++){
                resultado[indice] = this.tipoTarjetas[indice];
            }
        }
        return resultado;
    }
    
    public boolean EstaLleno() {
        boolean result = false;
            if(this.indice!=0){
                result=true;
            }
        return result;
    }
    
    private void crecerArreglo(TipoTarjeta tipotarjeta){
        TipoTarjeta nuevoArreglo[] = new TipoTarjeta[indice+1];
         nuevoArreglo[indice] = tipotarjeta;
         for(int i =0 ; i<this.indice;i++){
             nuevoArreglo[i]= this.tipoTarjetas[i];
         }
         this.tipoTarjetas = nuevoArreglo;
    }
    public boolean TipoTarjetaRegistrada(String nombre, float tarifa){
        boolean result=false;
        if(this.indice>0){
            for(int i=0;i<indice;i++){
                if(this.tipoTarjetas[i].getNombre().equalsIgnoreCase(nombre) &&
                    this.tipoTarjetas[i].getTarifa()==tarifa){
                    result=true;
                    break;
                }        
            }
        }
        return result;
    }
    public boolean EstaVacio() {
        return this.indice==0;
    }
}
