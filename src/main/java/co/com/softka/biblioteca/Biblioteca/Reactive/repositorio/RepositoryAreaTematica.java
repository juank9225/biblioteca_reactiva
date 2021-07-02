package co.com.softka.biblioteca.Biblioteca.Reactive.repositorio;

import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.AreaTematica;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryAreaTematica extends ReactiveMongoRepository<AreaTematica,String> {

}
