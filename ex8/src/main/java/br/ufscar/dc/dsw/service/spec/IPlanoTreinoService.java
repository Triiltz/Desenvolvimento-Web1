package br.ufscar.dc.dsw.service.spec;

import br.ufscar.dc.dsw.domain.PlanoTreino;
import java.util.List;

public interface IPlanoTreinoService {

    PlanoTreino buscarPorId(Long id);

    List<PlanoTreino> buscarTodos();

    void salvar(PlanoTreino planoTreino);

    void excluir(Long id);
}