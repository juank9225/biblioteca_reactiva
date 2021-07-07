package co.com.softka.biblioteca.Biblioteca.Reactive.router;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RecursoMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.usecase.UseCaseListRecurso;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConsultarRecursoRouter.class, UseCaseListRecurso.class, RecursoMapper.class})
class ConsultarRecursoRouterTest {

    @MockBean
    private RepositoryRecurso repositoryRecurso;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetRecursos() {
        Recurso recurso1 = new Recurso();
        recurso1.setId("111111");
        recurso1.setTipoRecurso("libro");
        recurso1.setDisponible(true);
        recurso1.setFecha("07/07/2021");
        recurso1.setAreaTematicaId("00001");
        Recurso recurso2 = new Recurso();
        recurso2.setId("222222");
        recurso2.setTipoRecurso("libro");
        recurso2.setDisponible(true);
        recurso2.setFecha("07/07/2021");
        recurso2.setAreaTematicaId("00001");

        when(repositoryRecurso.findAll()).thenReturn(Flux.just(recurso1, recurso2));

        webTestClient.get()
                .uri("/biblioteca/recurso/consultar")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(RecursoDTO.class)
                .value(userResponse -> {
                            Assertions.assertThat(userResponse.get(0).getAreaTematicaId()).isEqualTo(recurso1.getAreaTematicaId());
                            Assertions.assertThat(userResponse.get(1).getAreaTematicaId()).isEqualTo(recurso2.getAreaTematicaId());
                        }
                );
    }

}