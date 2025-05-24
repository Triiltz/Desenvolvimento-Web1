<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="campos">
    <div class="campo">
        <label for="nomeTreino">Nome do Treino:</label>
        <span>${plano.nomeTreino}</span>
    </div>
    <div class="campo">
        <label for="tipo">Tipo:</label>
        <span>${plano.tipo}</span>
    </div>
    <div class="campo">
        <label for="aluno">Aluno:</label>
        <span>${plano.aluno.nome}</span>
    </div>
    <div class="campo">
        <label for="duracaoSemanas">Duração (semanas):</label>
        <span>${plano.duracaoSemanas}</span>
    </div>
    <div class="campo">
        <label for="frequenciaSemanal">Frequência Semanal:</label>
        <span>${plano.frequenciaSemanal}</span>
    </div>
    <div class="campo">
        <label for="dataInicio">Data Início:</label>
        <span>${plano.dataInicio}</span>
    </div>
    <div class="campo">
        <label for="dataFim">Data Fim:</label>
        <span>${plano.dataFim}</span>
    </div>
    <div class="campo">
        <label for="descricao">Descrição:</label>
        <p>${plano.descricao}</p>
    </div>
    <div class="campo">
        <label for="observacoes">Observações:</label>
        <p>${plano.observacoes}</p>
    </