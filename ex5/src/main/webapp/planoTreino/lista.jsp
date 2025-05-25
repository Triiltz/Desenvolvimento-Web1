<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<script>
    function confirmarRemocaoPlano() {
        return confirm('<fmt:message key="treino.msg.confirmaRemocao"/>'.replace(/'/g, "\\'"));
    }
</script>
    <meta charset="UTF-8">
    <title><fmt:message key="treino.titulo.lista"/></title>
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
            <h1><fmt:message key="treino.titulo.lista"/></h1>
            <div class="nav-links">
                <a href="${pageContext.request.contextPath}/"><fmt:message key="menu.inicio"/></a>
            </div>
        </div>
        <div class="language-switcher">
            <a href="?lang=pt">Português</a>
            <span>|</span>
            <a href="?lang=en">English</a>
        </div>
    </div>

    <a href="${pageContext.request.contextPath}/Treinos/cadastro" class="btn-new"><fmt:message key="treino.botao.novo"/></a>
    
    <table>
        <thead>
            <tr>
                <th><fmt:message key="treino.label.id"/></th>
                <th><fmt:message key="treino.label.nome"/></th>
                <th><fmt:message key="treino.label.tipo"/></th>
                <th><fmt:message key="treino.label.aluno"/></th>
                <th><fmt:message key="treino.label.acoes"/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaPlanos}" var="plano">
                <tr>
                    <td>${plano.id}</td>
                    <td>${plano.nomeTreino}</td>
                    <td>${plano.tipo}</td>
                    <td>${plano.aluno.nome}</td>
                    <td>
                        <div style="display: flex; gap: 5px;">
                            <a href="${pageContext.request.contextPath}/Treinos/edicao?id=${plano.id}" class="btn btn-edit"><fmt:message key="botao.editar"/></a>
                            <form action="${pageContext.request.contextPath}/Treinos/remocao" method="post" style="margin: 0;">
                                <input type="hidden" name="id" value="${plano.id}">
                                <button type="submit" class="btn btn-remove" onclick="return confirmarRemocaoPlano()"><fmt:message key="botao.remover"/></button>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>