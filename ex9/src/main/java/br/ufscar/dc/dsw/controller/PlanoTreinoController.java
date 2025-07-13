package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.domain.Aluno;
import br.ufscar.dc.dsw.domain.PlanoTreino;
import br.ufscar.dc.dsw.service.spec.IAlunoService;
import br.ufscar.dc.dsw.service.spec.IPlanoTreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/planos")
public class PlanoTreinoController {

    @Autowired
    private IPlanoTreinoService planoTreinoService;

    @Autowired
    private IAlunoService alunoService;

    @GetMapping("/cadastrar")
    public String cadastrar(PlanoTreino planoTreino) {
        return "plano/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("planos", planoTreinoService.buscarTodos());
        return "plano/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid PlanoTreino planoTreino, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "plano/cadastro";
        }
        planoTreinoService.salvar(planoTreino);
        attr.addFlashAttribute("sucesso", "Plano de treino inserido com sucesso.");
        return "redirect:/planos/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("planoTreino", planoTreinoService.buscarPorId(id));
        return "plano/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid PlanoTreino planoTreino, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "plano/cadastro";
        }
        planoTreinoService.salvar(planoTreino);
        attr.addFlashAttribute("sucesso", "Plano de treino editado com sucesso.");
        return "redirect:/planos/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        planoTreinoService.excluir(id);
        attr.addFlashAttribute("sucesso", "Plano de treino excluído com sucesso.");
        return "redirect:/planos/listar";
    }

    @ModelAttribute("alunos")
    public List<Aluno> listaAlunos() {
        return alunoService.buscarTodos();
    }
}