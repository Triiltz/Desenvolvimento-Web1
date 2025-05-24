<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/tags/includes.jsp" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Alunos</title>
</head>
<body>
    <h1>Lista de Alunos</h1>
<a href="${pageContext.request.contextPath}/Alunos/cadastro">Novo Aluno</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Data Nasc.</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Ações</th>
        </tr>
        <c:forEach var="aluno" items="${listaAlunos}">
            <tr>
                <td>${aluno.id}</td>
                <td>${aluno.nome}</td>
                <td>${aluno.cpf}</td>
                <td>${aluno.dataNascimento}</td>
                <td>${aluno.email}</td>
                <td>${aluno.telefone}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/Alunos/edicao?id=${aluno.id}">Editar</a>
                    <a href="remocao?id=${aluno.id}" onclick="return confirm('Tem certeza?')">Remover</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>