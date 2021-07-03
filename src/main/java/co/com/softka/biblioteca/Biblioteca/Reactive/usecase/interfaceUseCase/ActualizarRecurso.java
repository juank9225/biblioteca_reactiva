package co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ActualizarRecurso {
    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO);
}
