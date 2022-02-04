
package Controlador;
import Modelo.Tarjeta;
import Vista.HistorialViajes;
import Vista.MenuIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorHistorialViajes {
    private Tarjeta modelo;
    private HistorialViajes fHistorialViajes;
    
    public ControladorHistorialViajes(Tarjeta modelo,HistorialViajes fHistorialViajes){
        this.modelo=modelo;
        this.fHistorialViajes=fHistorialViajes;
        
       this.fHistorialViajes.btnRetroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MenuIngreso vista = new MenuIngreso();
                ControladorMenuIngreso controlador = new ControladorMenuIngreso(modelo,vista);
                controlador.iniciar();
                vista.setVisible(true);   
                fHistorialViajes.dispose();
            }
        });
     
       this.fHistorialViajes.tblViajes.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String codigo=null;
                int fila = fHistorialViajes.tblViajes.rowAtPoint(e.getPoint());
                int columna = fHistorialViajes.tblViajes.columnAtPoint(e.getPoint());
                if (fila > -1 ){
                     System.out.println(fHistorialViajes.tblViajes.getValueAt(fila,1));
                }
            }
        });
    }
    
    public void iniciar(){
        fHistorialViajes.setLocationRelativeTo(null);
        fHistorialViajes.setVisible(true);
        DefaultTableModel modelotabla = new DefaultTableModel(this.modelo.getDatosV(),this.modelo.getCabeceraV());
        this.fHistorialViajes.tblViajes.setModel(modelotabla);
    }
}
