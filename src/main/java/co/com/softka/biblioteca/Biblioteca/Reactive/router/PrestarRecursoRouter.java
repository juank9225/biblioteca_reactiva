package co.com.softka.biblioteca.Biblioteca.Reactive.router;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RespuestaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.UseCaseConsultarDisponibilidad;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.UseCasePrestarRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PrestarRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> prestarRecurso(UseCasePrestarRecurso useCasePrestarRecurso){
        return route(GET("/biblioteca/recurso/prestar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->ServerResponse.ok()
                        .body(useCasePrestarRecurso.apply(request.pathVariable("id")), RespuestaDTO.class));
    }
}
