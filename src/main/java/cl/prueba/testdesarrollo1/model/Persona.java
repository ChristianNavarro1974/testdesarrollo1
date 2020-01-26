package cl.prueba.testdesarrollo1.model;

import org.springframework.stereotype.Service;

import java.util.Date;

public class Persona {
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void cargarNombre(String nombre) throws ArrayIndexOutOfBoundsException{
        String[] s = nombre.split(" ");
        if (s.length < 4){
            throw new ArrayIndexOutOfBoundsException("El nombre debe tener al menos 4 palabras");
        }
        this.nombre1 = s[0];
        this.nombre2 = s[1];
        this.apellido1 = s[2];
        this.apellido2 = s[3];
    }
}
