<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="campos">
    <div class="campo">
        <label for="nome">Nome:</label>
        <span>${aluno.nome}</span>
    </div>
    <div class="campo">
        <label for="cpf">CPF:</label>
        <span>${aluno.cpf}</span>
    </div>
    <div class="campo">
        <label for="dataNascimento">Data Nascimento:</label>
        <span>${aluno.dataNascimento}</span>
    </div>
    <div class="campo">
        <label for="email">Email:</label>
        <span>${aluno.email}</span>
    </div>
    <div class="campo">
        <label for="telefone">Telefone:</label>
        <span>${aluno.telefone}</span>
    </div>
    <div class="campo">
        <label for="endereco">Endereço:</label>
        <span>${aluno.endereco}</span>
    </div>
    <div class="campo">
        <label for="altura">Altura:</label>
        <span>${aluno.altura} m</span>
    </div>
    <div class="campo">
        <label for="peso">Peso:</label>
        <span>${aluno.peso} kg</span>
    </div>
    <div class="campo">
        <label for="objetivo">Objetivo:</label>
        <span>${aluno.objetivo}</span>
    </div>
    <div class="campo">
        <label>Planos de Treino:</label>
        <c:choose>
            <c:when test="${not empty aluno.planosTreino}">
                <ul>
                    <c:forEach var="plano" items="${aluno.planosTreino}">
                        <li>${plano.nomeTreino} (${plano.tipo}) - ${plano.duracaoSemanas} semanas</li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <span>Nenhum plano de treino cadastrado</span>
            </c:otherwise>
        </c:choose>
    </div>
</div>