<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<fmt:setLocale value="${not empty param.lang ? param.lang : (not empty sessionScope.userLang ? sessionScope.userLang : 'pt-BR')}" scope="session"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${not empty param.lang ? param.lang : (not empty sessionScope.userLang ? sessionScope.userLang : 'pt-BR')}">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="app.title"/> - <fmt:message key="result.title"/></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .converter-container {
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            padding: 30px;
        }
        h2 {
            color: #000000;
            text-align: center;
            margin-top: 0;
        }
        .result-box {
            text-align: center;
            padding: 20px;
            margin-top: 20px;
        }
        .result-value {
            font-size: 1.5em;
            color: #000000;
            font-weight: bold;
        }
        .btn-back {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
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

    <div class="converter-container">
        <h2><fmt:message key="app.title"/></h2>
        <div class="result-box">
            <p class="result-value">
                <c:choose>
                    <c:when test="${conversao == 'mi_m'}">
                        <fmt:message key="result.mi_m">
                            <fmt:param value="${valorFormatado}"/>
                            <fmt:param value="${resultadoFormatado}"/>
                        </fmt:message>
                    </c:when>
                    <c:when test="${conversao == 'm_mi'}">
                        <fmt:message key="result.m_mi">
                            <fmt:param value="${valorFormatado}"/>
                            <fmt:param value="${resultadoFormatado}"/>
                        </fmt:message>
                    </c:when>
                    <c:when test="${conversao == 'ft_m'}">
                        <fmt:message key="result.ft_m">
                            <fmt:param value="${valorFormatado}"/>
                            <fmt:param value="${resultadoFormatado}"/>
                        </fmt:message>
                    </c:when>
                    <c:when test="${conversao == 'm_ft'}">
                        <fmt:message key="result.m_ft">
                            <fmt:param value="${valorFormatado}"/>
                            <fmt:param value="${resultadoFormatado}"/>
                        </fmt:message>
                    </c:when>
                </c:choose>
            </p>
            <a href="${pageContext.request.contextPath}/index.jsp?lang=${not empty param.lang ? param.lang : (not empty sessionScope.userLang ? sessionScope.userLang : 'pt-BR')}" class="btn-back">
                <fmt:message key="result.back_button"/>
            </a>
        </div>
    </div>
</body>
</html>