package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RespuestaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RespuestaMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class UseCaseConsultarDisponibilidad implements Function<String, Mono<RespuestaDTO>> {
    private final RepositoryRecurso repositoryRecurso;
    private final RespuestaMapper respuestaMapper;

    public UseCaseConsultarDisponibilidad(RepositoryRecurso repositoryRecurso, RespuestaMapper respuestaMapper) {
        this.repositoryRecurso = repositoryRecurso;
        this.respuestaMapper = respuestaMapper;
    }

    @Override
    public Mono<RespuestaDTO> apply(String id) {
        return repositoryRecurso.findById(id).map(respuestaMapper.mapperToRecursoDisponibilidad());
    }
}
