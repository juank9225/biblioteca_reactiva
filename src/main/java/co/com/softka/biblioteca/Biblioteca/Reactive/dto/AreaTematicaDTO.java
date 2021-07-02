package co.com.softka.biblioteca.Biblioteca.Reactive.dto;

import java.util.Objects;

public class AreaTematicaDTO {
    private String id;
    private String nombre;

    public AreaTematicaDTO() {

    }

    public AreaTematicaDTO(String nombre) {
        this.nombre = nombre;
    }

    public AreaTematicaDTO(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaTematicaDTO that = (AreaTematicaDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
