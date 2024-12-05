
package Datos;


public class Dvehiculo {
    
    private int idvehiculo;
    private String placa;
    private String modelo;
    private String tipovehiculo;

    public Dvehiculo() {
    }

    public Dvehiculo(int idvehiculo, String placa, String modelo, String tipovehiculo) {
        this.idvehiculo = idvehiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.tipovehiculo = tipovehiculo;
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(String tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }
    
    
}
