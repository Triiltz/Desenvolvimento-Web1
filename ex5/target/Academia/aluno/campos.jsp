<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="campos">
    <div class="campo">
        <label for="nome"><fmt:message key="aluno.label.nome"/>:</label>
        <span>${aluno.nome}</span>
    </div>
    <div class="campo">
        <label for="cpf"><fmt:message key="aluno.label.cpf"/>:</label>
        <span>${aluno.cpf}</span>
    </div>
    <div class="campo">
        <label for="dataNascimento"><fmt:message key="aluno.label.dataNascimento"/>:</label>
        <span>${aluno.dataNascimento}</span>
    </div>
    <div class="campo">
        <label for="email"><fmt:message key="aluno.label.email"/>:</label>
        <span>${aluno.email}</span>
    </div>
    <div class="campo">
        <label for="telefone"><fmt:message key="aluno.label.telefone"/>:</label>
        <span>${aluno.telefone}</span>
    </div>
    <div class="campo">
        <label for="endereco"><fmt:message key="aluno.label.endereco"/>:</label>
        <span>${aluno.endereco}</span>
    </div>
    <div class="campo">
        <label for="altura"><fmt:message key="aluno.label.altura"/>:</label>
        <span>${aluno.altura} <fmt:message key="unidade.metros"/></span>
    </div>
    <div class="campo">
        <label for="peso"><fmt:message key="aluno.label.peso"/>:</label>
        <span>${aluno.peso} <fmt:message key="unidade.kg"/></span>
    </div>
    <div class="campo">
        <label for="objetivo"><fmt:message key="aluno.label.objetivo"/>:</label>
        <span>${aluno.objetivo}</span>
    </div>
    <div class="campo">
        <label><fmt:message key="aluno.label.planosTreino"/>:</label>
        <c:choose>
            <c:when test="${not empty aluno.planosTreino}">
                <ul>
                    <c:forEach var="plano" items="${aluno.planosTreino}">
                        <li>${plano.nomeTreino} (${plano.tipo}) - ${plano.duracaoSemanas} <fmt:message key="unidade.semanas"/></li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <span><fmt:message key="aluno.msg.semPlanos"/></span>
            </c:otherwise>
        </c:choose>
    </div>
</div>