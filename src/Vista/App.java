
package Vista;

import Modelo.Estacion;
import Modelo.Tarjeta;
import Modelo.TarjetaArreglo;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import Modelo.Ruta;
import Modelo.TipoTarjeta;
import Modelo.Estacion;
import Datos.Repositorio;


public class App {
    public static void main(String[] args){
        /*
        UsuarioArreglo arreglo1 = new UsuarioArreglo(5);
        Usuario usuario1 = new Usuario("Mendoza","Torres","Dante Alexis","DNI","89742341");
        arreglo1.agregar(usuario1);
        TarjetaArreglo arreglot = new TarjetaArreglo(5);
        Tarjeta t= new Tarjeta(10f,"Estandar",1234);
        arreglot.agregarTarjeta(t);
        System.out.println(t.getTipo().getTarifa());
        System.out.println(t.getNumero());
        usuario1.registrarTarjeta(t);
        Ruta ruta1= new Ruta(1);
        Estacion est = new Estacion("La Cultura","42314");
        t.Recargar(4, est);
        System.out.println(t.getSaldo());
        Estacion estb = new Estacion("Las Perlas","42201");
        t.PagarViaje(est,estb,ruta1);
        System.out.println(t.getSaldo());
        Usuario usuario2 = new Usuario("Sanchez","Jimenez","Carlos Pepe","Pasaporte","200348513");
        arreglo1.agregar(usuario2);
        Tarjeta t2=new Tarjeta(20f,"Medio",321);
        arreglot.agregarTarjeta(t);
        usuario2.registrarTarjeta(t2);
        Estacion estc = new Estacion("Villa Maria","42080");
        t2.Recargar(5,estc);
        t2.PagarViaje(estc,estb,ruta1);
        System.out.println(arreglo1);
        */
        Estacion Estacion1 = new Estacion("Bayovar","101");
        Estacion Estacion2 = new Estacion("Santa Rosa","102");
        Estacion Estacion3 = new Estacion("Santa Martín","103");
        Estacion Estacion4 = new Estacion("San Carlos","104");
        Estacion Estacion5 = new Estacion("Los Postes","105");
        Estacion Estacion6 = new Estacion("Los Jardines","106");
        Estacion Estacion7 = new Estacion("Pirámide del Sol","107");
        Estacion Estacion8 = new Estacion("Caja de Agua","108");
        Estacion Estacion9 = new Estacion("Presbítero Maestro","109");
        Estacion Estacion10 = new Estacion("El Ángel","110");
        Estacion Estacion11 = new Estacion("Miguel Grau","111");
        Estacion Estacion12 = new Estacion("Gamarra","112");
        Estacion Estacion13 = new Estacion("Arriola","113");
        Estacion Estacion14 = new Estacion("La Cultura","114");
        Estacion Estacion15 = new Estacion("San Borja Sur","115");
        Estacion Estacion16 = new Estacion("Angamos","116");
        Estacion Estacion17 = new Estacion("Cabitos","117");
        Estacion Estacion18 = new Estacion("Ayacucho","118");
        Estacion Estacion19 = new Estacion("Jorge Chavéz","119");
        Estacion Estacion20 = new Estacion("Atocongo","120");
        Estacion Estacion21 = new Estacion("San Juan","121");
        Estacion Estacion22 = new Estacion("María Auxiliadora","122");
        Estacion Estacion23 = new Estacion("Villa María","123");
        Estacion Estacion24 = new Estacion("Pumacahua","124");
        Estacion Estacion25 = new Estacion("Parque Industrial","125");
        Estacion Estacion26 = new Estacion("Villa el Salvador","126");
        Repositorio.arregloestacion.agregar(Estacion1);
        Repositorio.arregloestacion.agregar(Estacion1);
        Repositorio.arregloestacion.agregar(Estacion2);
        Repositorio.arregloestacion.agregar(Estacion3);
        Repositorio.arregloestacion.agregar(Estacion4);
        Repositorio.arregloestacion.agregar(Estacion5);
        Repositorio.arregloestacion.agregar(Estacion6);
        Repositorio.arregloestacion.agregar(Estacion7);
        Repositorio.arregloestacion.agregar(Estacion8);
        Repositorio.arregloestacion.agregar(Estacion9);
        Repositorio.arregloestacion.agregar(Estacion10);
        Repositorio.arregloestacion.agregar(Estacion11);
        Repositorio.arregloestacion.agregar(Estacion12);
        Repositorio.arregloestacion.agregar(Estacion13);
        Repositorio.arregloestacion.agregar(Estacion14);
        Repositorio.arregloestacion.agregar(Estacion15);
        Repositorio.arregloestacion.agregar(Estacion16);
        Repositorio.arregloestacion.agregar(Estacion17);
        Repositorio.arregloestacion.agregar(Estacion18);
        Repositorio.arregloestacion.agregar(Estacion19);
        Repositorio.arregloestacion.agregar(Estacion20);
        Repositorio.arregloestacion.agregar(Estacion21);
        Repositorio.arregloestacion.agregar(Estacion22);
        Repositorio.arregloestacion.agregar(Estacion23);
        Repositorio.arregloestacion.agregar(Estacion24);
        Repositorio.arregloestacion.agregar(Estacion25);
        Repositorio.arregloestacion.agregar(Estacion26);    
        Ruta ruta = new Ruta("1");
        Ruta ruta1 = new Ruta("2");
        Repositorio.arregloruta.agregar(ruta);
        Repositorio.arregloruta.agregar(ruta1);
        Vista.MenuPrincipal vista = new Vista.MenuPrincipal();
        Controlador.ControladorMenuPrincipal controlador = new Controlador.ControladorMenuPrincipal(vista);
        controlador.iniciar();
    } 
}
