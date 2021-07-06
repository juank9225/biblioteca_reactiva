package co.com.softka.biblioteca.Biblioteca.Reactive.dto;

import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;

import java.util.List;
import java.util.Objects;

public class ListarRecursosPorAreasDTO {
    private String area;
    private List<Recurso> recursos;

    public ListarRecursosPorAreasDTO() {

    }

    public ListarRecursosPorAreasDTO(String area, List<Recurso> recursos) {
        this.area = area;
        this.recursos = recursos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListarRecursosPorAreasDTO that = (ListarRecursosPorAreasDTO) o;
        return Objects.equals(area, that.area) && Objects.equals(recursos, that.recursos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, recursos);
    }
}
