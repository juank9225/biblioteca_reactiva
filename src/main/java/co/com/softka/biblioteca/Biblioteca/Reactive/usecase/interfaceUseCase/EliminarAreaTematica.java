package co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface EliminarAreaTematica {
    public Mono<Void> deleteFindById(String id);
}
