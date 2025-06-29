package br.ufscar.dc.dsw.service.spec;

import br.ufscar.dc.dsw.domain.Aluno;
import java.util.List;

public interface IAlunoService {
    
    Aluno buscarPorId(Long id);
    
    List<Aluno> buscarTodos();
    
    void salvar(Aluno aluno);
    
    void excluir(Long id);
    
    boolean alunoTemPlanos(Long id);
}