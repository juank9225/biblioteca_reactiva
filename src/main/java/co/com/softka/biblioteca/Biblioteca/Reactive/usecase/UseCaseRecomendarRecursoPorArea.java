package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.ListarRecursosPorAreasDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.AreaTematicaMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.ListaRecursoArea;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RecursoMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryAreaTematica;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
public class UseCaseRecomendarRecursoPorArea implements Function<String, Flux<ListarRecursosPorAreasDTO>> {
    private final RepositoryRecurso repositoryRecurso;
    private final ListaRecursoArea listaRecursoArea;

    @Autowired
    public UseCaseRecomendarRecursoPorArea(RepositoryRecurso repositoryRecurso, ListaRecursoArea listaRecursoArea) {
        this.repositoryRecurso = repositoryRecurso;
        this.listaRecursoArea = listaRecursoArea;
    }

    @Override
    public Flux<ListarRecursosPorAreasDTO> apply(String areaId) {
//     var area = repositoryAreaTematica.findById(areaId).map(areaTematicaMapper.mapAreaTematicaToDTO());
       return repositoryRecurso.findByareaTematicaId(areaId).buffer().map(listaRecursoArea.mapperToRecursoAreaTematica(areaId));

    }
}
