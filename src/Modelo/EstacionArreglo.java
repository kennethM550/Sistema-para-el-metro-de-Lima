
package Modelo;

import java.io.Serializable;


public class EstacionArreglo implements Serializable{
    private Estacion arregloE[];
    private int indice;
    private final String[] cabeceraE =  {"NOMBRE","CODIGO"};

    public EstacionArreglo(int tamaño) {
        this.indice = 0;
        this.arregloE = new Estacion[tamaño];
    }
    private void crecerArregloE(Estacion estacion){
        Estacion nuevoArregloE[] = new Estacion[indice+1];
         nuevoArregloE[indice] = estacion;
         for(int i =0 ; i<this.indice;i++){
             nuevoArregloE[i]= this.arregloE[i];
         }
         this.arregloE = nuevoArregloE;
    }
    
    private boolean estaLleno(){
        boolean result = false;
            if(this.indice!=0){
                result=true;
            }
        return result;
    }
    public boolean agregar(Estacion estacion){
        boolean result = false;
        if(!EstacionRegistrada(estacion.getNombre(),estacion.getCodigo())){
            if(estaLleno()){
               crecerArregloE(estacion);
            }
            this.arregloE[this.indice] = estacion;
            this.indice++;
            result= true;
        }
        return result;
    }
    public boolean EstacionRegistrada(String nombre, String codigo){
        boolean result=false;
        if(this.indice>0){
            for(int i=0;i<indice;i++){
                if(this.arregloE[i].getNombre().equalsIgnoreCase(nombre) &&
                    this.arregloE[i].getCodigo().equalsIgnoreCase(codigo)){
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
                resultado[indice] = this.arregloE[indice];
            }
        }
        return resultado;
    }
    public Object[][] getDatosE(){
        Object resultado[][] = new Object[this.indice][2];
        if(!EstaVacio()){
            for(int indice = 0; indice< this.indice;indice++){
                resultado[indice][0] = this.arregloE[indice].getNombre();
                resultado[indice][1] = this.arregloE[indice].getCodigo();
            }
        }
        return resultado;
    }
    
    public int encontrarEstacion(String codigo) {
        int resultado = -1;
         for(int indice=0; indice < this.indice; indice++){
            if( this.arregloE[indice].getCodigo().equalsIgnoreCase(codigo) ) {
                resultado = indice;
                break;
            }
        }
        return resultado;
    }
    public boolean eliminar(String codigoeliminar) {
        boolean resultado = false;
        int encontrado = this.encontrarEstacion(codigoeliminar);
        if( encontrado >= 0  ) {
            moverElementos(encontrado);
            resultado = true;
        }
        return resultado;
    }
    
    public void moverElementos(int posicion) {
        this.indice--;
        for(;posicion<indice ;posicion++){
            this.arregloE[posicion] = this.arregloE[posicion+1];
        }
        this.arregloE[indice]= null;
    }
    
    public String[] getCabeceraE() {
        return cabeceraE;
    }
    
    public boolean EstaVacio() {
        return this.indice==0;
    }
}
