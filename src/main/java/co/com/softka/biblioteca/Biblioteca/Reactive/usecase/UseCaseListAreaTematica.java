package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.AreaTematicaMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryAreaTematica;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
public class UseCaseListAreaTematica implements Supplier<Flux<AreaTematicaDTO>> {
    private final RepositoryAreaTematica repositoryAreaTematica;
    private final AreaTematicaMapper areaTematicaMapper;

    public UseCaseListAreaTematica(RepositoryAreaTematica repositoryAreaTematica, AreaTematicaMapper areaTematicaMapper) {
        this.repositoryAreaTematica = repositoryAreaTematica;
        this.areaTematicaMapper = areaTematicaMapper;
    }

    @Override
    public Flux<AreaTematicaDTO> get() {
        return repositoryAreaTematica.findAll().map(areaTematicaMapper.mapAreaTematicaToDTO());
    }
}
