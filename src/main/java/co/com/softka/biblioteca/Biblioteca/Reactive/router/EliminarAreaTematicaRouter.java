package co.com.softka.biblioteca.Biblioteca.Reactive.router;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.UseCaseEliminarAreaTematica;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EliminarAreaTematicaRouter {

    @Bean
    public RouterFunction<ServerResponse> eliminarAreaTematica(UseCaseEliminarAreaTematica useCaseEliminarAreaTematica) {
        return route(DELETE("/biblioteca/area/eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request->ServerResponse.ok()
                        .body(useCaseEliminarAreaTematica.deleteFindById(request.pathVariable("id")), AreaTematicaDTO.class) );
    }
}
