
package LogicaP;


import DatosP.Dempleadop;
import DatosP.Dinicioturnop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Finicioturnop {
    
     private final Cconexionp mysql = new Cconexionp();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    

    ArrayList<Dempleadop>listaEMpleado = new ArrayList<>();

    
    public void agregarEmpleados(Dempleadop empleado){
        listaEMpleado.add(empleado);
    }
    
   public boolean insertar(Dinicioturnop dts) {
    sSQL = "INSERT INTO inicio_turno (fecha_hora_inicio, turno, numero_turno, estado, empleado) VALUES (?,?,?,?,?)";
    try (PreparedStatement pst = cn.prepareStatement(sSQL)) {
        pst.setString(1, dts.getFecha_hora_inicio());
        pst.setString(2, dts.getTurno());
        pst.setInt(3, dts.getNumero_turno());
        pst.setString(4, dts.getEstado());
        pst.setString(5, dts.getEmpleado());
        
        int n = pst.executeUpdate();
        return n != 0;
    } catch (SQLException e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
}


   public int generarNumeroTurno() {
    String serie = "";
    sSQL = "SELECT MAX(numero_turno) FROM inicio_turno";
    try (PreparedStatement pst = cn.prepareStatement(sSQL);
         ResultSet rs = pst.executeQuery()) {
        if (rs.next()) {
            serie = rs.getString(1);
            return (serie != null) ? Integer.parseInt(serie) + 1 : 1;
        } else {
            return 1;
        }
    } catch (SQLException | NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error al generar el número de turno: " + e.getMessage());
        return 0;
    }
}


    public boolean finalizarturno(Dinicioturnop dts) {
        sSQL = "update inicio_turno set estado='Finalizado'"
                + " where numero_turno=?";


        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getNumero_turno());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean hayTurnoActivo() {
        String sSQL = "SELECT COUNT(*) AS total FROM inicioturno WHERE estado = 'Activo'";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int total = rs.getInt("total");
                return total > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar el estado del turno: " + e.getMessage());
        }
        return false;
    }

    public boolean llenarcboempleado() {
        String sSQL = "select idempleado from empleado where idempleado = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int total = rs.getInt("empleado");
                return total > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se encontro empleado: " + e.getMessage());
        }
        return false;
    }
    
    public boolean asignardatos() {
        String sSQL = "select idinicio_turno from inicioturno where numero_turno = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int total = rs.getInt("empleado");
                return total > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se encontro empleado: " + e.getMessage());
        }
        return false;
    }
}
