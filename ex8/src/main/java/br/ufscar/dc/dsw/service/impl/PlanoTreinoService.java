package br.ufscar.dc.dsw.service.impl;

import br.ufscar.dc.dsw.dao.IPlanoTreinoDAO;
import br.ufscar.dc.dsw.domain.PlanoTreino;
import br.ufscar.dc.dsw.service.spec.IPlanoTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = false)
public class PlanoTreinoService implements IPlanoTreinoService {

    @Autowired
    IPlanoTreinoDAO dao;

    @Override
    public void salvar(PlanoTreino planoTreino) {
        dao.save(planoTreino);
    }

    @Override
    public void excluir(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PlanoTreino buscarPorId(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanoTreino> buscarTodos() {
        return dao.findAll();
    }
}