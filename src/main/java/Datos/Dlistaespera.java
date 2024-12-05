
package Datos;

import java.sql.Date;




public class Dlistaespera {
 public  int idespera;
public int idempleado;
public String empleado;
public Date fecha;
public int cantidadpersonas;
public String tipohabitacion;
public Date hora_llegada;
public String cliente;
public String estado;
public int numero;

    public Dlistaespera(int idespera, int idempleado, String empleado, Date fecha, int cantidadpersonas, String tipohabitacion, Date hora_llegada, String cliente, String estado, int numero) {
        this.idespera = idespera;
        this.idempleado = idempleado;
        this.empleado = empleado;
        this.fecha = fecha;
        this.cantidadpersonas = cantidadpersonas;
        this.tipohabitacion = tipohabitacion;
        this.hora_llegada = hora_llegada;
        this.cliente = cliente;
        this.estado = estado;
        this.numero = numero;
    }

    public Dlistaespera() {
    }

    public int getIdespera() {
        return idespera;
    }

    public void setIdespera(int idespera) {
        this.idespera = idespera;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidadpersonas() {
        return cantidadpersonas;
    }

    public void setCantidadpersonas(int cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public Date getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(Date hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
