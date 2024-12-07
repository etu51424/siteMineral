<%@ page import="com.spring.henallux.firstSpringProject.model.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="./include/importTags.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<spring:url value='/css/articles.css' />">
</head>
<body>
    <div class="col d-flex flex-column align-items-center justify-content-center">
        <div class="row">
            <div class="col d-flex flex-column align-items-center justify-content-center">
                <a href="<spring:url value='/catalog' />">
                    <img alt="<spring:message code='logIn'/>" src='<spring:url value="/images/utils/return.png"/>' />
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col d-flex flex-column align-items-center justify-content-center">
                <c:forEach var="item" items="${minerals}">
                    <div class="row d-flex flex-column align-items-center justify-content-center">
                            <img alt="${item.imagePath}" src='<spring:url value="${item.imagePath}"/>' />
                        <p><spring:message code="name"/> : ${item.name}</p>
                        <p><spring:message code="density"/> : ${item.density}</p>
                        <p><spring:message code="price"/> : ${item.price}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
