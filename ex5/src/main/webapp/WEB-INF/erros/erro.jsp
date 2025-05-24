<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/includes.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erro na Aplicação</title>
    <style>
        body { font-family: Arial, sans-serif; line-height: 1.6; margin: 0; padding: 20px; }
        .error-container { max-width: 800px; margin: 0 auto; padding: 20px; border: 1px solid #e0e0e0; border-radius: 5px; }
        h1 { color: #d32f2f; }
        pre { background: #f5f5f5; padding: 15px; border-radius: 4px; overflow-x: auto; }
        .details { margin-top: 20px; }
        .actions { margin-top: 30px; }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Ocorreu um erro inesperado</h1>
        
        <div class="details">
            <c:choose>
                <c:when test="${not empty requestScope['jakarta.servlet.error.message']}">
                    <p><strong>Mensagem:</strong> ${requestScope['jakarta.servlet.error.message']}</p>
                </c:when>
                <c:when test="${not empty exception}">
                    <p><strong>Exceção:</strong> ${exception.message}</p>
                </c:when>
                <c:otherwise>
                    <p>Nenhuma informação adicional disponível sobre o erro.</p>
                </c:otherwise>
            </c:choose>
            
            <c:if test="${not empty exception}">
                <h3>Detalhes do Erro:</h3>
                <pre><c:out value="${exception.stackTrace}"/></pre>
            </c:if>
        </div>
        
        <div class="actions">
            <a href="${pageContext.request.contextPath}/">Voltar à página inicial</a>
            <c:if test="${not empty header['referer']}">
                | <a href="${header['referer']}">Voltar à página anterior</a>
            </c:if>
        </div>
    </div>
</body>
</html>