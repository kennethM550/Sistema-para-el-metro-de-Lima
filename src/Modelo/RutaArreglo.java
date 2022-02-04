
package Modelo;

import java.io.Serializable;


public class RutaArreglo implements Serializable{
    private Ruta arregloR[];
    private int indice;
    private final String[] cabeceraRuta =  {"Linea"};
    
    public RutaArreglo(int tamaño) {
        this.indice = 0;
        this.arregloR = new Ruta[tamaño];
    }
    private void crecerArregloR(Ruta ruta){
        Ruta nuevoArregloR[] = new Ruta[indice+1];
         nuevoArregloR[indice] = ruta;
         for(int i =0 ; i<this.indice;i++){
             nuevoArregloR[i]= this.arregloR[i];
         }
         this.arregloR = nuevoArregloR;
    }
    
    private boolean estaLleno(){
        boolean result = false;
            if(this.indice!=0){
                result=true;
            }
        return result;
    }
    public boolean agregar(Ruta ruta){
        boolean result = false;
        if(!RutaRegistrada(ruta.getLinea())){
            if(estaLleno()){
               crecerArregloR(ruta);
            }
            this.arregloR[this.indice] = ruta;
            this.indice++;
            result= true;
        }
        return result;
    }
    public boolean RutaRegistrada(String linea){
        boolean result=false; 
        if(this.indice>0){
            for(int i=0;i<indice;i++){
                if(this.arregloR[i].getLinea().equals(linea)){
                    result=true;
                    break;
                }        
            }
        }
        return result;
    }
    public Object[] getDatosCombo() {
        Object resultado[] = null;
        if(!EstaVacio()){
            resultado = new Object[this.indice];
            for(int indice=0; indice < this.indice; indice++){
                resultado[indice] = this.arregloR[indice];
            }
        }
        return resultado;
    }
    public Object[][] getDatosRuta(){
        Object resultado[][] = new Object[this.indice][1];
        if(!EstaVacio()){
            for(int indice = 0; indice< this.indice;indice++){
                resultado[indice][0] = this.arregloR[indice].getLinea();
            }
        }
        return resultado;
    }
    public String[] getCabeceraRuta() {
        return cabeceraRuta;
    }
    public int encontrarRuta(String codigo) {
        int resultado = -1;
         for(int indice=0; indice < this.indice; indice++){
            if( this.arregloR[indice].getLinea().equalsIgnoreCase(codigo) ) {
                resultado = indice;
                break;
                
            }
        }
        return resultado;
    }
    public boolean eliminar(String codigoeliminar) {
        boolean resultado = false;
        int encontrado = this.encontrarRuta(codigoeliminar);
        if( encontrado >= 0  ) {
            moverElementos(encontrado);
            resultado = true;
        }
        return resultado;
    }
    
    public void moverElementos(int posicion) {
        this.indice--;
        for(;posicion<indice ;posicion++){
            this.arregloR[posicion] = this.arregloR[posicion+1];
        }
        this.arregloR[indice]= null;
    }
    
    public boolean EstaVacio() {
        return this.indice==0;
    }
    
    
}
