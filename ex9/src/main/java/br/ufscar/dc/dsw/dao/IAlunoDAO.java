package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Aluno;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

@SuppressWarnings("unchecked")
public interface IAlunoDAO extends CrudRepository<Aluno, Long> {

    
    Aluno findById(long id);

    List<Aluno> findAll();

    Aluno save(Aluno aluno);

    void deleteById(Long id);

    // Métodos de busca customizados (substituindo o JDBC manual)

    Aluno findByCpf(String cpf);

    List<Aluno> findByNomeContainingIgnoreCase(String nome);
}