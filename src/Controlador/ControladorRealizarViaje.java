
package Controlador;
import Modelo.Tarjeta;
import Modelo.Estacion;
import Modelo.Ruta;
import Datos.Repositorio;
import Vista.RealizarViaje;
import Vista.MenuIngreso;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;

public class ControladorRealizarViaje{
    private Tarjeta modelo;
    private RealizarViaje fRealizarViaje;
    
    public ControladorRealizarViaje(Tarjeta modelo,RealizarViaje fRealizarViaje){
        this.modelo=modelo;
        this.fRealizarViaje=fRealizarViaje;
        
        this.fRealizarViaje.btnPagar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(validar()){
                    Ruta ruta = (Ruta)fRealizarViaje.cboRuta.getSelectedItem();
                    Estacion estacioninicio = (Estacion) fRealizarViaje.cboEstacioninicio.getSelectedItem();
                    Estacion estacionllegada = (Estacion) fRealizarViaje.cboEstacionllegada.getSelectedItem();
                    modelo.PagarViaje(estacioninicio,estacionllegada,ruta);
                    JOptionPane.showMessageDialog(fRealizarViaje, "Tenga un buen Viaje","Viaje", JOptionPane.INFORMATION_MESSAGE);
                    limpiarcontroles();
                }
                else{
                    JOptionPane.showMessageDialog(fRealizarViaje,"Debe seleccionar alguna opcion", "Viaje erroneo" ,JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        this.fRealizarViaje.btnRetroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MenuIngreso  vista = new MenuIngreso ();
                ControladorMenuIngreso controlador = new ControladorMenuIngreso(modelo,vista);
                controlador.iniciar();
                vista.setVisible(true);  
                fRealizarViaje.dispose();
            }
        });
    }
    
  public void iniciar(){
        fRealizarViaje.setLocationRelativeTo(null);
        fRealizarViaje.setVisible(true);
        DefaultComboBoxModel modelocombobox = new DefaultComboBoxModel();
        for( Object o : Repositorio.arregloestacion.getDatosCombo()){
            modelocombobox.addElement(o);
        }
        this.fRealizarViaje.cboEstacioninicio.setModel(modelocombobox);
        
        DefaultComboBoxModel modelocombobox1 = new DefaultComboBoxModel();
        for( Object o : Repositorio.arregloestacion.getDatosCombo()){
            modelocombobox1.addElement(o);
        }
        this.fRealizarViaje.cboEstacionllegada.setModel(modelocombobox1);
        
        
        DefaultComboBoxModel modelocombobox2 = new DefaultComboBoxModel();
        for( Object o : Repositorio.arregloruta.getDatosCombo()){
            modelocombobox2.addElement(o);
        }
        this.fRealizarViaje.cboRuta.setModel(modelocombobox2);
        limpiarcontroles();
    }
    private void limpiarcontroles() {
        fRealizarViaje.cboEstacioninicio.setSelectedIndex(-1);
        fRealizarViaje.cboEstacionllegada.setSelectedIndex(-1);
        fRealizarViaje.cboRuta.setSelectedIndex(-1);
    }  
    private boolean validar(){
        boolean resultado = false;
        if (this.fRealizarViaje.cboRuta.getSelectedIndex() != -1 && 
                this.fRealizarViaje.cboEstacioninicio.getSelectedIndex() != -1 &&
                this.fRealizarViaje.cboEstacionllegada.getSelectedIndex() != -1 
                ){
            resultado = true;
        }
        return resultado;
    }
}

