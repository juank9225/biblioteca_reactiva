package co.com.softka.biblioteca.Biblioteca.Reactive.usecase.interfaceUseCase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import reactor.core.publisher.Mono;

public interface GuardarAreaTematica {
    public Mono<AreaTematicaDTO> apply(AreaTematicaDTO areaTematicaDTO);
}
