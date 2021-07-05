package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RecursoMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;
@Service
public class UseCaseRecomendarTipoRecurso implements Function<String, Flux<RecursoDTO>> {
    private final RepositoryRecurso repositoryRecurso;
    private final RecursoMapper recursoMapper;

    @Autowired
    public UseCaseRecomendarTipoRecurso(RepositoryRecurso repositoryRecurso, RecursoMapper recursoMapper) {
        this.repositoryRecurso = repositoryRecurso;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Flux<RecursoDTO> apply(String tipoRecurso) {
        return repositoryRecurso.findBytipoRecurso(tipoRecurso).map(recursoMapper.mapRecursoToDTO());
    }
}
