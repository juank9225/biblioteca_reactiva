package co.com.softka.biblioteca.Biblioteca.Reactive.router;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RecursoMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.UseCaseCrearRecurso;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.mockito.ArgumentMatchers.any;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CrearRecursoRouter.class, UseCaseCrearRecurso.class, RecursoMapper.class})
class CrearRecursoRouterTest {

    @MockBean
    private RepositoryRecurso repositoryRecurso;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testCreateRecurso() {

        Recurso recurso = new Recurso();
        recurso.setId("111111");
        recurso.setNombre("las cronicas de narnia");
        recurso.setTipoRecurso("libro");
        recurso.setDisponible(true);
        recurso.setFecha("07/07/2021");
        recurso.setAreaTematicaId("00001");

        RecursoDTO recursoDTO = new RecursoDTO(recurso.getId(), recurso.getNombre(),recurso.getTipoRecurso(),recurso.getFecha(),recurso.getDisponible(),recurso.getAreaTematicaId());
        Mono<Recurso> datoMono = Mono.just(recurso);
        when(repositoryRecurso.save(any())).thenReturn(datoMono);

        webTestClient.post()
                .uri("/biblioteca/recurso/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(recursoDTO), RecursoDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(RecursoDTO.class)
                .value(userResponse -> {
                            Assertions.assertThat(userResponse.getId()).isEqualTo(recurso.getId());
                        }
                );
    }
}


