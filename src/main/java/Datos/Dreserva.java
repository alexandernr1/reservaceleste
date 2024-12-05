package Datos;

import java.sql.Date;

public class Dreserva {

    public int idreserva;
    public int idhabitacion;
    public String fechareserva;
    public String fechaingreso;
    public Date fechasalida;
    public String estado;
    public int numnoches;
    public int numpersonas;
    public String cliente;
    public int documento;
    public String telefono;
    public int numhabitacion;
    public int costoalojamiento;
    public String tipohabitacion;
    public String empleado;
    public int idinicioturno;
    public int num_turno;
    public String turno;
    public int idcliente;
    

    public Dreserva() {
    }

    public Dreserva(int idreserva, int idhabitacion, String fechareserva, String fechaingreso, Date fechasalida, String estado, int numnoches, int numpersonas, String cliente, int documento, String telefono, int numhabitacion, int costoalojamiento, String tipohabitacion, String empleado, int idinicioturno, int num_turno, String turno, int idcliente) {
        this.idreserva = idreserva;
        this.idhabitacion = idhabitacion;
        this.fechareserva = fechareserva;
        this.fechaingreso = fechaingreso;
        this.fechasalida = fechasalida;
        this.estado = estado;
        this.numnoches = numnoches;
        this.numpersonas = numpersonas;
        this.cliente = cliente;
        this.documento = documento;
        this.telefono = telefono;
        this.numhabitacion = numhabitacion;
        this.costoalojamiento = costoalojamiento;
        this.tipohabitacion = tipohabitacion;
        this.empleado = empleado;
        this.idinicioturno = idinicioturno;
        this.num_turno = num_turno;
        this.turno = turno;
        this.idcliente = idcliente;
    }

    

   

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public String getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(String fechareserva) {
        this.fechareserva = fechareserva;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumnoches() {
        return numnoches;
    }

    public void setNumnoches(int numnoches) {
        this.numnoches = numnoches;
    }

    public int getNumpersonas() {
        return numpersonas;
    }

    public void setNumpersonas(int numpersonas) {
        this.numpersonas = numpersonas;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumhabitacion() {
        return numhabitacion;
    }

    public void setNumhabitacion(int numhabitacion) {
        this.numhabitacion = numhabitacion;
    }

    public int getCostoalojamiento() {
        return costoalojamiento;
    }

    public void setCostoalojamiento(int costoalojamiento) {
        this.costoalojamiento = costoalojamiento;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getIdinicioturno() {
        return idinicioturno;
    }

    public void setIdinicioturno(int idinicioturno) {
        this.idinicioturno = idinicioturno;
    }

    public int getNum_turno() {
        return num_turno;
    }

    public void setNum_turno(int num_turno) {
        this.num_turno = num_turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    

}