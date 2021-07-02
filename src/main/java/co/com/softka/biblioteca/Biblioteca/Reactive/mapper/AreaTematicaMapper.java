package co.com.softka.biblioteca.Biblioteca.Reactive.mapper;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.AreaTematica;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AreaTematicaMapper {

    public Function<AreaTematicaDTO, AreaTematica> mapperToAreaTematica(String id){
        return updateAreaTematica ->{
            var areaTematica = new AreaTematica();
            areaTematica.setId(id);
            areaTematica.setNombre(updateAreaTematica.getNombre());

            return areaTematica;
        };
    }

    public Function<AreaTematica, AreaTematicaDTO> mapAreaTematicaToDTO(){
        return entity ->new AreaTematicaDTO(entity.getId()
                                            ,entity.getNombre());
    }
}
