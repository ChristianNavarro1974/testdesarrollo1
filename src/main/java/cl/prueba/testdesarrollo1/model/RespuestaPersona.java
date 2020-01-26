package cl.prueba.testdesarrollo1.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static java.time.temporal.ChronoUnit.DAYS;

public class RespuestaPersona {
    private String nombre;
    private String apellido;
    private int edad;
    private int diasProximo;
    private String poema;
    private String titulo;
    private String saludoCumpleannos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDiasProximo() {
        return diasProximo;
    }

    public void setDiasProximo(int diasProximo) {
        this.diasProximo = diasProximo;
    }

    public String getPoema() {
        return poema;
    }

    public void setPoema(String poema) {
        this.poema = poema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSaludoCumpleannos() {
        return saludoCumpleannos;
    }

    public void setSaludoCumpleannos(String saludoCumpleannos) {
        this.saludoCumpleannos = saludoCumpleannos;
    }

    public void cargarPersona(Persona persona){
        this.nombre = persona.getNombre1();
        this.apellido = persona.getApellido1();
        Calendar nac = new GregorianCalendar();
        nac.setTime(persona.getFechaNacimiento());
        LocalDate nacimiento = LocalDate.of(nac.get(Calendar.YEAR), nac.get(Calendar.MONTH) + 1, nac.get(Calendar.DATE));
        LocalDate hoy = LocalDate.now();
        Period tiempoVida = Period.between(nacimiento, hoy);
        this.edad = tiempoVida.getYears();
        LocalDate proximoCumple = nacimiento.plusYears(tiempoVida.getYears() + 1);
        if ((tiempoVida.getDays() == 0) && (tiempoVida.getMonths() == 0)){
            JsonNode root;
            RestTemplate restTemplate = new RestTemplate();
            String respuesta = restTemplate.getForObject("https://www.poemist.com/api/v1/randompoems", String.class);
            ObjectMapper mapper = new ObjectMapper();
            try {
                root = mapper.readTree(respuesta);
                Random r = new Random();
                final int asInt = r.ints(0, (root.size())).findFirst().getAsInt();
                JsonNode saludo = root.get(asInt);
                this.titulo = saludo.get("title").textValue();
                this.poema = saludo.get("content").textValue();
                this.saludoCumpleannos = "Un muy feliz cumpleaños " + this.nombre;
                this.diasProximo = (int) DAYS.between(hoy, proximoCumple);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            this.diasProximo = (int) DAYS.between(hoy, proximoCumple);
        }
    }
}
