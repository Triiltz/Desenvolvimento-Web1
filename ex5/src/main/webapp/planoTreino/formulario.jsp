<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Novo Plano de Treino</title>
    <style>
        .form-container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: inline-block;
            width: 180px;
            font-weight: bold;
        }
        input, select, textarea {
            padding: 8px;
            width: 300px;
        }
        textarea {
            height: 100px;
        }
        .actions {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Novo Plano de Treino</h1>
        
        <form action="${empty planoTreino ? 'insercao' : 'atualizacao'}" method="post">
            <c:if test="${not empty planoTreino}">
                <input type="hidden" name="id" value="${planoTreino.id}">
            </c:if>
            
            <div class="form-group">
                <label for="nomeTreino">Nome do Treino:</label>
                <input type="text" id="nomeTreino" name="nomeTreino" 
                       value="" required>
            </div>
            
            <div class="form-group">
                <label for="tipo">Tipo:</label>
                <input type="text" id="tipo" name="tipo" 
                       value="" required>
            </div>
            
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <textarea id="descricao" name="descricao" required></textarea>
            </div>
            
            <div class="form-group">
                <label for="duracaoSemanas">Duração (semanas):</label>
                <input type="number" id="duracaoSemanas" name="duracaoSemanas" 
                       value="${planoTreino.duracaoSemanas}" required>
            </div>
            
            <div class="form-group">
                <label for="frequenciaSemanal">Frequência Semanal:</label>
                <input type="number" id="frequenciaSemanal" name="frequenciaSemanal" 
                       value="${planoTreino.frequenciaSemanal}" required>
            </div>
            
            <div class="form-group">
                <label for="dataInicio">Data Início:</label>
                <input type="date" id="dataInicio" name="dataInicio" 
                       value="${planoTreino.dataInicio}" required>
            </div>
            
            <div class="form-group">
                <label for="dataFim">Data Fim:</label>
                <input type="date" id="dataFim" name="dataFim" 
                       value="${planoTreino.dataFim}" required>
            </div>
            
            <div class="form-group">
                <label for="observacoes">Observações:</label>
                <textarea id="observacoes" name="observacoes">${planoTreino.observacoes}</textarea>
            </div>
            
            <div class="form-group">
                <label for="alunoId">Aluno:</label>
                <select id="alunoId" name="alunoId" required>
                    <option value="">Selecione um aluno</option>
                    <c:forEach var="aluno" items="${alunos}">
                        <option value="${aluno.id}" 
                            ${planoTreino.aluno.id eq aluno.id ? 'selected' : ''}>
                            ${aluno.nome} (${aluno.cpf})
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="actions">
                <button type="submit">Salvar</button>
                <a href="${pageContext.request.contextPath}/Treinos/lista">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>