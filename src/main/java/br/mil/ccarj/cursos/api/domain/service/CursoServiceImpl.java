package br.mil.ccarj.cursos.api.service;

import br.mil.ccarj.cursos.api.exception.NotFoundException;
import br.mil.ccarj.cursos.api.model.Curso;
import br.mil.ccarj.cursos.api.repository.CursoRepository;
import br.mil.ccarj.cursos.api.util.MessageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CursoServiceImpl implements CursosService {

    private final MessageUtil messageUtil;

    private final CursoRepository repository;


    public CursoServiceImpl(MessageUtil messageUtil, CursoRepository repository) {
        this.messageUtil = messageUtil;
        this.repository = repository;
    }

    @Override
    public Curso createCurso(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public Curso findCursoId(Long idCurso) {
        return repository.findById(idCurso)
                .orElseThrow(() -> new NotFoundException("Curso não encontrado"));

    }

    @Override
    public Page<Curso> findAllCurso(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void updateCurso(Curso data) {
        Curso response = findCursoId(data.getIdCurso());
        repository.save(data);
    }

    @Override
    public void deleteCurso(Long idCurso) {
        Curso found = repository.findById(idCurso)
                .orElseThrow(() -> new NotFoundException("Curso não Encontrado"));
        repository.delete(found);
    }


}
