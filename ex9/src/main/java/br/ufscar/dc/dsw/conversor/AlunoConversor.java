package br.ufscar.dc.dsw.conversor;

import br.ufscar.dc.dsw.domain.Aluno;
import br.ufscar.dc.dsw.service.spec.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AlunoConversor implements Converter<String, Aluno> {

    @Autowired
    private IAlunoService alunoService;

    @Override
    public Aluno convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        
        Long id = Long.valueOf(text);
        
        return alunoService.buscarPorId(id);
    }
}