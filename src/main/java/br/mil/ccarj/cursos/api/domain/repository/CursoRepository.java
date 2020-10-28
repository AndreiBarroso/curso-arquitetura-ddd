package br.mil.ccarj.cursos.api.domain.repository;


import br.mil.ccarj.cursos.api.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
