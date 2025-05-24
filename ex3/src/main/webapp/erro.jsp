<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<fmt:setLocale value="${not empty param.lang ? param.lang : (not empty sessionScope.userLang ? sessionScope.userLang : 'pt-BR')}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${not empty param.lang ? param.lang : (not empty sessionScope.userLang ? sessionScope.userLang : 'pt-BR')}">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="app.title"/> - <fmt:message key="error.title"/></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .error-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        h2 {
            color: #333;
            text-align: center;
            margin-top: 0;
        }
        .error-message {
            background-color: #ffeeee;
            border-left: 4px solid #ff4d4d;
            padding: 15px;
            margin: 20px 0;
        }
        .error-message h3 {
            color: #ff4d4d;
            margin-top: 0;
        }
        .btn-back {
            display: inline-block;
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 16px;
        }
        .btn-back:hover {
            background-color: #45a049;
        }
        .language-switcher {
            text-align: right;
            margin-bottom: 15px;
        }
        .language-switcher a {
            margin-left: 10px;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="language-switcher">
        <a href="${pageContext.request.contextPath}/index.jsp?lang=pt-BR">Português</a>
        <a href="${pageContext.request.contextPath}/index.jsp?lang=en">English</a>
    </div>

    <div class="error-container">
        <h2><fmt:message key="app.title"/></h2>
        
        <div class="error-message">
            <h3><fmt:message key="error.header"/></h3>
            <c:choose>
                <c:when test="${errorType == 'missing_params'}">
                    <p><fmt:message key="error.missing_params"/></p>
                </c:when>
                <c:when test="${errorType == 'invalid_number'}">
                    <p><fmt:message key="error.invalid_number"/></p>
                </c:when>
                <c:when test="${errorType == 'invalid_conversion'}">
                    <p><fmt:message key="error.invalid_conversion"/></p>
                </c:when>
                <c:otherwise>
                    <p><fmt:message key="error.generic"/></p>
                </c:otherwise>
            </c:choose>
        </div>
        
        <a href="${pageContext.request.contextPath}/index.jsp?lang=${not empty param.lang ? param.lang : (not empty sessionScope.userLang ? sessionScope.userLang : 'pt-BR')}" class="btn-back">
            <fmt:message key="error.back_button"/>
        </a>
    </div>
</body>
</html>