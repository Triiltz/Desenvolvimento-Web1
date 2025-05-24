<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<fmt:setLocale value="${not empty param.lang ? param.lang : (not empty sessionScope.userLang ? sessionScope.userLang : 'pt-BR')}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${not empty param.lang ? param.lang : (not empty sessionScope.userLang ? sessionScope.userLang : 'pt-BR')}">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="app.title"/></title>
    <style>
               body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        form {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 5px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        select, input[type="number"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 15px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
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
        <a href="${pageContext.request.contextPath}/?lang=pt-BR">Português</a>
        <a href="${pageContext.request.contextPath}/?lang=en">English</a>
    </div>

    <h2><fmt:message key="app.title"/></h2>

    <form action="${pageContext.request.contextPath}/converter" method="post">
        <input type="hidden" name="lang" value="${not empty param.lang ? param.lang : (not empty sessionScope.userLang ? sessionScope.userLang : 'pt-BR')}">
        
        <label for="opcao"><fmt:message key="form.select_conversion"/></label>
        <select name="conversao" id="opcao" required>
            <option value="" disabled selected><fmt:message key="form.select_option"/></option>
            <option value="mi_m"><fmt:message key="conversion.mi_m"/></option>
            <option value="m_mi"><fmt:message key="conversion.m_mi"/></option>
            <option value="ft_m"><fmt:message key="conversion.ft_m"/></option>
            <option value="m_ft"><fmt:message key="conversion.m_ft"/></option>
        </select>

        <br><br>

        <label for="valor"><fmt:message key="form.enter_value"/></label>
        <input type="number" step="any" name="valor" id="valor" required 
               placeholder='<fmt:message key="form.enter_number"/>'>
        <br><br>

        <input type="submit" value='<fmt:message key="form.convert_button"/>'>
    </form>
</body>
</html>