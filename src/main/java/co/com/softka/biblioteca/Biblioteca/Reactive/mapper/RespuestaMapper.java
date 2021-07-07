package co.com.softka.biblioteca.Biblioteca.Reactive.mapper;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RespuestaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Function;

@Component
public class RespuestaMapper {

    public Function<Recurso, RespuestaDTO> mapperToRecursoDisponibilidad(){
        return updateRecurso-> {
            var respuesta = new RespuestaDTO();
            if (updateRecurso.getDisponible()){
                respuesta.setRespuesta("El recurso esta disponible");
                respuesta.setDisponible(updateRecurso.getDisponible());
                respuesta.setFecha(updateRecurso.getFecha());
                return respuesta;
            }else{
            respuesta.setRespuesta("El recurso no esta disponible");
            respuesta.setDisponible(updateRecurso.getDisponible());
            respuesta.setFecha(updateRecurso.getFecha());
             return respuesta;
            }
        };
    }

    public Function<RecursoDTO, Recurso> cambiarEstadoRecursoPrestamo(String id){
        return updateRecurso-> {
            LocalDate fecha = LocalDate.now();
            var recurso = new Recurso();
            if (updateRecurso.getDisponible()){
                recurso.setId(id);
                recurso.setDisponible(false);
                recurso.setFecha(fecha.toString());
                return recurso;
            }else{
                recurso.setDisponible(updateRecurso.getDisponible());
                recurso.setFecha(updateRecurso.getFecha());
                return recurso;
            }
        };
    }
    public Function<Recurso, RespuestaDTO> mensajeRecursoPrestado(){
        return updateRecurso-> {
            LocalDate fecha = LocalDate.now();
            var respuesta = new RespuestaDTO();
            if (updateRecurso.getDisponible()){
                respuesta.setRespuesta("El recurso fue prestado exitosamente");
                respuesta.setDisponible(false);
                respuesta.setFecha(fecha.toString());
                return respuesta;
            }else{
                respuesta.setRespuesta("El recurso no esta disponible para prestar");
                respuesta.setDisponible(updateRecurso.getDisponible());
                respuesta.setFecha(updateRecurso.getFecha());
                return respuesta;
            }
        };
    }

}
