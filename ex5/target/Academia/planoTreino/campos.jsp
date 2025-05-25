<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="campos">
    <div class="campo">
        <label for="nomeTreino"><fmt:message key="treino.label.nome"/>:</label>
        <span>${plano.nomeTreino}</span>
    </div>
    <div class="campo">
        <label for="tipo"><fmt:message key="treino.label.tipo"/>:</label>
        <span>${plano.tipo}</span>
    </div>
    <div class="campo">
        <label for="aluno"><fmt:message key="treino.label.aluno"/>:</label>
        <span>${plano.aluno.nome}</span>
    </div>
    <div class="campo">
        <label for="duracaoSemanas"><fmt:message key="treino.label.duracao"/> (<fmt:message key="unidade.semanas"/>):</label>
        <span>${plano.duracaoSemanas}</span>
    </div>
    <div class="campo">
        <label for="frequenciaSemanal"><fmt:message key="treino.label.frequencia"/>:</label>
        <span>${plano.frequenciaSemanal}</span>
    </div>
    <div class="campo">
        <label for="dataInicio"><fmt:message key="treino.label.dataInicio"/>:</label>
        <span>${plano.dataInicio}</span>
    </div>
    <div class="campo">
        <label for="dataFim"><fmt:message key="treino.label.dataFim"/>:</label>
        <span>${plano.dataFim}</span>
    </div>
    <div class="campo">
        <label for="descricao"><fmt:message key="treino.label.descricao"/>:</label>
        <p>${plano.descricao}</p>
    </div>
    <div class="campo">
        <label for="observacoes"><fmt:message key="treino.label.observacoes"/>:</label>
        <p>${plano.observacoes}</p>
    </div>
</div>