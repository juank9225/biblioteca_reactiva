package co.com.softka.biblioteca.Biblioteca.Reactive.mapper;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.dto.ListarRecursosPorAreasDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.AreaTematica;
import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

@Component
public class ListaRecursoArea {

    public Function<List<Recurso>,ListarRecursosPorAreasDTO> mapperToRecursoAreaTematica(String area){
        return listaRecurso ->{
            var listRecuarsoArea = new ListarRecursosPorAreasDTO();
            listRecuarsoArea.setArea(area);
            listRecuarsoArea.setRecursos(listaRecurso);

            return listRecuarsoArea;
        };
    }

   /* public Function<AreaTematica,ListarRecursosPorAreasDTO> mapperToAreaTematicaRecurso(){
        return listaRecurso ->{
            var listRecuarsoArea = new ListarRecursosPorAreasDTO();
                listRecuarsoArea.setArea(listaRecurso.getNombre());

            return listRecuarsoArea;
        };
    }*/
}
