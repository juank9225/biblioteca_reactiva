package co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import reactor.core.publisher.Mono;

public interface GuardarRecurso {
    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO);
}
