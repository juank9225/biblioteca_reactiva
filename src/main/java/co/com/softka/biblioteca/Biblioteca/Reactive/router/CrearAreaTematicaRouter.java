package co.com.softka.biblioteca.Biblioteca.Reactive.router;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.UseCaseCrearAreaTematica;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrearAreaTematicaRouter {

    @Bean
    public RouterFunction<ServerResponse> createAreaTematica(UseCaseCrearAreaTematica useCaseCrearAreaTematica){
        return route(POST("/biblioteca/area/crear").and(accept(MediaType.APPLICATION_JSON)),
                request ->request.bodyToMono(AreaTematicaDTO.class)
                            .flatMap(areaTematicaDTO -> useCaseCrearAreaTematica.apply(areaTematicaDTO)
                            .flatMap(result -> ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(result))
                            )
        );
    }
}
