package br.mil.ccarj.cursos.api.domain.service;


import br.mil.ccarj.cursos.api.domain.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CursosService {

    Curso createCurso (Curso curso);

    Curso findCursoId (Long idCurso);

    Page<Curso> findAllCurso (Pageable pageable);

    void updateCurso (Curso data);

    void deleteCurso (Long idCurso);

}
