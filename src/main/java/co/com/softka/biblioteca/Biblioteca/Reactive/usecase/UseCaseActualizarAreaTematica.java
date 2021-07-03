package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.AreaTematicaMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryAreaTematica;

import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase.ActualizarAreaTematica;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseActualizarAreaTematica implements ActualizarAreaTematica {
    private final RepositoryAreaTematica repositoryAreaTematica;
    private final AreaTematicaMapper areaTematicaMapper;

    public UseCaseActualizarAreaTematica(RepositoryAreaTematica repositoryAreaTematica, AreaTematicaMapper areaTematicaMapper) {
        this.repositoryAreaTematica = repositoryAreaTematica;
        this.areaTematicaMapper = areaTematicaMapper;
    }

    @Override
    public Mono<AreaTematicaDTO> apply(AreaTematicaDTO areaTematicaDTO) {
        return repositoryAreaTematica.save(areaTematicaMapper.mapperToAreaTematica(areaTematicaDTO.getId()).apply(areaTematicaDTO))
                .map(areaTematicaMapper.mapAreaTematicaToDTO());
    }
}
