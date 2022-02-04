
package Modelo;

import java.io.Serializable;


public class TarjetaArreglo implements Serializable{
    private Tarjeta tarjetas[];
    private int indice;

    public TarjetaArreglo(int tamaño){
        this.indice=0;
        tarjetas=new Tarjeta[tamaño];
    }
    public boolean agregarTarjeta(Tarjeta tarjeta){
        boolean result = false;
            if(estaLlenoT()){
               crecerArregloT(tarjeta);
            }
            tarjeta.setNumero(22000+indice);
            this.tarjetas[this.indice] = tarjeta;
            this.indice++;
            result= true;
        return result;
    }
    private void crecerArregloT(Tarjeta tarjeta){
        Tarjeta nuevoArregloT[] = new Tarjeta[indice+1];
         nuevoArregloT[indice] = tarjeta;
         for(int i =0 ; i<this.indice;i++){
             nuevoArregloT[i]= this.tarjetas[i];
         }
         this.tarjetas = nuevoArregloT;
    }
    
    private boolean estaLlenoT(){
        boolean result = false;
            if(this.indice!=0){
                result=true;
            }
        return result;
    }
    public boolean validarTarjeta(int numero, String contraseña){
        boolean result=false;
        for(int i=0;i<indice;i++){
            if(numero==tarjetas[i].getNumero() && tarjetas[i].getContraseña().equals(contraseña)){
                result=true;
            }
        }
        return result;
    }
    public Tarjeta getTarjeta(int numero, String contraseña){
        Tarjeta result = null;
        if (validarTarjeta(numero,contraseña)) {
            for (int i = 0; i < this.indice; i++) {
                if(this.tarjetas[i].getNumero()==numero && 
                    this.tarjetas[i].getContraseña().equals(contraseña)){
                    result = this.tarjetas[i];
                }
            }
        }
        return result;
    }
}
