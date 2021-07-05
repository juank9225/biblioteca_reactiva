package co.com.softka.biblioteca.Biblioteca.Reactive.repositorio;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface RepositoryRecurso extends ReactiveMongoRepository<Recurso,String> {

}
