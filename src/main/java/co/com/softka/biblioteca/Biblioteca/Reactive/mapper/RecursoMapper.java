package co.com.softka.biblioteca.Biblioteca.Reactive.mapper;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RecursoMapper {

    public Function<RecursoDTO, Recurso> mapperToRecurso(String id) {
        return updateRecurso -> {
            var recurso = new Recurso();
            recurso.setId(id);
            recurso.setNombre(updateRecurso.getNombre());
            recurso.setTipoRecurso(updateRecurso.getTipoRecurso());
            recurso.setDisponible(updateRecurso.getDisponible());
            recurso.setFecha(updateRecurso.getFecha());
            recurso.setAreaTematicaId(updateRecurso.getAreaTematicaId());

            return recurso;
        };
    }

    public Function<Recurso, RecursoDTO> mapRecursoToDTO() {
        return entity -> new RecursoDTO(entity.getId()
                                     ,entity.getNombre()
                                     ,entity.getTipoRecurso()
                                     ,entity.getFecha()
                                     ,entity.getDisponible()
                                     ,entity.getAreaTematicaId());
    }

}
