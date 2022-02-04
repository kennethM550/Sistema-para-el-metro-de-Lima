
package Modelo;

import java.io.Serializable;


public class Operador extends Persona{
    private String codigo;
    private String contraseña;

    public Operador(String codigo, String contraseña, String paterno, String materno, String nombres, String tipoDocumento, String numDocumento) {
        super(paterno, materno, nombres, tipoDocumento, numDocumento);
        this.codigo = codigo;
        this.contraseña = contraseña;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public boolean ingresar(String codigo, String contraseña){
        boolean result= false;
        if(this.codigo.equalsIgnoreCase(codigo) && 
                this.contraseña.equals(contraseña)
            ){
            result= true;
        }
        return result;
    }
 
}
