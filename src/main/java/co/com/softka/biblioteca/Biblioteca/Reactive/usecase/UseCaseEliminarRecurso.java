package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RecursoMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase.EliminarRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseEliminarRecurso implements EliminarRecurso {
    private final RepositoryRecurso repositoryRecurso;
    private final RecursoMapper recursoMapper;

    @Autowired
    public UseCaseEliminarRecurso(RepositoryRecurso repositoryRecurso, RecursoMapper recursoMapper) {
        this.repositoryRecurso = repositoryRecurso;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Mono<Void> deleteFindById(String id) {
        return repositoryRecurso.deleteById(id);
    }
}
