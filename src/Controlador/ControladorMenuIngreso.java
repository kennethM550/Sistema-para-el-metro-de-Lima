
package Controlador;
import Modelo.Tarjeta;
import Datos.Repositorio;
import Vista.MenuIngreso;
import Vista.HistorialViajes;
import Vista.HistorialRecargas;
import Vista.Ingresar;
import Vista.RealizarViaje;
import Vista.RecargarTarjeta;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;

public class ControladorMenuIngreso {
    private Tarjeta modelo;
    private MenuIngreso fMenuIngreso;
    public ControladorMenuIngreso(Tarjeta modelo, MenuIngreso fMenuIngreso){
        this.modelo=modelo;
        this.fMenuIngreso=fMenuIngreso;
        
        
        this.fMenuIngreso.btnRecargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                 RecargarTarjeta vista = new RecargarTarjeta();
                 ControladorRecargarTarjeta controlador = new ControladorRecargarTarjeta(modelo,vista);
                 controlador.iniciar();
                 vista.setVisible(true); 
                 fMenuIngreso.dispose();
            }
        });
        this.fMenuIngreso.btnHistorialrecargas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                 HistorialRecargas vista = new HistorialRecargas();
                 ControladorHistorialRecargas controlador = new ControladorHistorialRecargas(modelo,vista);
                 controlador.iniciar();
                 fMenuIngreso.dispose();
            }
        });
        this.fMenuIngreso.btnRealizarviaje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                RealizarViaje vista = new RealizarViaje();
                ControladorRealizarViaje controlador = new ControladorRealizarViaje(modelo,vista);
                controlador.iniciar();
                vista.setVisible(true);        
                fMenuIngreso.dispose();
            }
        });
        this.fMenuIngreso.btnHistorialviajes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                HistorialViajes vista = new HistorialViajes();
                ControladorHistorialViajes controlador = new ControladorHistorialViajes(modelo,vista);
                controlador.iniciar();
                fMenuIngreso.dispose();
            }
        });
        this.fMenuIngreso.btnSalir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ingresar vista = new Ingresar();
                ControladorIngresar controlador = new ControladorIngresar(Repositorio.modelotarjetas,vista);
                controlador.iniciar();
                vista.setVisible(true);        
                fMenuIngreso.dispose();
            }
        });
    }
    public void MostrarDatos(){
        fMenuIngreso.lblSaldo.setText("S/. "+modelo.getSaldo());
        fMenuIngreso.lblnumTarjeta.setText(""+modelo.getNumero());
    }
    public void iniciar(){
        fMenuIngreso.setLocationRelativeTo(null);
        fMenuIngreso.setVisible(true);
        MostrarDatos();
    }
}
