package co.com.softka.biblioteca.Biblioteca.Reactive.router;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.UseCaseActualizarAreaTematica;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ActualizarAreaTematicaRouter {

    @Bean
    public RouterFunction<ServerResponse> actualizarAreaTematica(UseCaseActualizarAreaTematica useCaseActualizarAreaTematica){
        return route(PUT("/biblioteca/area/actualizar").and(accept(MediaType.APPLICATION_JSON)),
                request->request.bodyToMono(AreaTematicaDTO.class)
                .flatMap(areaTematicaDTO -> useCaseActualizarAreaTematica.apply(areaTematicaDTO)
                        .flatMap(result->ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result)))
        );
    }
}
