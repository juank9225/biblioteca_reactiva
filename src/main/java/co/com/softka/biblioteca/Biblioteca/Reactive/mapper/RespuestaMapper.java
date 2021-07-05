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
            var recurso = new Recurso();
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

}
