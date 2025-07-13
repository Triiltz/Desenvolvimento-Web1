package br.ufscar.dc.dsw.controller.api;

import br.ufscar.dc.dsw.domain.Aluno;
import br.ufscar.dc.dsw.service.spec.IAlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoRestController {

    @Autowired
    private IAlunoService alunoService;

    /**
     * [READ] Retorna a lista de todos os alunos
     * URL: GET http://localhost:8080/api/alunos
     */
    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos() {
        List<Aluno> alunos = alunoService.buscarTodos();
        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 No Content se a lista estiver vazia
        }
        return ResponseEntity.ok(alunos);
    }

    /**
     * [READ] Retorna o aluno correspondente ao ID
     * URL: GET http://localhost:8080/api/alunos/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return (aluno != null) ? ResponseEntity.ok(aluno) : ResponseEntity.notFound().build();
    }

    /**
     * [CREATE] Cria um novo aluno
     * URL: POST http://localhost:8080/api/alunos
     */
    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@Valid @RequestBody Aluno aluno) {
        alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    /**
     * [UPDATE] Atualiza os dados de um aluno
     * URL: PUT http://localhost:8080/api/alunos/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @Valid @RequestBody Aluno aluno) {
        Aluno alunoExistente = alunoService.buscarPorId(id);
        if (alunoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        aluno.setId(id); // Garante que o aluno atualizado tenha o ID correto
        alunoService.salvar(aluno);
        return ResponseEntity.ok(aluno);
    }

    /**
     * [DELETE] Remove um aluno pelo ID
     * URL: DELETE http://localhost:8080/api/alunos/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAluno(@PathVariable Long id) {
        if (alunoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        if (alunoService.alunoTemPlanos(id)) {
            // Retorna 422 Unprocessable Entity (ou 409 Conflict) para indicar que não pode ser removido
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        alunoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}