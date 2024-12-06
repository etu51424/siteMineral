<%@ page import="com.spring.henallux.firstSpringProject.model.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="./include/importTags.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<spring:url value='/css/catalog.css' />">
</head>
<body>
    <div class="col d-flex flex-column align-items-center justify-content-center">
        <c:forEach var="item" items="${Categories}">
            <a href="<spring:url value='/articles/${item.id}' />">
                <div class="row d-flex flex-column align-items-center justify-content-center">
                    <p>
                        <c:choose>
                            <c:when test="${pageContext.request.locale.language == 'fr'}">
                                ${item.getTranslation(1)}
                            </c:when>
                            <c:otherwise>
                                ${item.getTranslation(2)}
                            </c:otherwise>
                        </c:choose>
                    </p>
                </div>
            </a>
        </c:forEach>
    </div>
</body>
</html>
