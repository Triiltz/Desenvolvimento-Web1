package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.PlanoTreino;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

@SuppressWarnings("unchecked")
public interface IPlanoTreinoDAO extends CrudRepository<PlanoTreino, Long> {
    

    PlanoTreino findById(long id);

    List<PlanoTreino> findAll();

    PlanoTreino save(PlanoTreino planoTreino);

    void deleteById(Long id);

    List<PlanoTreino> findByAlunoId(Long alunoId);
}