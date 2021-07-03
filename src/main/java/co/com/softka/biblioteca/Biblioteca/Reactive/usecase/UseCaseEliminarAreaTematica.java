package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.AreaTematicaMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryAreaTematica;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase.EliminarAreaTematica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseEliminarAreaTematica implements EliminarAreaTematica {
    private final RepositoryAreaTematica repositoryAreaTematica;
    private final AreaTematicaMapper areaTematicaMapper;

    @Autowired
    public UseCaseEliminarAreaTematica(RepositoryAreaTematica repositoryAreaTematica, AreaTematicaMapper areaTematicaMapper) {
        this.repositoryAreaTematica = repositoryAreaTematica;
        this.areaTematicaMapper = areaTematicaMapper;
    }

    @Override
    public Mono<Void> deleteFindById(String id) {
        return repositoryAreaTematica.deleteById(id);
    }
}
