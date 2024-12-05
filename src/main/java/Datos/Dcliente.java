package Datos;

public class Dcliente {

    public int idcliente;
    public String nombres;
    public String apellidos;
    public String tipodocumento;
    public String numdocumento;
    public String telefono;
    public String email;
    public String direccion;
    public String pais;
    public String ciudad;

    public Dcliente() {
    }

    public Dcliente(int idcliente, String nombres, String apellidos, String tipodocumento, String numdocumento, String telefono, String email, String direccion, String pais, String ciudad) {
        this.idcliente = idcliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipodocumento = tipodocumento;
        this.numdocumento = numdocumento;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(String numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

   

}
