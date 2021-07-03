package co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ActualizarAreaTematica {
    public Mono<AreaTematicaDTO> apply(AreaTematicaDTO areaTematicaDTO);
}
