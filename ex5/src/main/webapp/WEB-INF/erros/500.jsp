<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/includes.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erro Interno do Servidor (500)</title>
    <style>
        body { font-family: Arial, sans-serif; line-height: 1.6; margin: 0; padding: 20px; }
        .error-container { max-width: 800px; margin: 0 auto; padding: 20px; border: 1px solid #e0e0e0; border-radius: 5px; }
        h1 { color: #d32f2f; }
        pre { background: #f5f5f5; padding: 15px; border-radius: 4px; overflow-x: auto; }
        .actions { margin-top: 30px; }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Erro 500 - Erro Interno do Servidor</h1>
        <p>Ocorreu um erro inesperado no servidor. Por favor, tente novamente mais tarde.</p>
        
        <c:if test="${not empty requestScope['jakarta.servlet.error.message']}">
            <p><strong>Mensagem:</strong> ${requestScope['jakarta.servlet.error.message']}</p>
        </c:if>
        
        <c:if test="${pageContext.request.remoteUser eq 'admin'}">
            <h3>Detalhes Técnicos (visível apenas para admin):</h3>
            <pre>${requestScope['jakarta.servlet.error.exception']}</pre>
        </c:if>
        
        <div class="actions">
            <a href="${pageContext.request.contextPath}/">Voltar à página inicial</a>
            <c:if test="${not empty header['referer']}">
                | <a href="${header['referer']}">Voltar à página anterior</a>
            </c:if>
        </div>
    </div>
</body>
</html>