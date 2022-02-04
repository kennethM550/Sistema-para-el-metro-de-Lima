
package Modelo;

import java.io.Serializable;


public class Usuario extends Persona implements Serializable{
    private Tarjeta tarjetas[];
    private int indice; 
    
    public Usuario(String paterno, String materno, String nombres, String tipoDocumento, String numDocumento) {
        super(paterno,materno,nombres,tipoDocumento,numDocumento);
        this.indice=0;
        this.tarjetas = new Tarjeta[5];
    }
    
    public boolean registrarTarjeta(Tarjeta tarjeta){          
        boolean result = false;
        if(!estaLleno()){
            this.tarjetas[this.indice]= tarjeta;
            this.indice++;
            result = true;
        }
        return result;
    }
    
    private boolean estaLleno() {
        if(this.indice == 5){
            return true;
        }else {
            return false;
        }
    }
    public boolean renovarTarjeta(){
        int cant=0;
        int j=-1;
        for(int i=0;i<this.indice;i++){
            if(tarjetas[i].getEstado()=="Malo"){
                cant+=tarjetas[i].getSaldo();
            }
            else{
                if(j==-1) j=i;
            }
        }
        if(j!=-1){
            tarjetas[j].setSaldo(tarjetas[j].getSaldo()+cant);
            return true;
        }
        return false;
    }
    public Tarjeta obtenertarjeta(){
        return this.tarjetas[0];
    }

}
