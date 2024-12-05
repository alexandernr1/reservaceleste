
package Logica;

import Datos.Dlistaespera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Flistaespera {
     private javax.swing.JTable tablalistado;
   
   private final Cconexion mysql=new Cconexion();
   private final Connection cn = mysql.establecerConexion();
   private String sSQL="";
   public Integer totalregistros;
   
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","idempleado","Numero","Empleado","Fecha","Cantidadpersonas","Tipohabitacion","Hora llejaga","Cliente", "Estado"};
       
       String [] registro =new String [10];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from espera where numero like '%"+ buscar + "%' order by idespera";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idespera");
               registro [1]=rs.getString("idempleado");
               registro [2]=rs.getString("numero");
               registro [3]=rs.getString("empleado");
               registro [4]=rs.getString("fecha");
               registro [5]=rs.getString("cantidadpersonas");
               registro [6]=rs.getString("tipohabitacion");
               registro [7]=rs.getString("hora_llegada");
               registro [8]=rs.getString("cliente");
               registro [9]=rs.getString("estado");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (SQLException e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   public boolean insertar (Dlistaespera dts){
       sSQL="insert into espera (idempleado,numero,empleado,fecha,cantidadpersonas,tipohabitacion,hora_llegada,cliente,estado)" +
               "values (?,?,?,?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdempleado());
           pst.setInt(2, dts.getNumero());
           pst.setString(3, dts.getEmpleado());   
           pst.setDate(4, dts.getFecha());
           pst.setInt(5, dts.getCantidadpersonas());
           pst.setString(6, dts.getTipohabitacion());
           pst.setDate(7, dts.getHora_llegada());
           pst.setString(8, dts.getCliente());
           pst.setString(9, dts.getEstado());
           
           int n=pst.executeUpdate();
           
           return n!=0;
     
       } catch (SQLException e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
   
   public boolean eliminar (Dlistaespera dts){
       sSQL="delete from habitacion where idhabitacion=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdespera());
           
           int n=pst.executeUpdate();
           
           return n!=0;
           
       } catch (SQLException e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
}
