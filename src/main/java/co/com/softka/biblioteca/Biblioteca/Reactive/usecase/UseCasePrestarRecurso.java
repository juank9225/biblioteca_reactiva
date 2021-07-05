package co.com.softka.biblioteca.Biblioteca.Reactive.usecase;

import co.com.softka.biblioteca.Biblioteca.Reactive.dto.RecursoDTO;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RespuestaMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.mapper.RecursoMapper;
import co.com.softka.biblioteca.Biblioteca.Reactive.repositorio.RepositoryRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.function.Function;

@Service
@Validated
public class UseCasePrestarRecurso implements Function<String, Mono<RecursoDTO>> {
    private final RepositoryRecurso repositoryRecurso;
    private final RespuestaMapper respuestaMapper;
    private final RecursoMapper recursoMapper;

@Autowired
    public UseCasePrestarRecurso(RepositoryRecurso repositoryRecurso, RespuestaMapper respuestaMapper, RecursoMapper recursoMapper) {
        this.repositoryRecurso = repositoryRecurso;
        this.respuestaMapper = respuestaMapper;
        this.recursoMapper = recursoMapper;
}

    @Override
    public Mono<RecursoDTO> apply(String id) {

      var res= repositoryRecurso.findById(id)
              .flatMap(recurso -> {
                  LocalDate fecha = LocalDate.now();
                  if(recurso.getDisponible()){
                      recurso.setDisponible(true);
                      recurso.setFecha(fecha.toString());
                      return repositoryRecurso.save(recurso);
                  }
                     recurso.getDisponible();
                     recurso.getFecha();
                     return  repositoryRecurso.save(recurso);

              });

      return null;
}

}
