package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.modelo.Recurso;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;

@SpringBootTest
class UseCaseCrearRecursoTest {


    @SpyBean
    private UseCaseCrearRecurso useCaseCrearRecurso;

    @MockBean
    private RepositoryRecurso repositoryRecurso;

    @DisplayName("test crear recurso")
    @Test
    public void crearRecursoUseCaseTest() {

        RecursoDTO recursoDTO = new RecursoDTO("cuento de terror","libro","11/07/2021",true,"22222");
        Recurso recurso = new Recurso();
        recurso.setNombre("cuento de terror");
        recurso.setTipoRecurso("libro");
        recurso.setFecha("11/07/2021");
        recurso.setDisponible(true);
        recurso.setAreaTematicaId("22222");

        when(repositoryRecurso.save(Mockito.any(Recurso.class))).thenReturn(Mono.just(recurso));

        var respuesta = useCaseCrearRecurso.apply(recursoDTO);

        Assertions.assertEquals(respuesta.block().getNombre(),"cuento de terror");
        Assertions.assertEquals(respuesta.block().getDisponible(),true);

    }

}