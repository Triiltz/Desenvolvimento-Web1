package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.domain.Aluno;
import br.ufscar.dc.dsw.service.spec.IAlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private IAlunoService alunoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Aluno aluno) {
        return "aluno/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("alunos", alunoService.buscarTodos());
        return "aluno/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Aluno aluno, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "aluno/cadastro";
        }
        alunoService.salvar(aluno);
        attr.addFlashAttribute("sucesso", "Aluno inserido com sucesso.");
        return "redirect:/alunos/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        return "aluno/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Aluno aluno, BindingResult result, RedirectAttributes attr) {

        if (result.getFieldErrorCount() > 1 || (result.hasErrors() && result.getFieldError("cpf") == null)) {
            return "aluno/cadastro";
        }

        Aluno alunoOriginal = alunoService.buscarPorId(aluno.getId());
        aluno.setPlanosTreino(alunoOriginal.getPlanosTreino());

        alunoService.salvar(aluno);
        attr.addFlashAttribute("sucesso", "Aluno editado com sucesso.");
        return "redirect:/alunos/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
    if (alunoService.alunoTemPlanos(id)) {
        attr.addFlashAttribute("falha", "Aluno não pode ser excluído pois possui planos de treino associados.");
    } else {
        alunoService.excluir(id);
        attr.addFlashAttribute("sucesso", "Aluno excluído com sucesso.");
    }
    return "redirect:/alunos/listar";
}
}