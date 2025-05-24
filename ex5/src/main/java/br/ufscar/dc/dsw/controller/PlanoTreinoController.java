package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.PlanoTreinoDAO;
import br.ufscar.dc.dsw.dao.AlunoDAO;
import br.ufscar.dc.dsw.domain.PlanoTreino;
import br.ufscar.dc.dsw.domain.Aluno;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Treinos/*")
public class PlanoTreinoController extends HttpServlet {
    private PlanoTreinoDAO planoTreinoDAO;
    private AlunoDAO alunoDAO;

    @Override
    public void init() {
        planoTreinoDAO = new PlanoTreinoDAO();
        alunoDAO = new AlunoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/cadastro":
                    showCadastroForm(request, response);
                    break;
                case "/insercao":
                    insert(request, response);
                    break;
                case "/remocao":
                    delete(request, response);
                    break;
                case "/edicao":
                    showEditForm(request, response);
                    break;
                case "/atualizacao":
                    update(request, response);
                    break;
                default:
                    list(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PlanoTreino> listaPlanos = planoTreinoDAO.getAll();
        request.setAttribute("listaPlanos", listaPlanos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/planoTreino/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void showCadastroForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Aluno> alunos = alunoDAO.getAll();
        request.setAttribute("alunos", alunos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/planoTreino/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        PlanoTreino planoTreino = planoTreinoDAO.getById(id);
        List<Aluno> alunos = alunoDAO.getAll();
        
        request.setAttribute("planoTreino", planoTreino);
        request.setAttribute("alunos", alunos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/planoTreino/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeTreino = request.getParameter("nomeTreino");
        String tipo = request.getParameter("tipo");
        String descricao = request.getParameter("descricao");
        int duracaoSemanas = Integer.parseInt(request.getParameter("duracaoSemanas"));
        int frequenciaSemanal = Integer.parseInt(request.getParameter("frequenciaSemanal"));
        java.sql.Date dataInicio = java.sql.Date.valueOf(request.getParameter("dataInicio"));
        java.sql.Date dataFim = java.sql.Date.valueOf(request.getParameter("dataFim"));
        String observacoes = request.getParameter("observacoes");
        Long alunoId = Long.parseLong(request.getParameter("alunoId"));
        
        Aluno aluno = new Aluno();
        aluno.setId(alunoId);
        
        PlanoTreino novoPlano = new PlanoTreino(null, nomeTreino, tipo, descricao, duracaoSemanas, 
                                              frequenciaSemanal, dataInicio, dataFim, observacoes, aluno);
        planoTreinoDAO.insert(novoPlano);
        response.sendRedirect("lista");
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nomeTreino = request.getParameter("nomeTreino");
        String tipo = request.getParameter("tipo");
        String descricao = request.getParameter("descricao");
        int duracaoSemanas = Integer.parseInt(request.getParameter("duracaoSemanas"));
        int frequenciaSemanal = Integer.parseInt(request.getParameter("frequenciaSemanal"));
        java.sql.Date dataInicio = java.sql.Date.valueOf(request.getParameter("dataInicio"));
        java.sql.Date dataFim = java.sql.Date.valueOf(request.getParameter("dataFim"));
        String observacoes = request.getParameter("observacoes");
        Long alunoId = Long.parseLong(request.getParameter("alunoId"));
        
        Aluno aluno = new Aluno();
        aluno.setId(alunoId);
        
        PlanoTreino planoTreino = new PlanoTreino(id, nomeTreino, tipo, descricao, duracaoSemanas, 
                                                frequenciaSemanal, dataInicio, dataFim, observacoes, aluno);
        planoTreinoDAO.update(planoTreino);
        response.sendRedirect("lista");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        planoTreinoDAO.delete(id);
        response.sendRedirect("lista");
    }
}