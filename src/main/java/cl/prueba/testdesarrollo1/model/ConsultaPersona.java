package cl.prueba.testdesarrollo1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsultaPersona {
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("fechaNacimiento")
    private String fechaNacimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
