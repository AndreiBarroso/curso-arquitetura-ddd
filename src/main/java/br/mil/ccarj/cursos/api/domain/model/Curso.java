package br.mil.ccarj.cursos.api.model;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "T_CURSO")
@Audited
@Data
@Builder
@EqualsAndHashCode(of = "idCurso")
@AllArgsConstructor
@NoArgsConstructor
public class Curso implements Serializable {


    @GenericGenerator(
            name = "SQ_ID_CURSO",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "SQ_ID_CURSO", value = "SQ_ID_CURSO"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "SQ_ID_CURSO")
    @Column(name = "ID_CURSO")
    private Long idCurso;

    @NotNull
    @Column(name = "NM_CURSO")
    private String nomeCurso;

    @NotNull
    @Column(name = "AMB_ATUACAO")
    private String ambienteAtuacao;

    @NotNull
    @Column(name = "HR_MINIMA")
    private Long cargaHorariaMinima;

    @NotNull
    @Column(name= "CD_ORG")
    private String cdOrg;

    @NotNull
    @Column(name = "TM_ABORDADO")
    private String temaAbordado;

    @NotNull
    @Column(name = "SG_CURSO")
    private String siglaCurso;


}
