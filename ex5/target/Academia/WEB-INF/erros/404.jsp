<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isErrorPage="true" %>
    <%@ include file="/WEB-INF/tags/includes.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página Não Encontrada (404)</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; padding: 50px; }
        h1 { font-size: 50px; color: #d32f2f; }
        .container { max-width: 600px; margin: 0 auto; }
        .actions { margin-top: 30px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>404</h1>
        <h2>Página não encontrada</h2>
        <p>A página que você está tentando acessar não existe ou foi movida.</p>
        
        <div class="actions">
            <a href="${pageContext.request.contextPath}/">Voltar à página inicial</a>
            <c:if test="${not empty header['referer']}">
                | <a href="${header['referer']}">Voltar à página anterior</a>
            </c:if>
        </div>
    </div>
</body>
</html>