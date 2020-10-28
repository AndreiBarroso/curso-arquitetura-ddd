package br.mil.ccarj.cursos.api.api.controller;

import br.mil.ccarj.cursos.api.api.http.resources.request.CursoRequest;
import br.mil.ccarj.cursos.api.api.http.resources.response.CursoResponse;
import br.mil.ccarj.cursos.api.domain.model.Curso;
import br.mil.ccarj.cursos.api.domain.service.CursosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController extends BaseController {

    private CursosService service;

    private ModelMapper modelMapper;

    public CursoController(CursosService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @ApiOperation(value = "Find existing cursos", nickname = "findAllCurso", notes = "Multiple search parasm can be provided", response = Curso.class, responseContainer = "List", tags = {"cursos",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request")})

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findAllCursos(Pageable pageable) {
        Page<Curso> cursoPage = service.findAllCurso(pageable);
        List<CursoResponse> content = cursoPage.stream()
                .map(item -> modelMapper.map(item, CursoResponse.class))
                .collect(Collectors.toList());
        PageImpl<CursoResponse> cursoResponses = new PageImpl<>(content, pageable, cursoPage.getTotalElements());
        return respondOk(cursoResponses);
    }

    @ApiOperation(value = "Add a new cursos", nickname = "addCurso", notes = "", tags = {"cursos",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")})

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createCurso(@RequestBody @Valid CursoRequest cursoRequest) {
        Curso request = modelMapper.map(cursoRequest, Curso.class);
        Curso created = service.createCurso(request);
        CursoResponse response = modelMapper.map(created, CursoResponse.class);
        return respondCreated(response);
    }

    @ApiOperation(value = "Find curso by ID", nickname = "getCursoById", notes = "Returns a single curso", response = CursoResponse.class, tags = {"cursos",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CursoResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "curso not found")})

    @GetMapping(value = "/{idCurso}")
    @ResponseBody
    public ResponseEntity<?> findCursoId(@PathVariable(name = "idCurso") Long idCurso) {
        final Curso cursoId = service.findCursoId(idCurso);
        CursoResponse response = modelMapper.map(cursoId, CursoResponse.class);
        return respondOk(response);

    }

    @ApiOperation(value = "Atualizar curso existente ", nickname = "updateCurso", notes = "", response = CursoResponse.class, tags = {"cursos",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CursoResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "curso not found")})

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCurso(@RequestBody CursoRequest request) {
       Curso data = modelMapper.map(request, Curso.class);
       service.updateCurso(data);
    }

    @ApiOperation(value = "Deletar curso existente ", nickname = "deleteCurso", notes = "", response = CursoResponse.class, tags = {"cursos",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = CursoResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "curso not found")})

    @DeleteMapping(value = "/{idCurso}")
    @ResponseBody
    public void deleteCurso (@PathVariable(name = "idCurso") Long idCurso) {
        service.deleteCurso(idCurso);
    }

}
