package co.com.softka.biblioteca.Biblioteca.Reactive.repositorio;

import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

public interface RepositoryRecurso extends ReactiveMongoRepository<Recurso,String> {
    @Transactional(readOnly = true)
    Flux<Recurso> findBytipoRecurso(String tipo);

    @Transactional(readOnly = true)
    Flux<Recurso> findByareaTematicaId(String areaTematicaId);
}
