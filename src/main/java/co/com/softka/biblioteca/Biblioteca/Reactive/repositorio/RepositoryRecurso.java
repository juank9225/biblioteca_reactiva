package co.com.softka.biblioteca.Biblioteca.Reactive.repositorio;

import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryRecurso extends ReactiveMongoRepository<Recurso,String> {

}
