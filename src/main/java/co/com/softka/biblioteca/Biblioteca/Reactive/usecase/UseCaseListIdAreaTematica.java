package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.AreaTematicaMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryAreaTematica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class UseCaseListIdAreaTematica implements Function<String, Mono<AreaTematicaDTO>> {
    private final RepositoryAreaTematica repositoryAreaTematica;
    private final AreaTematicaMapper areaTematicaMapper;

    @Autowired
    public UseCaseListIdAreaTematica(RepositoryAreaTematica repositoryAreaTematica, AreaTematicaMapper areaTematicaMapper) {
        this.repositoryAreaTematica = repositoryAreaTematica;
        this.areaTematicaMapper = areaTematicaMapper;
    }

    @Override
    public Mono<AreaTematicaDTO> apply(String id) {
        return repositoryAreaTematica.findById(id).map(areaTematicaMapper.mapAreaTematicaToDTO());
    }
}
