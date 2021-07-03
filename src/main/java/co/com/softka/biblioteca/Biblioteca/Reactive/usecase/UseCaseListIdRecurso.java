package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RecursoMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase.ConsultarfindByIdRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseListIdRecurso implements ConsultarfindByIdRecurso {
    private final RepositoryRecurso repositoryRecurso;
    private final RecursoMapper recursoMapper;

    @Autowired
    public UseCaseListIdRecurso(RepositoryRecurso repositoryRecurso, RecursoMapper recursoMapper) {
        this.repositoryRecurso = repositoryRecurso;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Mono<RecursoDTO> findById(String id) {
        return repositoryRecurso.findById(id).map(recursoMapper.mapRecursoToDTO());
    }
}
