<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="${empty planoTreino ? 'treino.titulo.novo' : 'treino.titulo.editar'}"/></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            line-height: 1.6;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        h1 {
            color: #333;
            margin: 0;
        }
        .nav-links {
            display: flex;
            gap: 15px;
        }
        .nav-links a {
            text-decoration: none;
            color: #0066cc;
        }
        .language-switcher {
            display: flex;
            gap: 10px;
        }
        .language-switcher a {
            text-decoration: none;
            color: #0066cc;
        }
        form {
            max-width: 600px;
            margin-top: 20px;
        }
        label {
            display: inline-block;
            width: 200px;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"],
        input[type="date"],
        select,
        textarea {
            width: 300px;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        textarea {
            height: 100px;
        }
        .form-actions {
            margin-top: 20px;
        }
        button {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }
        button:hover {
            background-color: #45a049;
        }
        .cancel-link {
            display: inline-block;
            padding: 8px 16px;
            background-color: #f44336;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .cancel-link:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <div class="header">
        <div>
            <h1><fmt:message key="${empty planoTreino ? 'treino.titulo.novo' : 'treino.titulo.editar'}"/></h1>
            <div class="nav-links">
                <a href="${pageContext.request.contextPath}/"><fmt:message key="menu.inicio"/></a>
                <a href="${pageContext.request.contextPath}/Treinos/lista"><fmt:message key="treino.titulo.lista"/></a>
            </div>
        </div>
        <div class="language-switcher">
            <a href="?lang=pt">Português</a>
            <a href="?lang=en">English</a>
        </div>
    </div>

    <form action="${empty planoTreino ? 'insercao' : 'atualizacao'}" method="post">
        <c:if test="${not empty planoTreino}">
            <input type="hidden" name="id" value="${planoTreino.id}">
        </c:if>
        
        <label for="nomeTreino"><fmt:message key="treino.label.nome"/>:</label>
        <input type="text" id="nomeTreino" name="nomeTreino" value="${planoTreino.nomeTreino}" required><br>
        
        <label for="tipo"><fmt:message key="treino.label.tipo"/>:</label>
        <input type="text" id="tipo" name="tipo" value="${planoTreino.tipo}" required><br>
        
        <label for="descricao"><fmt:message key="treino.label.descricao"/>:</label>
        <textarea id="descricao" name="descricao" required>${planoTreino.descricao}</textarea><br>
        
        <label for="duracaoSemanas"><fmt:message key="treino.label.duracao"/> (<fmt:message key="unidade.semanas"/>):</label>
        <input type="number" id="duracaoSemanas" name="duracaoSemanas" value="${planoTreino.duracaoSemanas}" required><br>
        
        <label for="frequenciaSemanal"><fmt:message key="treino.label.frequencia"/>:</label>
        <input type="number" id="frequenciaSemanal" name="frequenciaSemanal" value="${planoTreino.frequenciaSemanal}" required><br>
        
        <label for="dataInicio"><fmt:message key="treino.label.dataInicio"/>:</label>
        <input type="date" id="dataInicio" name="dataInicio" value="${planoTreino.dataInicio}" required><br>
        
        <label for="dataFim"><fmt:message key="treino.label.dataFim"/>:</label>
        <input type="date" id="dataFim" name="dataFim" value="${planoTreino.dataFim}" required><br>
        
        <label for="observacoes"><fmt:message key="treino.label.observacoes"/>:</label>
        <textarea id="observacoes" name="observacoes">${planoTreino.observacoes}</textarea><br>
        
        <label for="alunoId"><fmt:message key="treino.label.aluno"/>:</label>
        <select id="alunoId" name="alunoId" required>
            <option value=""><fmt:message key="treino.select.aluno"/></option>
            <c:forEach var="aluno" items="${alunos}">
                <option value="${aluno.id}" ${planoTreino.aluno.id eq aluno.id ? 'selected' : ''}>
                    ${aluno.nome} (${aluno.cpf})
                </option>
            </c:forEach>
        </select><br>
        
        <div class="form-actions">
            <button type="submit"><fmt:message key="botao.salvar"/></button>
            <a href="${pageContext.request.contextPath}/Treinos/lista" class="cancel-link"><fmt:message key="botao.cancelar"/></a>
        </div>
    </form>
</body>
</html>