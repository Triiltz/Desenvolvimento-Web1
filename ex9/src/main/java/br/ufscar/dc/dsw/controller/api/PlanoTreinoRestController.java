package br.ufscar.dc.dsw.controller.api;

import br.ufscar.dc.dsw.domain.Aluno;
import br.ufscar.dc.dsw.domain.PlanoTreino;
import br.ufscar.dc.dsw.service.spec.IAlunoService;
import br.ufscar.dc.dsw.service.spec.IPlanoTreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planos")
public class PlanoTreinoRestController {

    @Autowired
    private IPlanoTreinoService planoTreinoService;

    @Autowired
    private IAlunoService alunoService;

    /**
     * [READ] Retorna a lista de todos os planos de treino
     * URL: GET http://localhost:8080/api/planos
     */
    @GetMapping
    public ResponseEntity<List<PlanoTreino>> listarTodos() {
        List<PlanoTreino> planos = planoTreinoService.buscarTodos();
        if (planos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(planos);
    }

    /**
     * [READ] Retorna o plano de treino correspondente ao ID
     * URL: GET http://localhost:8080/api/planos/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<PlanoTreino> buscarPorId(@PathVariable Long id) {
        PlanoTreino plano = planoTreinoService.buscarPorId(id);
        return (plano != null) ? ResponseEntity.ok(plano) : ResponseEntity.notFound().build();
    }

    /**
     * [READ] Retorna os planos de um aluno específico
     * URL: GET http://localhost:8080/api/alunos/{alunoId}/planos
     */
    @GetMapping("/alunos/{alunoId}")
    public ResponseEntity<List<PlanoTreino>> listarPlanosPorAluno(@PathVariable Long alunoId) {
        Aluno aluno = alunoService.buscarPorId(alunoId);
        if (aluno == null) {
            // Retorna 404 se o aluno não existe
            return ResponseEntity.notFound().build();
        }
        List<PlanoTreino> planos = aluno.getPlanosTreino();
        if (planos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(planos);
    }

    /**
     * [CREATE] Cria um novo plano de treino
     * URL: POST http://localhost:8080/api/planos
     */
    @PostMapping
    public ResponseEntity<?> criarPlano(@Valid @RequestBody PlanoTreino plano) {
        // Valida se o aluno associado existe
        if (plano.getAluno() == null || plano.getAluno().getId() == null ||
            alunoService.buscarPorId(plano.getAluno().getId()) == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("O aluno associado não existe.");
        }
        planoTreinoService.salvar(plano);
        return ResponseEntity.status(HttpStatus.CREATED).body(plano);
    }

    /**
     * [UPDATE] Atualiza os dados de um plano de treino.
     * URL: PUT http://localhost:8080/api/planos/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPlano(@PathVariable Long id, @Valid @RequestBody PlanoTreino plano) {
        if (planoTreinoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        // Valida se o aluno associado existe
        if (plano.getAluno() == null || plano.getAluno().getId() == null ||
            alunoService.buscarPorId(plano.getAluno().getId()) == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("O aluno associado não existe.");
        }
        plano.setId(id);
        planoTreinoService.salvar(plano);
        return ResponseEntity.ok(plano);
    }

    /**
     * [DELETE] Remove um plano de treino pelo ID.
     * URL: DELETE http://localhost:8080/api/planos/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPlano(@PathVariable Long id) {
        if (planoTreinoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        planoTreinoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}