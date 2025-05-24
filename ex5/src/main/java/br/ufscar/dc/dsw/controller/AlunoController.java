package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.AlunoDAO;
import br.ufscar.dc.dsw.domain.Aluno;
import java.io.IOException;
import java.util.List;
import java.sql.Date;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Alunos/*")
public class AlunoController extends HttpServlet {
    private AlunoDAO dao;

    @Override
    public void init() {
        dao = new AlunoDAO();
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
        List<Aluno> listaAlunos = dao.getAll();
        request.setAttribute("listaAlunos", listaAlunos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void showCadastroForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Aluno aluno = dao.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno/formulario.jsp");
        request.setAttribute("aluno", aluno);
        dispatcher.forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        Date dataNascimento = Date.valueOf(request.getParameter("dataNascimento"));
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        Float altura = Float.parseFloat(request.getParameter("altura"));
        Float peso = Float.parseFloat(request.getParameter("peso"));
        String objetivo = request.getParameter("objetivo");
        
        Aluno novoAluno = new Aluno(null, nome, cpf, dataNascimento, email, telefone, endereco, altura, peso, objetivo);
        dao.insert(novoAluno);
        response.sendRedirect("lista");
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        Date dataNascimento = Date.valueOf(request.getParameter("dataNascimento"));
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        Float altura = Float.parseFloat(request.getParameter("altura"));
        Float peso = Float.parseFloat(request.getParameter("peso"));
        String objetivo = request.getParameter("objetivo");
        
        Aluno aluno = new Aluno(id, nome, cpf, dataNascimento, email, telefone, endereco, altura, peso, objetivo);
        dao.update(aluno);
        response.sendRedirect("lista");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        dao.delete(id);
        response.sendRedirect("lista");
    }
}