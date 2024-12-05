package Datos;

import java.sql.Date;

public class Dlimpieza {

    public int idlimpieza;
    public int idempleado;
    public int numero;
    public String tipo_habitacion;
    public Date fecha;
    public String estado;
    public String turno;
    public int idhabitacion;

    public Dlimpieza() {
    }

    public Dlimpieza(int idlimpieza, int idempleado, int numero, String tipo_habitacion, Date fecha, String estado, String turno, int idhabitacion) {
        this.idlimpieza = idlimpieza;
        this.idempleado = idempleado;
        this.numero = numero;
        this.tipo_habitacion = tipo_habitacion;
        this.fecha = fecha;
        this.estado = estado;
        this.turno = turno;
        this.idhabitacion = idhabitacion;
    }

    public int getIdlimpieza() {
        return idlimpieza;
    }

    public void setIdlimpieza(int idlimpieza) {
        this.idlimpieza = idlimpieza;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(String tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

}
