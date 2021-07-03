package co.com.softka.biblioteca.Biblioteca.Reactive.router;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.AreaTematicaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.UseCaseListIdAreaTematica;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarAreaTematicaIdRouter {

    @Bean
    public RouterFunction<ServerResponse> consultarAreaTematicaId(UseCaseListIdAreaTematica useCaseListIdAreaTematica){
        return route(GET("/biblioteca/area/consultar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request->ServerResponse.ok()
                        .body(useCaseListIdAreaTematica.apply(request.pathVariable("id")), AreaTematicaDTO.class));
    }
}
