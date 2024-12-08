<%@ page import="com.spring.henallux.firstSpringProject.model.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="./include/importTags.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<spring:url value='/css/cart.css' />">
</head>
<body>
<div class="col d-flex flex-column align-items-center justify-content-center">
    <div class="row">
        <p class="bold">Contenu du panier :</p>
    </div>
    <div class="row">
        <c:forEach var="item" items="${cart.getContent().keySet()}">
            <div class="row d-flex flex-column align-items-center justify-content-center">
                <img alt="${item.imagePath}" src='<spring:url value="/images/minerals/${item.imagePath}"/>' />
                <p><span class="bold"><spring:message code="name"/> :</span> ${item.name}</p>
                <p><span class="bold"><spring:message code="density"/> :</span>
                    <c:choose>
                        <c:when test="${item.density <= 2}">
                            <spring:message code="DensityLight"/>
                        </c:when>
                        <c:when test="${item.density <= 4}">
                            <spring:message code="DensityMediumHeavy"/>
                        </c:when>
                        <c:when test="${item.density <= 6}">
                            <spring:message code="DensityHeavy"/>
                        </c:when>
                        <c:when test="${item.density <= 10}">
                            <spring:message code="DensityVeryHeavy"/>
                        </c:when>
                        <c:otherwise>
                            ${item.density}
                        </c:otherwise>
                    </c:choose>
                </p>
                <p><span class="bold"><spring:message code="price"/> :</span> ${item.price} € / kg</p>
                <p><span class="bold">Quantité :</span> ${cart.content.get(item)}</p>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <p class="bold">Prix total : ${cart.getTotalPrice()}</p>
    </div>
</div>
</body>
</html>
