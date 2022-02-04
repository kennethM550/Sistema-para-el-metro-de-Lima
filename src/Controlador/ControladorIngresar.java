
package Controlador;

import Modelo.TarjetaArreglo;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import Datos.Repositorio;
import Vista.MenuIngreso;
import Vista.Ingresar;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorIngresar {
    private TarjetaArreglo modelo;
    private Ingresar fIngresar;
   
    public ControladorIngresar(TarjetaArreglo modelo, Ingresar fIngresar) {
        this.modelo=modelo;
        this.fIngresar=fIngresar;
        
        this.fIngresar.btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               if ( modelo.validarTarjeta(Integer.parseInt(fIngresar.txtnumTarjeta.getText()),fIngresar.txtcontraseña.getText()) ) {
                    fIngresar.dispose();
                    MenuIngreso vista = new MenuIngreso();
                    ControladorMenuIngreso controlador = new ControladorMenuIngreso(Repositorio.modelotarjetas.getTarjeta
                    (Integer.parseInt(fIngresar.txtnumTarjeta.getText()),fIngresar.txtcontraseña.getText()),vista);
                    controlador.iniciar();
                    vista.setVisible(true);
                    controlador.MostrarDatos();
                }
                else{
                    JOptionPane.showMessageDialog(fIngresar, "Error de numero y/o contraseña");
                }
            }
        });
        this.fIngresar.btnRetroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MenuPrincipal vista = new MenuPrincipal();
                ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(vista);
                controlador.iniciar();
                vista.setVisible(true);        
                fIngresar.dispose();
            }
        });
    }
    public void iniciar(){
        fIngresar.setLocationRelativeTo(null);
        fIngresar.setVisible(true);
        limpiarcontroles();
    }
    private void limpiarcontroles() {
        fIngresar.txtnumTarjeta.setText("");
        fIngresar.txtcontraseña.setText("");
    }
}
        
    
