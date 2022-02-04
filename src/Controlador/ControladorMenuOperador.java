
package Controlador;
import Vista.MenuOperado;
import Vista.IngresoOperador;
import Datos.Repositorio;
import Modelo.Estacion;
import Modelo.EstacionArreglo;
import Modelo.Ruta;
import Modelo.RutaArreglo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class ControladorMenuOperador {
    private MenuOperado fMenuOperado;
    
    public ControladorMenuOperador(MenuOperado fMenuOperado){
        this.fMenuOperado=fMenuOperado;
        
        this.fMenuOperado.tblUsuarios.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String codigo=null;
                int fila = fMenuOperado.tblUsuarios.rowAtPoint(e.getPoint());
                int columna = fMenuOperado.tblUsuarios.columnAtPoint(e.getPoint());
                if (fila > -1 ){
                     System.out.println(fMenuOperado.tblUsuarios.getValueAt(fila,1));
                }
            }
        });
        this.fMenuOperado.tblRutas.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String codigo=null;
                int fila = fMenuOperado.tblRutas.rowAtPoint(e.getPoint());
                int columna = fMenuOperado.tblRutas.columnAtPoint(e.getPoint());
                if (fila > -1 ){
                     System.out.println(fMenuOperado.tblRutas.getValueAt(fila,0));
                }
            }
        });
        this.fMenuOperado.btnAgregarR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(validarR()){
                    if(Repositorio.arregloruta.encontrarRuta(fMenuOperado.txtLinea.getText())== -1 ){
                        String linea = fMenuOperado.txtLinea.getText();
                        Repositorio.arregloruta.agregar(new Ruta(linea));
                        JOptionPane.showMessageDialog(fMenuOperado, "Registro exitoso" , "Agregar Ruta" , JOptionPane.INFORMATION_MESSAGE);
                        limpiarcontroles();
                    }else{
                        JOptionPane.showMessageDialog(fMenuOperado, "Linea ya esta registrada" , "Agregar Ruta" , JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(fMenuOperado,"Debe ingresar un valor ", "Agregar Ruta" , JOptionPane.ERROR_MESSAGE  );
                }
            }
        });
        this.fMenuOperado.btnEliminarR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int fila = fMenuOperado.tblRutas.getSelectedRow();
                int columna = fMenuOperado.tblRutas.getSelectedColumn();
                if( fila >= 0 ){
                        String codigoeliminar = fMenuOperado.tblRutas.getValueAt(fila, 0).toString();
                        Repositorio.arregloruta.eliminar(codigoeliminar);
                        limpiarcontroles();
                        JOptionPane.showMessageDialog(fMenuOperado,"Ruta eliminada", "Eliminar Ruta" , JOptionPane.INFORMATION_MESSAGE );
                }else{
                    if(Repositorio.arregloruta.EstaVacio()){
                        JOptionPane.showMessageDialog(fMenuOperado,"No existen rutas para eliminar" , "Eliminar Ruta" , JOptionPane.WARNING_MESSAGE );
                    }else{
                        JOptionPane.showMessageDialog(fMenuOperado,"Debe seleccionar una fila de la tabla ", "Eliminar Ruta" , JOptionPane.ERROR_MESSAGE );
                    }
                }
            }
        });
        this.fMenuOperado.tblEstaciones.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String codigo=null;
                int fila = fMenuOperado.tblEstaciones.rowAtPoint(e.getPoint());
                int columna = fMenuOperado.tblEstaciones.columnAtPoint(e.getPoint());
                if (fila > -1 ){
                     System.out.println(fMenuOperado.tblEstaciones.getValueAt(fila,1));
                }
            }
        });
        this.fMenuOperado.btnAgregarE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(validarE()){
                    if(Repositorio.arregloestacion.encontrarEstacion(fMenuOperado.txtCodigoE.getText())== -1 ){
                        String codigo = fMenuOperado.txtCodigoE.getText();
                        String nombre = fMenuOperado.txtNombreE.getText();
                        Repositorio.arregloestacion.agregar(new Estacion(nombre,codigo));
                        JOptionPane.showMessageDialog(fMenuOperado, "Registro exitoso" , "Agregar Estacion" , JOptionPane.INFORMATION_MESSAGE);
                        limpiarcontroles();
                    }else{
                        JOptionPane.showMessageDialog(fMenuOperado, "Código ya esta registrado" , "Agregar Estacion" , JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(fMenuOperado,"Debe ingresar valores en todos los campos ", "Agregar Estacion" , JOptionPane.ERROR_MESSAGE  );
                }
            }
        });
         this.fMenuOperado.btnEliminarE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int fila = fMenuOperado.tblEstaciones.getSelectedRow();
                int columna = fMenuOperado.tblEstaciones.getSelectedColumn();
                if( fila >= 0 ){
                        String codigoeliminar = fMenuOperado.tblEstaciones.getValueAt(fila, 1).toString();
                        Repositorio.arregloestacion.eliminar(codigoeliminar);
                        limpiarcontroles();
                        JOptionPane.showMessageDialog(fMenuOperado,"Estacion eliminada", "Eliminar Estacion" , JOptionPane.INFORMATION_MESSAGE );
                }else{
                    if(Repositorio.arregloestacion.EstaVacio()){
                        JOptionPane.showMessageDialog(fMenuOperado,"No existen estaciones para eliminar" , "Eliminar Estacion" , JOptionPane.WARNING_MESSAGE );
                    }else{
                        JOptionPane.showMessageDialog(fMenuOperado,"Debe Seleccionar una fila de la tabla ", "Eliminar Estacion" , JOptionPane.ERROR_MESSAGE );
                    }
                }
            }
        });
        this.fMenuOperado.btnSalir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngresoOperador vista = new IngresoOperador();
                ControladorIngresoOperador controlador = new ControladorIngresoOperador(Repositorio.operador,vista);
                controlador.iniciar();
                vista.setVisible(true);    
                fMenuOperado.dispose(); 
                SerializadoraGen.serializar("datosEstaciones.txt", Repositorio.arregloestacion);
                SerializadoraGen.serializar("datosRutas.txt", Repositorio.arregloruta);
            }
        });
    }
    
    private void limpiarcontroles() {
        fMenuOperado.txtCodigoE.setText("");
        fMenuOperado.txtNombreE.setText("");
        fMenuOperado.txtNombreE.requestFocus();
        fMenuOperado.txtLinea.setText("");
        DefaultTableModel modelotabla = new DefaultTableModel(Repositorio.modelousuarios.getDatosU(),Repositorio.modelousuarios.getCabeceraU());
        this.fMenuOperado.tblUsuarios.setModel(modelotabla);
        DefaultTableModel modelotabla1 = new DefaultTableModel(Repositorio.arregloruta.getDatosRuta(),Repositorio.arregloruta.getCabeceraRuta());
        this.fMenuOperado.tblRutas.setModel(modelotabla1);
        DefaultTableModel modelotabla2 = new DefaultTableModel(Repositorio.arregloestacion.getDatosE(),Repositorio.arregloestacion.getCabeceraE());
        this.fMenuOperado.tblEstaciones.setModel(modelotabla2);
        
    }
    
    public void iniciar(){
        fMenuOperado.setLocationRelativeTo(null);
        fMenuOperado.setVisible(true);
        limpiarcontroles();
    }
    
    private boolean validarE() {
        boolean resultado = false;
        if (this.fMenuOperado.txtCodigoE.getText().length()!= 0 &&
                this.fMenuOperado.txtNombreE.getText().length()!= 0   
                ){
            resultado = true;
        }
        return resultado;
    }
    private boolean validarR() {
        boolean resultado = false;
        if (this.fMenuOperado.txtLinea.getText().length()!= 0){
            resultado = true;
        }
        return resultado;
    }
}
