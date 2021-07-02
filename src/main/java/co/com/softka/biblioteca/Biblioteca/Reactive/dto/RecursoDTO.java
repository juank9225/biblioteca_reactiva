package co.com.softka.biblioteca.Biblioteca.Reactive.dto;

import java.time.LocalDate;
import java.util.Objects;

public class RecursoDTO {
    private String id;
    private String nombre;
    private String tipoRecurso;
    private String fecha;
    private boolean disponible;
    private String areaTematicaId;

    public RecursoDTO() {

    }

    public RecursoDTO(String nombre, String tipoRecurso, String fecha, boolean disponible, String areaTematicaId) {
        this.nombre = nombre;
        this.tipoRecurso = tipoRecurso;
        this.fecha = fecha;
        this.disponible = disponible;
        this.areaTematicaId = areaTematicaId;
    }

    public RecursoDTO(String id,String nombre, String tipoRecurso, String fecha, boolean disponible, String areaTematicaId) {
        this.id = id;
        this.nombre = nombre;
        this.tipoRecurso = tipoRecurso;
        this.fecha = fecha;
        this.disponible = disponible;
        this.areaTematicaId = areaTematicaId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursoDTO that = (RecursoDTO) o;
        return disponible == that.disponible && Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(tipoRecurso, that.tipoRecurso) && Objects.equals(fecha, that.fecha) && Objects.equals(areaTematicaId, that.areaTematicaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tipoRecurso, fecha, disponible, areaTematicaId);
    }
}
