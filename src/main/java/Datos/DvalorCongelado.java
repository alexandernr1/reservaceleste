package Datos;

public class DvalorCongelado {

    public int idabonocongelado;
    public int idabono;
    public int idcliente;
    public int habitacion;
    public String cliente;
    public int documento;
    public String fechaabono;
    public String fechacongelado;
    public int abonohabitacion;
    public int descuentos;
    public int numeronoches;
    public int nochesusadas;
    public int valorcongelado;
    public String estado;

    public DvalorCongelado() {
    }

    public DvalorCongelado(int idabonocongelado, int idabono, int idcliente, int habitacion, String cliente, int documento, String fechaabono, String fechacongelado, int abonohabitacion, int descuentos, int numeronoches, int nochesusadas, int valorcongelado, String estado) {
        this.idabonocongelado = idabonocongelado;
        this.idabono = idabono;
        this.idcliente = idcliente;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.documento = documento;
        this.fechaabono = fechaabono;
        this.fechacongelado = fechacongelado;
        this.abonohabitacion = abonohabitacion;
        this.descuentos = descuentos;
        this.numeronoches = numeronoches;
        this.nochesusadas = nochesusadas;
        this.valorcongelado = valorcongelado;
        this.estado = estado;
    }

    // Constructor para saldoCongelado y totalNoches
    public DvalorCongelado(int saldoCongelado, int totalNoches, int NochesUsadas) {
        this.valorcongelado = saldoCongelado;
        this.numeronoches = totalNoches;
        this.nochesusadas = NochesUsadas;
    }

    // Getters
    public int getSaldoCongelado() {
        return valorcongelado;
    }

    public int getTotalNoches() {
        return numeronoches;
    }

    public int getNochesUsadas() {
        return nochesusadas;
    }

    public int getIdabonocongelado() {
        return idabonocongelado;
    }

    public void setIdabonocongelado(int idabonocongelado) {
        this.idabonocongelado = idabonocongelado;
    }

    public int getIdabono() {
        return idabono;
    }

    public void setIdabono(int idabono) {
        this.idabono = idabono;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
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

    public String getFechaabono() {
        return fechaabono;
    }

    public void setFechaabono(String fechaabono) {
        this.fechaabono = fechaabono;
    }

    public String getFechacongelado() {
        return fechacongelado;
    }

    public void setFechacongelado(String fechacongelado) {
        this.fechacongelado = fechacongelado;
    }

    public int getAbonohabitacion() {
        return abonohabitacion;
    }

    public void setAbonohabitacion(int abonohabitacion) {
        this.abonohabitacion = abonohabitacion;
    }

    public int getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(int descuentos) {
        this.descuentos = descuentos;
    }

    public int getNumeronoches() {
        return numeronoches;
    }

    public void setNumeronoches(int numeronoches) {
        this.numeronoches = numeronoches;
    }

    public int getNochesusadas() {
        return nochesusadas;
    }

    public void setNochesusadas(int nochesusadas) {
        this.nochesusadas = nochesusadas;
    }

    public int getValorcongelado() {
        return valorcongelado;
    }

    public void setValorcongelado(int valorcongelado) {
        this.valorcongelado = valorcongelado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
