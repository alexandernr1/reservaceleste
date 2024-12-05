package Impresion;

import Datos.Dabono;
import Logica.Cconexion;
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

public class ImpresionAbono {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    PrinterMatrix printer = new PrinterMatrix();

    public boolean ImprimirFacturaAbono() throws FileNotFoundException, IOException, SQLException {
        sSQL = "SELECT * FROM abono ORDER BY idabono DESC LIMIT 1"; // Asegúrate de que 'abono' sea el nombre correcto de la tabla

        try ( Statement statement = cn.createStatement();  ResultSet resultSet = statement.executeQuery(sSQL)) {

            while (resultSet.next()) {
                Dabono dts = new Dabono();
                dts.setIdabono(resultSet.getInt("idabono"));
                dts.setIdingreso(resultSet.getInt("idingreso"));
                dts.setIdhabitacion(resultSet.getInt("idhabitacion"));
                dts.setIdcliente(resultSet.getInt("idcliente"));
                dts.setFechaabono(resultSet.getString("fechaabono"));
                dts.setAbonohabitacion(resultSet.getInt("abonohabitacion"));
                dts.setDescuentos(resultSet.getString("descuentos"));
                dts.setConceptodescuento(resultSet.getString("conceptodescuento"));
                dts.setTotalAbonos(resultSet.getInt("totalAbonos"));
                dts.setPrivilegiosAdmon(resultSet.getString("privilegiosAdmon"));
                dts.setPrivilegiosrecepcion(resultSet.getString("privilegiosrecepcion"));
                dts.setOtroscobros(resultSet.getInt("otroscobros"));
                dts.setNumero_turno(resultSet.getInt("numero_turno"));
                dts.setHabitacion(resultSet.getInt("habitacion"));
                dts.setCliente(resultSet.getString("cliente"));
                dts.setDocumento(resultSet.getString("documento"));
                dts.setRazon_social(resultSet.getString("razon_social"));
                dts.setEmail(resultSet.getString("email"));
                dts.setNumeronoches(resultSet.getInt("numeronoches"));
                dts.setValordescuento(resultSet.getInt("valordescuento"));
                dts.setTipocomprobante(resultSet.getString("tipocomprobante"));
                dts.setNumerocomprobante(resultSet.getString("numerocomprobante"));
                dts.setValor_bruto(resultSet.getInt("valor_bruto"));
                dts.setAntesIVA(resultSet.getInt("antesIVA"));
                dts.setIva19(resultSet.getInt("iva19"));
                dts.setRetencion35(resultSet.getInt("retencion35"));
                dts.setRetencion4(resultSet.getInt("retencion4"));
                dts.setSubtotal(resultSet.getInt("subtotal"));
                dts.setEfectivo(resultSet.getInt("efectivo"));
                dts.setTarjeta(resultSet.getInt("tarjeta"));
                dts.setTransferencia(resultSet.getInt("transferencia"));
                dts.setTotalapagar(resultSet.getInt("totalapagar"));
                dts.setParqueadero(resultSet.getInt("parqueadero"));
                dts.setLavanderia(resultSet.getInt("lavanderia"));

                // Imprimir los datos
                printer.setOutSize(33, 32);
                printer.printTextWrap(1, 2, 10, 32, "HOTEL COMBUGAS S.A.S ");
                printer.printTextWrap(2, 3, 12, 80, "NIT: 900139412-4 ");
                printer.printTextWrap(3, 3, 14, 80, "TEL:3205417916");
                printer.printTextWrap(4, 3, 15, 80, "CARTAGENA");
                printer.printTextWrap(5, 3, 8, 80, "DG 31D N.32A-25B.TERNERA");

                printer.printTextWrap(6, 3, 4, 80, "-----------------------------------");
                printer.printTextWrap(7, 3, 4, 80, "Fecha Abono: " + dts.getFechaabono());
                printer.printTextWrap(8, 3, 4, 80, "Tipo Comprobante: " + dts.getTipocomprobante());
                printer.printTextWrap(9, 3, 4, 80, "Numero Comprobante: " + dts.getNumerocomprobante());
                printer.printTextWrap(10, 3, 4, 80, "Numero Habitacion: " + dts.getHabitacion());
                printer.printTextWrap(11, 3, 4, 80, "Numero Noches:" + dts.getNumeronoches());

                printer.printTextWrap(12, 3, 4, 80, "-----------------------------------");
                printer.printTextWrap(13, 3, 4, 80, "Razon Social: " + dts.getRazon_social());
                printer.printTextWrap(14, 3, 4, 80, "NIT/C.C: " + dts.getDocumento());
                printer.printTextWrap(15, 3, 4, 80, "Correo: " + dts.getEmail());
                printer.printTextWrap(16, 3, 4, 80, "-----------------------------------");
                printer.printTextWrap(17, 3, 4, 80, "Concepto: Hospedaje");
                // Mostrar solo las formas de pago que tienen valor
                if (dts.getEfectivo() > 0) {
                    printer.printTextWrap(18, 3, 4, 80, "Efectivo: " + dts.getEfectivo());
                }
                if (dts.getTarjeta() > 0) {
                    printer.printTextWrap(19, 3, 4, 80, "Tarjeta: " + dts.getTarjeta());
                }
                if (dts.getTransferencia() > 0) {
                    printer.printTextWrap(20, 3, 4, 80, "Transferencia: " + dts.getTransferencia());
                }
                if (dts.getDescuentos() != null && !dts.getDescuentos().isEmpty()) {
                    printer.printTextWrap(21, 3, 4, 80, "Descuentos: " + dts.getDescuentos());
                }
                if (dts.getOtroscobros() > 0) {
                    printer.printTextWrap(22, 3, 4, 80, "Otros Cobros: " + dts.getOtroscobros());
                }
                printer.printTextWrap(23, 3, 4, 80, "Parqueadero:" + dts.getParqueadero());
                printer.printTextWrap(24, 3, 4, 80, "Lavanderia:" + dts.getLavanderia());
                printer.printTextWrap(25, 3, 4, 80, "Valor antes de iva: " + dts.getAntesIVA());
                printer.printTextWrap(26, 3, 4, 80, "IVA 19%: " + dts.getIva19());

                if (dts.getRetencion35() > 0) {
                    printer.printTextWrap(27, 3, 4, 80, "Retencion 3.5%: " + dts.getRetencion35());
                }
                if (dts.getRetencion4() > 0) {
                    printer.printTextWrap(28, 3, 4, 80, "Retencion 4%: " + dts.getRetencion4());
                }

                printer.printTextWrap(29, 3, 4, 80, "Total a Pagar: " + dts.getTotalapagar());

                printer.printTextWrap(30, 3, 4, 80, "-----------------------------------");
//                printer.printTextWrap(29, 3, 4, 80, "Empleado: " ;
                printer.printTextWrap(31, 3, 4, 80, "Turno: " + dts.getNumero_turno());
                printer.printTextWrap(32, 3, 4, 80, "-----------------------------------");

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
