
package Modelo;

import java.io.Serializable;

public class UsuarioArreglo implements Serializable{
    private Usuario arregloU [];
    private int indice;
    private final String[] cabeceraU =  {"PATERNO","MATERNO",
                            "NOMBRES","TIPO DE DOCUMENTO","NUMERO DE DOCUMENTO","NUMERO DE TARJETA"};

    public UsuarioArreglo(int tamaño) {
        this.indice = 0;
        this.arregloU = new Usuario[tamaño];
    }
    public boolean agregar(Usuario usuario){
        boolean result = false;
        if(!documentoRegistrado(usuario.getTipoDocumento(),usuario.getNumDocumento())){
            if(estaLleno()){
               crecerArreglo(usuario);
            }
            this.arregloU[this.indice] = usuario;
            this.indice++;
            result= true;
        }
        return result;
    }
    public Usuario getUsuario(String tipo, String documento){
        Usuario result = null;
        if (documentoRegistrado(tipo,documento)) {
            for (int i = 0; i < this.arregloU.length; i++) {
                if(this.arregloU[i].getNumDocumento().equals(documento)&& 
                    this.arregloU[i].getTipoDocumento().equals(tipo)){
                    result = this.arregloU[i];
                }
            }
        }
        return result;
    }
    public boolean documentoRegistrado(String tipo, String documento){
        boolean result=false;
        if(this.indice>0){
            for(int i=0;i<indice;i++){
                if(this.arregloU[i].getNumDocumento().equalsIgnoreCase(documento) &&
                    this.arregloU[i].getTipoDocumento().equalsIgnoreCase(tipo)){
                    result=true;
                    break;
                }        
            }
        }
        return result;
    }
    private void crecerArreglo(Usuario usuario){
        Usuario nuevoArreglo[] = new Usuario[this.arregloU.length+1];
         nuevoArreglo[this.arregloU.length] = usuario;
         for(int i =0 ; i<this.arregloU.length;i++){
             nuevoArreglo[i]= this.arregloU[i];
         }
         this.arregloU = nuevoArreglo;
    }
    
    private boolean estaLleno(){
        boolean result = false;
            if(this.arregloU.length!=0){
                result=true;
            }
        return result;
    }
    public Object[][] getDatosU(){
        Object resultado[][] = new Object[this.indice][6];
        if(!isVacioU()){
            for(int indice = 0; indice< this.indice;indice++){
                resultado[indice][0] = this.arregloU[indice].getPaterno();
                resultado[indice][1] = this.arregloU[indice].getMaterno();
                resultado[indice][2] = this.arregloU[indice].getNombres();
                resultado[indice][3] = this.arregloU[indice].getTipoDocumento();
                resultado[indice][4] = this.arregloU[indice].getNumDocumento();
                resultado[indice][5] = this.arregloU[indice].obtenertarjeta().getNumero();
            }
        }
        return resultado;
    }
    public String[] getCabeceraU() {
        return cabeceraU;
    }
    public boolean isVacioU() {
        return this.indice==0;
    }
    public String toString() {
        String result="";
        for(int i =0 ; i< this.indice ; i++ ){
            result += this.arregloU[i] + "\n";
        }
        return result;
    }
}

