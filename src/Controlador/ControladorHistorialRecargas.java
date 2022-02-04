
package Controlador;
import Modelo.Tarjeta;
import Vista.HistorialRecargas;
import Vista.MenuIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ControladorHistorialRecargas {
    private Tarjeta modelo;
    private HistorialRecargas fHistorialRecargas;
    
    public ControladorHistorialRecargas(Tarjeta modelo,HistorialRecargas fHistorialRecargas){
        this.modelo=modelo;
        this.fHistorialRecargas=fHistorialRecargas;
        
       this.fHistorialRecargas.btnRetroceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MenuIngreso vista = new MenuIngreso();
                ControladorMenuIngreso controlador = new ControladorMenuIngreso(modelo,vista);
                controlador.iniciar();
                vista.setVisible(true);   
                fHistorialRecargas.dispose();
            }
        });
     
       this.fHistorialRecargas.tblRecargas.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String codigo=null;
                int fila = fHistorialRecargas.tblRecargas.rowAtPoint(e.getPoint());
                int columna = fHistorialRecargas.tblRecargas.columnAtPoint(e.getPoint());
                if (fila > -1 ){
                     System.out.println(fHistorialRecargas.tblRecargas.getValueAt(fila,1));
                }
            }
        });
    }
    
    public void iniciar(){
        fHistorialRecargas.setLocationRelativeTo(null);
        fHistorialRecargas.setVisible(true);
        DefaultTableModel modelotabla = new DefaultTableModel(this.modelo.getDatosR(),this.modelo.getCabeceraR());
        this.fHistorialRecargas.tblRecargas.setModel(modelotabla);
    }   
}
