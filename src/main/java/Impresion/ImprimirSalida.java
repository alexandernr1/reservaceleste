package Impresion;

import Datos.Dsalida;
import Logica.Cconexion;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class ImprimirSalida {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    PrinterMatrix printer = new PrinterMatrix();

    public boolean ImprimirFacturaPago() throws FileNotFoundException, IOException {
        sSQL = "SELECT * FROM salida ORDER BY idsalida DESC LIMIT 1";

        try ( Statement statement = cn.createStatement();  ResultSet resultSet = statement.executeQuery(sSQL)) {

            while (resultSet.next()) {
                Dsalida dts = new Dsalida();
                dts.setEmpleado(resultSet.getString("empleado"));
                dts.setNumero_turno(resultSet.getInt("numero_turno"));
                dts.setNumero(resultSet.getInt("numero"));
                dts.setCliente(resultSet.getString("cliente"));
                dts.setNumnoches(resultSet.getInt("numnoches"));
                dts.setRazon_social(resultSet.getString("razon_social"));
                dts.setDocumento(resultSet.getInt("documento"));
                dts.setCostoalojamiento(resultSet.getInt("costoalojamiento"));
                dts.setEmail(resultSet.getString("email"));
                dts.setFechaingreso(resultSet.getString("fechaingreso"));
                dts.setFechasalida(resultSet.getString("fechasalida"));
//                dts.setTipocliente(resultSet.getString("tipocliente"));
                dts.setValor_noches(resultSet.getInt("valor_noches"));
                dts.setAbonos(resultSet.getInt("abonos"));
                dts.setDescuentos(resultSet.getInt("descuentos"));
                dts.setOtros_cobros(resultSet.getInt("otros_cobros"));
                dts.setDeuda_anterior(resultSet.getInt("deuda_anterior"));
                dts.setTotal(resultSet.getInt("total"));
                dts.setAntesIVA(resultSet.getInt("antesIVA"));
                dts.setIVA19(resultSet.getInt("IVA19"));
                dts.setReten35(resultSet.getInt("reten35"));
                dts.setReten4(resultSet.getInt("reten4"));
                dts.setSubtotal(resultSet.getInt("subtotal"));
                dts.setEfectivo(resultSet.getInt("efectivo"));
                dts.setTarjeta(resultSet.getInt("tarjeta"));
                dts.setTransferencias(resultSet.getInt("transferencias"));
                dts.setTotalpago(resultSet.getInt("totalpago"));

                // Imprimir los datos
                Extenso extenso = new Extenso();
                extenso.setNumber(101.85);
                printer.setOutSize(31, 32);
                printer.printTextWrap(1, 2, 10, 32, "HOTEL COMBUGAS S.A.S ");
                printer.printTextWrap(2, 3, 12, 80, "NIT: 900139412-4 ");
                printer.printTextWrap(3, 3, 14, 80, "TEL:3205417916");
                printer.printTextWrap(4, 3, 15, 80, "CARTAGENA");
                printer.printTextWrap(5, 3, 8, 80, "DG 31D N.32A-25B.TERNERA");

                printer.printTextWrap(6, 3, 4, 80, "-----------------------------------");
                printer.printTextWrap(7, 3, 4, 80, "Fecha Ingreso: " + dts.getFechaingreso());
                printer.printTextWrap(8, 3, 4, 80, "Fecha Salida: " + dts.getFechasalida());
                printer.printTextWrap(9, 3, 4, 80, "Turno: " + dts.getNumero_turno());
                printer.printTextWrap(10, 3, 4, 80, "Numero Habitacion: " + dts.getNumero());
                printer.printTextWrap(11, 3, 4, 80, "Numero Noches: " + dts.getNumnoches());
                printer.printTextWrap(12, 3, 4, 80, "Costo Alojamiento: $" + dts.getCostoalojamiento());

                printer.printTextWrap(13, 3, 4, 80, "-----------------------------------");
                printer.printTextWrap(14, 3, 4, 80, "Cliente: " + dts.getCliente());
                printer.printTextWrap(15, 3, 4, 80, "Razon Social: " + dts.getRazon_social());
                printer.printTextWrap(16, 3, 4, 80, "NIT/C.C: " + dts.getDocumento());
                printer.printTextWrap(17, 3, 4, 80, "Correo: " + dts.getEmail());
                printer.printTextWrap(18, 3, 4, 80, "-----------------------------------");

                // Mostrar solo las formas de pago que tienen valor
                int currentLine = 19; // Posición de impresión dinámica

                printer.printTextWrap(currentLine++, 3, 4, 80, "Concepto: Hospedaje");

                if (dts.getEfectivo() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Efectivo: $" + dts.getEfectivo());
                }
                if (dts.getTarjeta() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Tarjeta: $" + dts.getTarjeta());
                }
                if (dts.getTransferencias() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Transferencias: $" + dts.getTransferencias());
                }
                if (dts.getDescuentos() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Descuentos: $" + dts.getDescuentos());
                }
                if (dts.getOtros_cobros() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Otros Cobros: $" + dts.getOtros_cobros());
                }
                if (dts.getDeuda_anterior() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Deuda Anterior: $" + dts.getDeuda_anterior());
                }

                printer.printTextWrap(currentLine++, 3, 4, 80, "Subtotal: $" + dts.getSubtotal());
                printer.printTextWrap(currentLine++, 3, 4, 80, "Antes de IVA: $" + dts.getAntesIVA());
                printer.printTextWrap(currentLine++, 3, 4, 80, "IVA 19%: $" + dts.getIVA19());

                if (dts.getReten35() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Retención 3.5%: $" + dts.getReten35());
                }
                if (dts.getReten4() > 0) {
                    printer.printTextWrap(currentLine++, 3, 4, 80, "Retención 4%: $" + dts.getReten4());
                }

                // Impresión del total y pagos
                printer.printTextWrap(currentLine++, 3, 4, 80, "Total: $" + dts.getTotal());
                printer.printTextWrap(currentLine++, 3, 4, 80, "Total a Pagar: $" + dts.getTotalpago());

                // Finalización del ticket
                printer.printTextWrap(currentLine++, 3, 4, 80, "-----------------------------------");
                printer.printTextWrap(currentLine++, 3, 4, 80, "Empleado: " + dts.getEmpleado());
                printer.printTextWrap(currentLine++, 3, 4, 80, "-----------------------------------");

            }

            printer.toFile("impresion.txt");

            try ( FileOutputStream fos = new FileOutputStream("impresion.txt", true)) {
                byte[] cutCommand = new byte[]{0x1D, 0x56, 0x41}; // Comando ESC/POS para cortar el papel
                fos.write(cutCommand);
                fos.write(cutCommand);//PRUEBA CORTE DE IMPRESIÓN
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream("impresion.txt");

            } catch (FileNotFoundException f) {
                f.printStackTrace();
            }

            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc documeDoc = new SimpleDoc(inputStream, docFormat, null);

            PrintRequestAttributeSet attribute = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            if (defaultPrintService != null) {
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try {
                    printJob.print(documeDoc, attribute);
                } catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }
            } else {
                System.out.println("No hay una impresora conectada");
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
            return false;
        }
    }

}
