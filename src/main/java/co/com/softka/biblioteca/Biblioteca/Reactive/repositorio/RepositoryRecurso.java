package co.com.softka.biblioteca.Biblioteca.Reactive.repositorio;

import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

public interface RepositoryRecurso extends ReactiveMongoRepository<Recurso,String> {
    @Transactional(readOnly = true)
    Flux<Recurso> findBytipoRecurso(String tipo);
}
