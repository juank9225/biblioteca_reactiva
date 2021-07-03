package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RecursoMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase.ActualizarRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseActualizarRecursoRecurso implements ActualizarRecurso {
    private final RepositoryRecurso repositoryRecurso;
    private final RecursoMapper recursoMapper;

    @Autowired
    public UseCaseActualizarRecursoRecurso(RepositoryRecurso repositoryRecurso, RecursoMapper recursoMapper) {
        this.repositoryRecurso = repositoryRecurso;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO) {
        return repositoryRecurso.save(recursoMapper.mapperToRecurso(recursoDTO.getId()).apply(recursoDTO))
                .map(recursoMapper.mapRecursoToDTO());
    }
}
