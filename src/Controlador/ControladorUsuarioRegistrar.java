
package Controlador;

import Modelo.UsuarioArreglo;
import Modelo.TipoTarjeta;
import Modelo.Usuario;
import Modelo.Tarjeta;
import Datos.Repositorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Vista.UsuarioRegistrar;
import Vista.MenuPrincipal;


public class ControladorUsuarioRegistrar{
    private UsuarioArreglo modelo;
    private UsuarioRegistrar fUsuarioRegistrar;
    
    public ControladorUsuarioRegistrar(UsuarioArreglo modelo, UsuarioRegistrar fUsuarioRegistrar){
        this.modelo=modelo;
        this.fUsuarioRegistrar=fUsuarioRegistrar;
       
        this.fUsuarioRegistrar.btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               if(validar()){
                    String nombres = fUsuarioRegistrar.txtNombres.getText().toUpperCase();
                    String paterno = fUsuarioRegistrar.txtPaterno.getText().toUpperCase();
                    String materno = fUsuarioRegistrar.txtMaterno.getText().toUpperCase();
                    String tipodocumento = fUsuarioRegistrar.cboTipodoc.getSelectedItem().toString();
                    String numdoc = fUsuarioRegistrar.txtNumdoc.getText().toUpperCase();
                    TipoTarjeta tipoTarjeta = (TipoTarjeta)fUsuarioRegistrar.cboTipoTarjeta.getSelectedItem();
                    String contraseña = fUsuarioRegistrar.txtContraseña.getText().toUpperCase();
                    Tarjeta tarjeta = new Tarjeta(contraseña,tipoTarjeta); 
                    Usuario usuario = new Usuario(paterno,materno,nombres,tipodocumento,numdoc);
                    usuario.registrarTarjeta(tarjeta);
                    modelo.agregar(usuario);
                    JOptionPane.showMessageDialog(fUsuarioRegistrar, "\nNumero de su Tarjeta: " +tarjeta.getNumero() , "Registro Exitoso" , JOptionPane.INFORMATION_MESSAGE);
                    limpiarcontroles();
                    SerializadoraGen.serializar("datosUsuarios.txt", Repositorio.modelousuarios);
                    SerializadoraGen.serializar("datosTarjetas.txt", Repositorio.modelotarjetas);
               }
               else{
                   JOptionPane.showMessageDialog(fUsuarioRegistrar,"Debe ingresar valores en todos los campos ", "Registro erroneo" , JOptionPane.ERROR_MESSAGE  );
               }
            }
        });
        this.fUsuarioRegistrar.btnRetroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MenuPrincipal vista = new MenuPrincipal();
                ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(vista);
                controlador.iniciar();
                vista.setVisible(true);        
                fUsuarioRegistrar.dispose();
            }
        });
    }
     
    public void iniciar_vista(){
        fUsuarioRegistrar.setTitle( "Registro de Usuario" );
        fUsuarioRegistrar.setLocationRelativeTo(null); 
        
        DefaultComboBoxModel modelocombobox = new DefaultComboBoxModel();
        for( Object o : Repositorio.arreglotipotarjeta.getDatosCombo()){
            modelocombobox.addElement(o);
        }
        this.fUsuarioRegistrar.cboTipoTarjeta.setModel(modelocombobox);
        limpiarcontroles();
    }
        
    private void limpiarcontroles() {
        fUsuarioRegistrar.txtNombres.setText("");
        fUsuarioRegistrar.txtPaterno.setText("");
        fUsuarioRegistrar.txtMaterno.setText("");
        fUsuarioRegistrar.cboTipodoc.setSelectedIndex(-1);
        fUsuarioRegistrar.txtNumdoc.setText("");
        fUsuarioRegistrar.cboTipoTarjeta.setSelectedIndex(-1);
        fUsuarioRegistrar.txtContraseña.setText("");
    }
    private boolean validar() {
        boolean resultado = false;
        if (this.fUsuarioRegistrar.txtNombres.getText().length()!= 0 &&
                this.fUsuarioRegistrar.txtPaterno.getText().length()!= 0 &&
                this.fUsuarioRegistrar.txtMaterno.getText().length()!= 0 &&
                this.fUsuarioRegistrar.cboTipodoc.getSelectedIndex() != -1 &&
                this.fUsuarioRegistrar.txtNumdoc.getText().length()!= 0 &&
                this.fUsuarioRegistrar.cboTipoTarjeta.getSelectedIndex() != -1 &&
                this.fUsuarioRegistrar.txtContraseña.getText().length()!= 0
                ){
            resultado = true;
        }
        return resultado;
    }

}
     