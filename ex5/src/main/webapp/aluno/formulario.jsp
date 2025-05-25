<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="${empty aluno ? 'aluno.titulo.novo' : 'aluno.titulo.editar'}"/></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            line-height: 1.6;
        }
        h1 {
            color: #333;
        }
        .nav-links {
            margin-bottom: 20px;
        }
        .nav-links a {
            margin-right: 15px;
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
        input[type="email"],
        input[type="date"],
        input[type="number"] {
            width: 300px;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-actions {
            margin-top: 20px;
        }
        button {
            padding: 6px 12px;
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
            padding: 6px 12px;
            background-color: #f44336;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .cancel-link:hover {
            background-color: #d32f2f;
        }
      .header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
        }
        .language-switcher {
            display: flex;
            gap: 10px;
        }

        .language-switcher a {
            text-decoration: none;
            color: #0066cc;
        }
    </style>
</head>
<body>
        <div class="header">
        <div>
            <h1><fmt:message key="${empty aluno ? 'aluno.titulo.novo' : 'aluno.titulo.editar'}"/></h1>
            <div class="nav-links">
                <a href="${pageContext.request.contextPath}/"><fmt:message key="menu.inicio"/></a>
                <a href="lista"><fmt:message key="aluno.titulo.lista"/></a>
            </div>
        </div>
        <div class="language-switcher">
            <a href="?lang=pt">Português</a>
            <span>|</span>
            <a href="?lang=en">English</a>
        </div>
    </div>
    
    
    <form action="${empty aluno ? 'insercao' : 'atualizacao'}" method="post">
        <c:if test="${not empty aluno}">
            <input type="hidden" name="id" value="${aluno.id}">
        </c:if>
        
        <label for="nome"><fmt:message key="aluno.label.nome"/>:</label>
        <input type="text" id="nome" name="nome" value="${aluno.nome}" required><br>
        
        <label for="cpf"><fmt:message key="aluno.label.cpf"/>:</label>
        <input type="text" id="cpf" name="cpf" value="${aluno.cpf}" required><br>
        
        <label for="dataNascimento"><fmt:message key="aluno.label.dataNascimento"/>:</label>
        <input type="date" id="dataNascimento" name="dataNascimento" value="${aluno.dataNascimento}" required><br>
        
        <label for="email"><fmt:message key="aluno.label.email"/>:</label>
        <input type="email" id="email" name="email" value="${aluno.email}"><br>
        
        <label for="telefone"><fmt:message key="aluno.label.telefone"/>:</label>
        <input type="text" id="telefone" name="telefone" value="${aluno.telefone}"><br>
        
        <label for="endereco"><fmt:message key="aluno.label.endereco"/>:</label>
        <input type="text" id="endereco" name="endereco" value="${aluno.endereco}"><br>
        
        <label for="altura"><fmt:message key="aluno.label.altura"/> (<fmt:message key="unidade.metros"/>):</label>
        <input type="number" step="0.01" id="altura" name="altura" value="${aluno.altura}" required><br>
        
        <label for="peso"><fmt:message key="aluno.label.peso"/> (<fmt:message key="unidade.kg"/>):</label>
        <input type="number" step="0.1" id="peso" name="peso" value="${aluno.peso}" required><br>
        
        <label for="objetivo"><fmt:message key="aluno.label.objetivo"/>:</label>
        <input type="text" id="objetivo" name="objetivo" value="${aluno.objetivo}" required><br>
        
        <div class="form-actions">
            <button type="submit"><fmt:message key="botao.salvar"/></button>
            <a href="lista" class="cancel-link"><fmt:message key="botao.cancelar"/></a>
        </div>
    </form>
</body>
</html>