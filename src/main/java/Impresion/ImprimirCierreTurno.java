package Impresion;

import Datos.Dsalidaturno;
import Logica.Cconexion;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class ImprimirCierreTurno {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    PrinterMatrix printer = new PrinterMatrix();

    public boolean ImprimirCierreTurno() {
        sSQL = "SELECT * FROM salidaturno ORDER BY idsalidaturno DESC LIMIT 1";

        try ( Statement statement = cn.createStatement();  ResultSet resultSet = statement.executeQuery(sSQL)) {

            String imagePath = "C:\\Users\\Usuario\\Desktop\\reservascombugas\\reservascombugas\\src\\main\\java\\Impresion\\IconoEmpresa.png";
            addImageToPrintFile(imagePath);

            while (resultSet.next()) {
                Dsalidaturno turno = new Dsalidaturno();

                turno.setEmpleado(resultSet.getString("empleado"));
                turno.setTurno(resultSet.getString("turno"));
                turno.setFecha_hora_inicio(resultSet.getString("fecha_hora_inicio"));
                turno.setFecha_hora_salida(resultSet.getString("fecha_hora_salida"));
                turno.setHabitaciones_ocupadas(resultSet.getInt("habitaciones_ocupadas"));
                turno.setTotal_recibos(resultSet.getInt("total_recibos"));
                turno.setBase(resultSet.getInt("base"));
                turno.setTarjetas(resultSet.getInt("tarjetas"));
                turno.setEfectivo(resultSet.getInt("efectivo"));
                turno.setTransferencias(resultSet.getInt("transferencias"));
                turno.setTotalhabitaciones(resultSet.getInt("totalhabitaciones"));
                turno.setTotal_abonos(resultSet.getInt("total_abonos"));
                turno.setOtros_ingresos(resultSet.getInt("otros_ingresos"));
                turno.setTotal_recaudo(resultSet.getInt("total_recaudo"));
                turno.setEntrega_admon(resultSet.getInt("entrega_admon"));
                turno.setTotal_efectivo(resultSet.getInt("total_efectivo"));
                turno.setObservaciones(resultSet.getString("observaciones"));
                turno.setNumero_turno(resultSet.getInt("numero_turno"));

                // Imprimir los datos
                Extenso extenso = new Extenso();
                extenso.setNumber(101.85);
                printer.setOutSize(32, 32);

                printer.printTextWrap(1, 2, 10, 80, "HOTEL COMBUGAS S.A.S ");
                printer.printTextWrap(2, 3, 12, 80, "NIT: 900139412-4 ");
                printer.printTextWrap(3, 3, 14, 80, "TEL:3205417916");
                printer.printTextWrap(4, 3, 15, 80, "CARTAGENA");
                printer.printTextWrap(5, 3, 8, 80, "DG 31D N.32A-25B.TERNERA");
                printer.printTextWrap(6, 3, 4, 80, "-----------------------------------");

                printer.printTextWrap(7, 3, 4, 80, "Fecha Hora Inicio: " + turno.getFecha_hora_inicio());
                printer.printTextWrap(8, 3, 4, 80, "Fecha Hora Salida: " + turno.getFecha_hora_salida());

                printer.printTextWrap(11, 3, 4, 80, "-----------------------------------");
                printer.printTextWrap(12, 3, 4, 80, "Total Recaudo: " + turno.getTotal_recaudo());
                printer.printTextWrap(13, 3, 4, 80, "-----------------------------------");
                printer.printTextWrap(14, 2, 10, 80, "Detalle del recaudado");
                 printer.printTextWrap(15, 3, 4, 80, "-----------------------------------");

                printer.printTextWrap(17, 3, 4, 80, "Tarjetas: " + turno.getTarjetas());               
                printer.printTextWrap(18, 3, 4, 80, "Efectivo: " + turno.getEfectivo());               
                printer.printTextWrap(19, 3, 4, 80, "Transferencias: " + turno.getTransferencias());              
                printer.printTextWrap(21, 3, 4, 80, "Total Abonos: " + turno.getTotal_abonos());
                
                printer.printTextWrap(22, 3, 4, 80, "Otros Ingresos: " + turno.getOtros_ingresos());
                printer.printTextWrap(23, 3, 4, 80, "Total cambio habitaciones: " + turno.getTotal_efectivo());
                printer.printTextWrap(24, 3, 4, 80, "Efectivo Liquido: " + turno.getEntrega_admon());
               
                printer.printTextWrap(25, 3, 4, 80, "Observaciones: " + turno.getObservaciones());
                printer.printTextWrap(26, 3, 4, 80, "-----------------------------------");

                printer.printTextWrap(27, 3, 4, 80, "Empleado: " + turno.getEmpleado());
                printer.printTextWrap(28, 3, 4, 80, "Turno: " + turno.getTurno());
                printer.printTextWrap(29, 3, 4, 80, "Numero Turno: " + turno.getNumero_turno());

                printer.printTextWrap(30, 3, 4, 80, "-----------------------------------");
            }

//            printer.toImageFile("IconoEmpresa.png");
            printer.toFile("impresion.txt");

            try ( FileOutputStream fos = new FileOutputStream("impresion.txt", true)) {
                byte[] cutCommand = new byte[]{0x1D, 0x56, 0x41}; // Comando ESC/POS para cortar el papel
                fos.write(cutCommand);
                fos.write(cutCommand);
            } catch (IOException e) {
                 e.printStackTrace();
            }

            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream("impresion.txt");

            } catch (FileNotFoundException f) {
            }

            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc documeDoc = new SimpleDoc(inputStream, docFormat, null);

            PrintRequestAttributeSet attribute = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            if (defaultPrintService != null) {
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try {
                    printJob.print(documeDoc, attribute);
                } catch (PrintException e) {
                    System.out.println("ERROR: " + e);
                }
            } else {
                System.out.println("No hay una impresora conectada");
            }

            return true;
        } catch (SQLException e) { // Manejo de errores
            // Manejo de errores
            return false;
        }
    }
    // Método para convertir una imagen a un byte array

    private byte[] convertImageToByteArray(String imagePath) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "IconoEmpresa.png", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    // Método para añadir la imagen al archivo de impresión
    private void addImageToPrintFile(String imagePath) {
        try {
            byte[] imageBytes = convertImageToByteArray(imagePath);
            try ( FileOutputStream fos = new FileOutputStream("impresion.txt", true)) {
                fos.write(imageBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
