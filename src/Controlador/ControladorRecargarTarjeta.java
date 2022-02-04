
package Controlador;

import Modelo.Tarjeta;
import Modelo.Estacion;
import Vista.RecargarTarjeta;
import Vista.MenuIngreso;
import Datos.Repositorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

public class ControladorRecargarTarjeta {
    private Tarjeta modelo;
    private RecargarTarjeta fRecargarTarjeta;
    
    public ControladorRecargarTarjeta(Tarjeta modelo,RecargarTarjeta fRecargarTarjeta){
       this.modelo=modelo;
       this.fRecargarTarjeta=fRecargarTarjeta;
       
       this.fRecargarTarjeta.btnRetroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MenuIngreso vista = new MenuIngreso();
                ControladorMenuIngreso controlador = new ControladorMenuIngreso(modelo,vista);
                controlador.iniciar();
                vista.setVisible(true);   
                fRecargarTarjeta.dispose();
            }
        });
       this.fRecargarTarjeta.btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(Float.parseFloat(fRecargarTarjeta.txtMonto.getText().toUpperCase())> 0){
                    float monto =Float.parseFloat(fRecargarTarjeta.txtMonto.getText().toUpperCase());
                    Estacion estacion = (Estacion)fRecargarTarjeta.cboEstacion.getSelectedItem();
                    modelo.Recargar(monto,estacion);
                    JOptionPane.showMessageDialog(fRecargarTarjeta, "Recarga exitosa","Recarga", JOptionPane.INFORMATION_MESSAGE);
                    limpiarcontroles();
                }
                else{
                    JOptionPane.showMessageDialog(fRecargarTarjeta, "Ingrese un monto correcto ","Recarga", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    
    public void iniciar(){
        fRecargarTarjeta.setLocationRelativeTo(null);
        fRecargarTarjeta.setVisible(true);
        DefaultComboBoxModel modelocombobox = new DefaultComboBoxModel();
        for( Object o : Repositorio.arregloestacion.getDatosCombo()){
            modelocombobox.addElement(o);
        }
        this.fRecargarTarjeta.cboEstacion.setModel(modelocombobox);
        limpiarcontroles();
    }
    private void limpiarcontroles() {
        fRecargarTarjeta.txtMonto.setText("");
        fRecargarTarjeta.cboEstacion.setSelectedIndex(-1);
    }

}   

