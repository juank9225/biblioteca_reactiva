package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RecursoMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase.GuardarRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrearRecurso implements GuardarRecurso {

    private final RepositoryRecurso repositoryRecurso;
    private final RecursoMapper recursoMapper;

    @Autowired
    public UseCaseCrearRecurso(RepositoryRecurso repositoryRecurso, RecursoMapper recursoMapper) {
        this.repositoryRecurso = repositoryRecurso;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO) {
       var recurso = repositoryRecurso.save(recursoMapper.mapperToRecurso(null).apply(recursoDTO)).map(recursoMapper.mapRecursoToDTO());
       return recurso;
    }
}
