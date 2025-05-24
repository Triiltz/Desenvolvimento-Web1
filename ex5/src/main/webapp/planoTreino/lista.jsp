<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Planos de Treino</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <h1>Lista de Planos de Treino</h1>
    <a href="${pageContext.request.contextPath}/Treinos/cadastro">Novo Plano</a>    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Tipo</th>
            <th>Aluno</th>
            <th>Ações</th>
        </tr>
        <c:forEach items="${listaPlanos}" var="plano">
            <tr>
                <td>${plano.id}</td>
                <td>${plano.nomeTreino}</td>
                <td>${plano.tipo}</td>
                <td>${plano.aluno.nome}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/Treinos/edicao?id=${plano.id}">Editar</a>
                    <form action="${pageContext.request.contextPath}/Treinos/remocao" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${plano.id}">
                        <button type="submit" onclick="return confirm('Tem certeza?')">Remover</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>