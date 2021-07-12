package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UseCaseListRecursoTest {

    @SpyBean
    private UseCaseListRecurso useCaseListRecurso;

    @MockBean
    private RepositoryRecurso repositoryRecurso;

    @Test
    public void useCaseListRecursoTest(){

        Recurso recurso1 = new Recurso();
        recurso1.setId("1111");
        recurso1.setNombre("cuento de terror");
        recurso1.setTipoRecurso("libro");
        recurso1.setFecha("11/07/2021");
        recurso1.setDisponible(true);
        recurso1.setAreaTematicaId("22222");

        Recurso recurso2 = new Recurso();
        recurso2.setId("3333");
        recurso2.setNombre("cuento de tibetanos");
        recurso2.setTipoRecurso("libro");
        recurso2.setFecha("11/07/2021");
        recurso2.setDisponible(true);
        recurso2.setAreaTematicaId("22222");

        when(repositoryRecurso.findAll()).thenReturn(Flux.just(recurso1,recurso2));

        var respuesta = useCaseListRecurso.get();

        Assertions.assertEquals(respuesta.blockFirst().getDisponible(),true);
        Assertions.assertEquals(respuesta.blockFirst().getTipoRecurso(),"libro");
        Assertions.assertEquals(respuesta.blockLast().getNombre(),"cuento de tibetanos");
    }
}