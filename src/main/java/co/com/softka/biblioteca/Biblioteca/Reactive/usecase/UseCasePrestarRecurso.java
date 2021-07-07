package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RespuestaDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RespuestaMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class UseCasePrestarRecurso implements Function<String, Mono<RespuestaDTO>> {
    private final RepositoryRecurso repositoryRecurso;
    private final RespuestaMapper respuestaMapper;

@Autowired
    public UseCasePrestarRecurso(RepositoryRecurso repositoryRecurso, RespuestaMapper respuestaMapper) {
        this.repositoryRecurso = repositoryRecurso;
        this.respuestaMapper = respuestaMapper;
}

    @Override
    public Mono<RespuestaDTO> apply(String id) {
        return  repositoryRecurso.findById(id).map(respuestaMapper.mensajeRecursoPrestado());
    }

}
