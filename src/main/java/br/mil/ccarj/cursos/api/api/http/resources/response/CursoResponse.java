package br.mil.ccarj.cursos.api.api.controller.http.resources.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoResponse {

    @ApiModelProperty(value = "ID Do Curso")
    private Long idCurso;

    @ApiModelProperty(value = "Nome do Curso")
    private String nomeCurso;

    @ApiModelProperty(value = "Sigla Curso")
    private String siglaCurso;

    @ApiModelProperty(value = "Organização")
    private String cdOrg;

    @ApiModelProperty(value = "Tema abordado")
    private String temaAbordado;

    @ApiModelProperty(value = "Carga Horaria Minima")
    private Long cargaHorariaMinima;

    @ApiModelProperty(value = "Ambiente Atuação")
    private String ambienteAtuacao;



}
