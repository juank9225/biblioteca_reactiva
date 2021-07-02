package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RecursoMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
public class UseCaseListRecurso implements Supplier<Flux<RecursoDTO>> {
    private final RepositoryRecurso repositoryRecurso;
    private final RecursoMapper recursoMapper;

    public UseCaseListRecurso(RepositoryRecurso repositoryRecurso, RecursoMapper recursoMapper) {
        this.repositoryRecurso = repositoryRecurso;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Flux<RecursoDTO> get() {
        return repositoryRecurso.findAll().map(recursoMapper.mapRecursoToDTO());
    }
}
