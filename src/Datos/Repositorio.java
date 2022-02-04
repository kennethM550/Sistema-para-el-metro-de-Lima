
package Datos;

import Modelo.EstacionArreglo;
import Modelo.Operador;
import Modelo.Persona;
import Modelo.TarjetaArreglo;
import Modelo.TipoTarjetaArreglo;
import Modelo.UsuarioArreglo;
import Modelo.RutaArreglo;


public class Repositorio{
    public static TarjetaArreglo  modelotarjetas = new TarjetaArreglo(50);
    public static UsuarioArreglo modelousuarios= new UsuarioArreglo(30);
    public static TipoTarjetaArreglo arreglotipotarjeta = new TipoTarjetaArreglo();
    public static EstacionArreglo arregloestacion = new EstacionArreglo(26);
    public static RutaArreglo arregloruta = new RutaArreglo(5); 
    public static Operador operador = new Operador("006941","135","Perez","Casas","Darius","DNI","4729321");
}
