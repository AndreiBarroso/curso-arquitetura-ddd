package br.mil.ccarj.cursos.api.service;


import br.mil.ccarj.cursos.api.domain.model.Curso;
import br.mil.ccarj.cursos.api.domain.repository.CursoRepository;
import br.mil.ccarj.cursos.api.domain.service.CursoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CursoServiceImplTest {

    @Mock
    private CursoRepository repository;

    @InjectMocks
    private CursoServiceImpl service;

    @Test
    public void testSave () {
       Curso curso = new Curso();
       service.createCurso(curso);
       verify(repository, times(1)).save(curso);
    }


    @Test
    public void testFindById() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new Curso()));
        Curso resultado = service.findCursoId(1L);
    }

    @Test
    public void testDeleteCurso() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new Curso()));
        service.deleteCurso(1L);
    }


}
