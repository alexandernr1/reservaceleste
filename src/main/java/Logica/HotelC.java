package Logica;

import LogicaP.Cconexionp;
import Presentacion.LoguinDeSistema;

public class HotelC {
public static void main(String[] args) {
        LoguinDeSistema prin = new LoguinDeSistema();
        prin.setVisible(true);
        
        String opcion = "hotel";  // Esta variable debe venir del sistema, según lo que escoja el usuario

        if (opcion.equals("hotel")) {
            Cconexion conexionHotel = new Cconexion();
            conexionHotel.establecerConexion();
            System.out.println("Conectado a la base de datos del hotel");
        } else if (opcion.equals("parquedero")) {
            Cconexionp conexionParquedero = new Cconexionp();
            conexionParquedero.establecerConexion();
            System.out.println("Conectado a la base de datos del parquedero");
        }
    }
//    public static void main(String[] args) {
//        LoguinDeSistema prin = new LoguinDeSistema();
//        prin.setVisible(true);
//        Cconexion objetoConexion = new Cconexion();
//        objetoConexion.establecerConexion();
//        
//        
//    }
}
