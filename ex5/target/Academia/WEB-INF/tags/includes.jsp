<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- Configurações básicas --%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
<fmt:setLocale value="pt_BR" />
<fmt:setBundle basename="messages" />

<%-- CSS padrão --%>
<link rel="stylesheet" href="${contextPath}/resources/css/styles.css">

<%-- JS padrão --%>
<script src="${contextPath}/resources/js/scripts.js"></script>

<%-- Meta tags --%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">