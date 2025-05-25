<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/tags/includes.jsp" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<script>
    function confirmarRemocao() {
        return confirm('<fmt:message key="aluno.msg.confirmaRemocao"/>'.replace(/'/g, "\\'"));
    }
</script>
    <meta charset="UTF-8">
    <title><fmt:message key="aluno.titulo.lista"/></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .btn {
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 3px;
            font-size: 14px;
        }
        .btn-edit {
            background-color: #4CAF50;
            color: white;
        }
        .btn-remove {
            background-color: #f44336;
            color: white;
            border: none;
            cursor: pointer;
        }
        .btn-new {
            display: inline-block;
            padding: 8px 16px;
            background-color: #2196F3;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-bottom: 15px;
        }
        .btn-new:hover {
            background-color: #0b7dda;
        }
    </style>
</head>
<body>
    <div class="header">
        <div>
            <h1><fmt:message key="aluno.titulo.lista"/></h1>
            <div class="nav-links">
                <a href="${pageContext.request.contextPath}/"><fmt:message key="menu.inicio"/></a>
            </div>
        </div>
        <div class="language-switcher">
            <a href="?lang=pt">Português</a>
            <a href="?lang=en">English</a>
        </div>
    </div>

    <a href="${pageContext.request.contextPath}/Alunos/cadastro" class="btn-new"><fmt:message key="aluno.titulo.novo"/></a>
    
    <table>
        <thead>
            <tr>
                <th><fmt:message key="aluno.label.id"/></th>
                <th><fmt:message key="aluno.label.nome"/></th>
                <th><fmt:message key="aluno.label.cpf"/></th>
                <th><fmt:message key="aluno.label.dataNascimento"/></th>
                <th><fmt:message key="aluno.label.email"/></th>
                <th><fmt:message key="aluno.label.telefone"/></th>
                <th><fmt:message key="aluno.label.acoes"/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="aluno" items="${listaAlunos}">
                <tr>
                    <td>${aluno.id}</td>
                    <td>${aluno.nome}</td>
                    <td>${aluno.cpf}</td>
                    <td>${aluno.dataNascimento}</td>
                    <td>${aluno.email}</td>
                    <td>${aluno.telefone}</td>
                    <td>
                        <div style="display: flex; gap: 5px;">
                            <a href="${pageContext.request.contextPath}/Alunos/edicao?id=${aluno.id}" class="btn btn-edit"><fmt:message key="botao.editar"/></a>
                            <a href="remocao?id=${aluno.id}" onclick="return confirmarRemocao()" class="btn btn-remove"><fmt:message key="botao.remover"/></a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>