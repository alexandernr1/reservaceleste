package Datos;

/**
 * @author Alexander nieves romero
 */
public class Dsalida {

    public int idsalida;
    public int idingreso;
    public int idcliente;
    public int idhabitacion;
    public int idabono;
    public String empleado;
    public int numero_turno;
    public int numero;
    public String cliente;
    public int numnoches;
    public String razon_social;
    public int documento;
    public String email;
    public int costoalojamiento;
    public String fechaingreso;
    public String fechasalida;
    public String tipocliente;
    public int valor_noches;
    public int abonos;
    public int valor_total;
    public int descuentos;
    public int cobros_extra;
    public int otros_cobros;
    public int deuda_anterior;
    public int total;
    public int antesIVA;
    public int IVA19;
    public int reten35;
    public int reten4;
    public int subtotal;
    public int efectivo;
    public int tarjeta;
    public int transferencias;
    public int totalpago;
    public int idinicioturno;
    public String turno;
    public int parqueadero;
    public int lavanderia;
    

    public Dsalida() {
    }

    public Dsalida(int idsalida, int idingreso, int idcliente, int idhabitacion, int idabono, String empleado, int numero_turno, int numero, String cliente, int numnoches, String razon_social, int documento, String email, int costoalojamiento, String fechaingreso, String fechasalida, String tipocliente, int valor_noches, int abonos, int valor_total, int descuentos, int cobros_extra, int otros_cobros, int deuda_anterior, int total, int antesIVA, int IVA19, int reten35, int reten4, int subtotal, int efectivo, int tarjeta, int transferencias, int totalpago, int idinicioturno, String turno, int parqueadero, int lavanderia) {
        this.idsalida = idsalida;
        this.idingreso = idingreso;
        this.idcliente = idcliente;
        this.idhabitacion = idhabitacion;
        this.idabono = idabono;
        this.empleado = empleado;
        this.numero_turno = numero_turno;
        this.numero = numero;
        this.cliente = cliente;
        this.numnoches = numnoches;
        this.razon_social = razon_social;
        this.documento = documento;
        this.email = email;
        this.costoalojamiento = costoalojamiento;
        this.fechaingreso = fechaingreso;
        this.fechasalida = fechasalida;
        this.tipocliente = tipocliente;
        this.valor_noches = valor_noches;
        this.abonos = abonos;
        this.valor_total = valor_total;
        this.descuentos = descuentos;
        this.cobros_extra = cobros_extra;
        this.otros_cobros = otros_cobros;
        this.deuda_anterior = deuda_anterior;
        this.total = total;
        this.antesIVA = antesIVA;
        this.IVA19 = IVA19;
        this.reten35 = reten35;
        this.reten4 = reten4;
        this.subtotal = subtotal;
        this.efectivo = efectivo;
        this.tarjeta = tarjeta;
        this.transferencias = transferencias;
        this.totalpago = totalpago;
        this.idinicioturno = idinicioturno;
        this.turno = turno;
        this.parqueadero = parqueadero;
        this.lavanderia = lavanderia;
    }

    public int getIdsalida() {
        return idsalida;
    }

    public void setIdsalida(int idsalida) {
        this.idsalida = idsalida;
    }

    public int getIdingreso() {
        return idingreso;
    }

    public void setIdingreso(int idingreso) {
        this.idingreso = idingreso;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public int getIdabono() {
        return idabono;
    }

    public void setIdabono(int idabono) {
        this.idabono = idabono;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getNumero_turno() {
        return numero_turno;
    }

    public void setNumero_turno(int numero_turno) {
        this.numero_turno = numero_turno;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumnoches() {
        return numnoches;
    }

    public void setNumnoches(int numnoches) {
        this.numnoches = numnoches;
    }

    public int getCostoalojamiento() {
        return costoalojamiento;
    }

    public void setCostoalojamiento(int costoalojamiento) {
        this.costoalojamiento = costoalojamiento;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(String tipocliente) {
        this.tipocliente = tipocliente;
    }

    public int getValor_noches() {
        return valor_noches;
    }

    public void setValor_noches(int valor_noches) {
        this.valor_noches = valor_noches;
    }

    public int getAbonos() {
        return abonos;
    }

    public void setAbonos(int abonos) {
        this.abonos = abonos;
    }

    public int getValor_total() {
        return valor_total;
    }

    public void setValor_total(int valor_total) {
        this.valor_total = valor_total;
    }

    public int getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(int descuentos) {
        this.descuentos = descuentos;
    }

    public int getCobros_extra() {
        return cobros_extra;
    }

    public void setCobros_extra(int cobros_extra) {
        this.cobros_extra = cobros_extra;
    }

    public int getOtros_cobros() {
        return otros_cobros;
    }

    public void setOtros_cobros(int otros_cobros) {
        this.otros_cobros = otros_cobros;
    }

    public int getDeuda_anterior() {
        return deuda_anterior;
    }

    public void setDeuda_anterior(int deuda_anterior) {
        this.deuda_anterior = deuda_anterior;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAntesIVA() {
        return antesIVA;
    }

    public void setAntesIVA(int antesIVA) {
        this.antesIVA = antesIVA;
    }

    public int getIVA19() {
        return IVA19;
    }

    public void setIVA19(int IVA19) {
        this.IVA19 = IVA19;
    }

    public int getReten35() {
        return reten35;
    }

    public void setReten35(int reten35) {
        this.reten35 = reten35;
    }

    public int getReten4() {
        return reten4;
    }

    public void setReten4(int reten4) {
        this.reten4 = reten4;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(int efectivo) {
        this.efectivo = efectivo;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(int transferencias) {
        this.transferencias = transferencias;
    }

    public int getTotalpago() {
        return totalpago;
    }

    public void setTotalpago(int totalpago) {
        this.totalpago = totalpago;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdinicioturno() {
        return idinicioturno;
    }

    public void setIdinicioturno(int idinicioturno) {
        this.idinicioturno = idinicioturno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(int parqueadero) {
        this.parqueadero = parqueadero;
    }

    public int getLavanderia() {
        return lavanderia;
    }

    public void setLavanderia(int lavanderia) {
        this.lavanderia = lavanderia;
    }

}
