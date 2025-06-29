package br.ufscar.dc.dsw.validation;

import br.ufscar.dc.dsw.dao.IAlunoDAO;
import br.ufscar.dc.dsw.domain.Aluno;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String> {

    @Autowired
    private IAlunoDAO alunoDAO;

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (alunoDAO != null) {
            Aluno aluno = alunoDAO.findByCpf(cpf);
            return aluno == null;
        }
        
        return true;
    }
}