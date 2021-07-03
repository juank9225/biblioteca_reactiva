package co.com.softka.biblioteca.Biblioteca.Reactive.router;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.UseCaseEliminarRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EliminarRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> eliminarRecursoId(UseCaseEliminarRecurso useCaseEliminarRecurso){
        return route(DELETE("/biblioteca/recurso/eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
               request->ServerResponse.ok()
                       .body(useCaseEliminarRecurso.deleteFindById(request.pathVariable("id")), RecursoDTO.class) );
    }
}
