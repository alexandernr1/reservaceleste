

package Datos;


public class Dfactura_electronica {
    
    private int idfactura_electronica;
    private int documento;
    private int dv;
    private String razon_social;
    private String tipo_persona;
    private String tipo_documento;
    private String departamento;
    private String municipio;
    private String direccion;
    private String telefono;
    private String email;
    private String regimen_fiscal;
    private String responsabilidades_fiscales;
    private int idcliente;
    

    public Dfactura_electronica() {
    }

    public Dfactura_electronica(int idfactura_electronica, int documento, int dv, String razon_social, String tipo_persona, String tipo_documento, String departamento, String municipio, String direccion, String telefono, String email, String regimen_fiscal, String responsabilidades_fiscales,int idcliente) {
        this.idfactura_electronica = idfactura_electronica;
        this.documento = documento;
        this.dv = dv;
        this.razon_social = razon_social;
        this.tipo_persona = tipo_persona;
        this.tipo_documento = tipo_documento;
        this.departamento = departamento;
        this.municipio = municipio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.regimen_fiscal = regimen_fiscal;
        this.responsabilidades_fiscales = responsabilidades_fiscales;
        this.idcliente = idcliente;
    }

    public Dfactura_electronica(int idCliente, int documento, String razon_social, String email) {
        this.documento = documento;
        this.idcliente = idCliente;
        this.razon_social = razon_social;
        this.email = email;
        
    }

    public int getIdfactura_electronica() {
        return idfactura_electronica;
    }

    public void setIdfactura_electronica(int idfactura_electronica) {
        this.idfactura_electronica = idfactura_electronica;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
    

    public int getDv() {
        return dv;
    }

    public void setDv(int dv) {
        this.dv = dv;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getRegimen_fiscal() {
        return regimen_fiscal;
    }

    public void setRegimen_fiscal(String regimen_fiscal) {
        this.regimen_fiscal = regimen_fiscal;
    }

    public String getResponsabilidades_fiscales() {
        return responsabilidades_fiscales;
    }

    public void setResponsabilidades_fiscales(String responsabilidades_fiscales) {
        this.responsabilidades_fiscales = responsabilidades_fiscales;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    
    
}
