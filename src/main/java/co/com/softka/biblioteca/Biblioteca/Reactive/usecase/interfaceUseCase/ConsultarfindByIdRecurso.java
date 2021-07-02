package co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import reactor.core.publisher.Mono;

public interface ConsultarfindByIdRecurso {
   public Mono<RecursoDTO> findById(String id);
}
