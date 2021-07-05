package co.com.softka.biblioteca.Biblioteca.Reactive.router;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RespuestaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.UseCaseConsultarDisponibilidad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DisponibilidadRecursoRouter {
    @Bean
    public RouterFunction<ServerResponse> prestarRecurso(UseCaseConsultarDisponibilidad useCaseConsultarDisponibilidad){
        return route(GET("/biblioteca/recurso/disponibilidad/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->ServerResponse.ok()
                        .body(useCaseConsultarDisponibilidad.apply(request.pathVariable("id")), RespuestaDTO.class));
    }
}
