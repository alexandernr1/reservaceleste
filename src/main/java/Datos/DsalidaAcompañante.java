
package Datos;


public class DsalidaAcompañante {
    public int idsalidaacompañante;
    public int idacompañante;
    public int idcliente;
    public String nombre_apellido;
    public String tipo_documento;
    public int documento;
    public String parentesco;
    public int num_habitacion;
    public String checkin;
    public String checkoup;
    public int num_huesped_principal;
    public String ciudad_de_residencia;
    public String ciudad_de_procedencia;

    public DsalidaAcompañante() {
    }

    public DsalidaAcompañante(int idsalidaacompañante, int idacompañante, int idcliente, String nombre_apellido, String tipo_documento, int documento, String parentesco, int num_habitacion, String checkin, String checkoup, int num_huesped_principal, String ciudad_de_residencia, String ciudad_de_procedencia) {
        this.idsalidaacompañante = idsalidaacompañante;
        this.idacompañante = idacompañante;
        this.idcliente = idcliente;
        this.nombre_apellido = nombre_apellido;
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.parentesco = parentesco;
        this.num_habitacion = num_habitacion;
        this.checkin = checkin;
        this.checkoup = checkoup;
        this.num_huesped_principal = num_huesped_principal;
        this.ciudad_de_residencia = ciudad_de_residencia;
        this.ciudad_de_procedencia = ciudad_de_procedencia;
    }

    public int getIdsalidaacompañante() {
        return idsalidaacompañante;
    }

    public void setIdsalidaacompañante(int idsalidaacompañante) {
        this.idsalidaacompañante = idsalidaacompañante;
    }

    public int getIdacompañante() {
        return idacompañante;
    }

    public void setIdacompañante(int idacompañante) {
        this.idacompañante = idacompañante;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public int getNum_habitacion() {
        return num_habitacion;
    }

    public void setNum_habitacion(int num_habitacion) {
        this.num_habitacion = num_habitacion;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckoup() {
        return checkoup;
    }

    public void setCheckoup(String checkoup) {
        this.checkoup = checkoup;
    }

    public int getNum_huesped_principal() {
        return num_huesped_principal;
    }

    public void setNum_huesped_principal(int num_huesped_principal) {
        this.num_huesped_principal = num_huesped_principal;
    }

    public String getCiudad_de_residencia() {
        return ciudad_de_residencia;
    }

    public void setCiudad_de_residencia(String ciudad_de_residencia) {
        this.ciudad_de_residencia = ciudad_de_residencia;
    }

    public String getCiudad_de_procedencia() {
        return ciudad_de_procedencia;
    }

    public void setCiudad_de_procedencia(String ciudad_de_procedencia) {
        this.ciudad_de_procedencia = ciudad_de_procedencia;
    }
    
    
}
