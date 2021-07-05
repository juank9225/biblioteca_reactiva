package co.com.softka.biblioteca.Biblioteca.Reactive.dto;

import java.util.Objects;

public class RespuestaDTO {
    private String respuesta;
    private boolean disponible;
    private String fecha;

    public RespuestaDTO() {
    }

    public RespuestaDTO(String respuesta, boolean disponible, String fecha) {
        this.respuesta = respuesta;
        this.disponible = disponible;
        this.fecha = fecha;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaDTO that = (RespuestaDTO) o;
        return disponible == that.disponible && Objects.equals(respuesta, that.respuesta) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(respuesta, disponible, fecha);
    }
}
