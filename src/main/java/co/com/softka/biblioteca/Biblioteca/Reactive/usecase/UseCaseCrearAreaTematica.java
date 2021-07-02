package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.AreaTematicaMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryAreaTematica;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase.GuardarAreaTematica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrearAreaTematica implements GuardarAreaTematica {

    private final RepositoryAreaTematica repositoryAreaTematica;
    private final AreaTematicaMapper areaTematicaMapper = new AreaTematicaMapper();

    @Autowired
    public UseCaseCrearAreaTematica(RepositoryAreaTematica repositoryAreaTematica) {
        this.repositoryAreaTematica = repositoryAreaTematica;
    }

    @Override
    public Mono<AreaTematicaDTO> apply(AreaTematicaDTO areaTematicaDTO) {
        var area = repositoryAreaTematica.save(areaTematicaMapper.mapperToAreaTematica(null).apply(areaTematicaDTO)).map(areaTematicaMapper.mapAreaTematicaToDTO());
        return area;
    }
}
