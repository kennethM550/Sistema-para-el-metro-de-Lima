
package Controlador;

import Vista.MenuPrincipal;
import Vista.UsuarioRegistrar;
import Vista.Ingresar;
import Vista.IngresoOperador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.UsuarioArreglo;
import Modelo.Usuario;
import Modelo.TarjetaArreglo;
import Modelo.Tarjeta;
import Modelo.RutaArreglo;
import Modelo.Ruta;
import Modelo.EstacionArreglo;
import Modelo.Estacion;

import Datos.Repositorio;


public class ControladorMenuPrincipal {
    private MenuPrincipal fMenuPrincipal;
   
    public ControladorMenuPrincipal(MenuPrincipal fMenuPrincipal){
       this.fMenuPrincipal = fMenuPrincipal;
   
    this.fMenuPrincipal.btnSalir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SerializadoraGen.serializar("datosUsuarios.txt", Repositorio.modelousuarios);
                SerializadoraGen.serializar("datosTarjetas.txt", Repositorio.modelotarjetas);
                System.exit(0);
            }
        }); 
    this.fMenuPrincipal.btnIngresar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ingresar vista = new Ingresar();
                ControladorIngresar controlador = new ControladorIngresar(Repositorio.modelotarjetas,vista);
                controlador.iniciar();
                vista.setVisible(true);    
                fMenuPrincipal.dispose();
                Repositorio.modelousuarios = (UsuarioArreglo)SerializadoraGen.deserializar("datosUsuarios.txt");
                Repositorio.modelotarjetas = (TarjetaArreglo)SerializadoraGen.deserializar("datosTarjetas.txt");
                Repositorio.arregloestacion = (EstacionArreglo)SerializadoraGen.deserializar("datosEstaciones.txt");
                Repositorio.arregloruta = (RutaArreglo)SerializadoraGen.deserializar("datosRutas.txt");
            }
        });
    this.fMenuPrincipal.btnIngresarO.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngresoOperador vista = new IngresoOperador();
                ControladorIngresoOperador controlador = new ControladorIngresoOperador(Repositorio.operador,vista);
                controlador.iniciar();
                vista.setVisible(true);    
                fMenuPrincipal.dispose();
                Repositorio.modelousuarios = (UsuarioArreglo)SerializadoraGen.deserializar("datosUsuarios.txt");
                Repositorio.modelotarjetas = (TarjetaArreglo)SerializadoraGen.deserializar("datosTarjetas.txt");
                Repositorio.arregloestacion = (EstacionArreglo)SerializadoraGen.deserializar("datosEstaciones.txt");
                Repositorio.arregloruta = (RutaArreglo)SerializadoraGen.deserializar("datosRutas.txt");
            }
        });
    this.fMenuPrincipal.btnRegistrarse.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioRegistrar vista = new UsuarioRegistrar();
                ControladorUsuarioRegistrar controlador = new ControladorUsuarioRegistrar(Repositorio.modelousuarios,vista);
                controlador.iniciar_vista();
                vista.setVisible(true);    
                fMenuPrincipal.dispose();
            }
        });
   
    }
   
    public void iniciar(){
        fMenuPrincipal.setLocationRelativeTo(null);
        fMenuPrincipal.setVisible(true);
    }
    
}
