<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${empty aluno ? 'Novo Aluno' : 'Editar Aluno'}</title>
</head>
<body>
    <h1>${empty aluno ? 'Novo Aluno' : 'Editar Aluno'}</h1>
    <form action="${empty aluno ? 'insercao' : 'atualizacao'}" method="post">
        <c:if test="${not empty aluno}">
            <input type="hidden" name="id" value="${aluno.id}">
        </c:if>
        
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${aluno.nome}" required><br>
        
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" value="${aluno.cpf}" required><br>
        
        <label for="dataNascimento">Data Nascimento:</label>
        <input type="date" id="dataNascimento" name="dataNascimento" value="${aluno.dataNascimento}" required><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${aluno.email}"><br>
        
        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" value="${aluno.telefone}"><br>
        
        <label for="endereco">Endereço:</label>
        <input type="text" id="endereco" name="endereco" value="${aluno.endereco}"><br>
        
        <label for="altura">Altura (m):</label>
        <input type="number" step="0.01" id="altura" name="altura" value="${aluno.altura}" required><br>
        
        <label for="peso">Peso (kg):</label>
        <input type="number" step="0.1" id="peso" name="peso" value="${aluno.peso}" required><br>
        
        <label for="objetivo">Objetivo:</label>
        <input type="text" id="objetivo" name="objetivo" value="${aluno.objetivo}" required><br>
        
        <button type="submit">Salvar</button>
    </form>
    <a href="lista">Cancelar</a>
</body>
</html>