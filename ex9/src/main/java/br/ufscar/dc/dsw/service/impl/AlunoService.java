package br.ufscar.dc.dsw.service.impl;

import br.ufscar.dc.dsw.dao.IAlunoDAO;
import br.ufscar.dc.dsw.domain.Aluno;
import br.ufscar.dc.dsw.service.spec.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = false)
public class AlunoService implements IAlunoService {

    @Autowired
    IAlunoDAO dao;

    @Override
    public void salvar(Aluno aluno) {
        dao.save(aluno);
    }

    @Override
    public void excluir(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Aluno buscarPorId(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Aluno> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean alunoTemPlanos(Long id) {
        Aluno aluno = this.buscarPorId(id);
        if (aluno != null) {
            return !aluno.getPlanosTreino().isEmpty();
        }
        return false;
    }
}