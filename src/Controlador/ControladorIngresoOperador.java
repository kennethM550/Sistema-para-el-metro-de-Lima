
package Controlador;

import java.awt.event.ActionEvent;
import Datos.Repositorio;
import Modelo.Operador;
import Vista.MenuPrincipal;
import Vista.IngresoOperador;
import Vista.MenuOperado;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorIngresoOperador {
    private Operador modelo;
    private IngresoOperador fIngresoOperador;
   
    public ControladorIngresoOperador(Operador modelo, IngresoOperador fIngresoOperador) {
        this.modelo=modelo;
        this.fIngresoOperador=fIngresoOperador;
        
        this.fIngresoOperador.btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               if ( modelo.ingresar(fIngresoOperador.txtCodigo.getText(),fIngresoOperador.txtContraseña.getText())){
                    MenuOperado vista =  new MenuOperado();
                    ControladorMenuOperador controlador = new ControladorMenuOperador(vista);
                    controlador.iniciar();
                    fIngresoOperador.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(fIngresoOperador, "Error de numero y/o contraseña");
                }
            }
        });
        this.fIngresoOperador.btnRetroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MenuPrincipal vista = new MenuPrincipal();
                ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(vista);
                controlador.iniciar();
                vista.setVisible(true);        
                fIngresoOperador.dispose();
            }
        });
    }
    public void iniciar(){
        fIngresoOperador.setLocationRelativeTo(null);
        fIngresoOperador.setVisible(true);
        limpiarcontroles();
    }
    private void limpiarcontroles() {
        fIngresoOperador.txtCodigo.setText("");
        fIngresoOperador.txtContraseña.setText("");
    }
}
