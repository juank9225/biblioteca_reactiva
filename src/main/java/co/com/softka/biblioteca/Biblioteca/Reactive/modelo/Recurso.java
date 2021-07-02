package co.com.softka.biblioteca.Biblioteca.Reactive.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Recurso {

    @Id
    private String id;
    private String nombre;
    private String tipoRecurso;
    private String fecha;
    private boolean disponible;
    private String areaTematicaId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getAreaTematicaId() {
        return areaTematicaId;
    }

    public void setAreaTematicaId(String areaTematicaId) {
        this.areaTematicaId = areaTematicaId;
    }
}