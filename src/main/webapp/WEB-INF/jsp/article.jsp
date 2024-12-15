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
            <p>
                <c:choose>
                <c:when test="${cart.isInCart(item)}">
            <form action="<spring:url value='/article/${item.id}/add'/>" method="post" style="display:inline;">
                <input type="hidden" name="itemId" value="${item.id}" />
                <input type="hidden" name="itemName" value="${item.name}" />
                <input type="hidden" name="itemDensity" value="${item.density}" />
                <input type="hidden" name="itemPrice" value="${item.price}" />
                <input type="hidden" name="itemCategoryId" value="${item.categoryId}" />
                <input type="hidden" name="itemImagePath" value="${item.imagePath}" />
                <button type="submit" class="panierButton">+</button>
            </form>
                ${cart.getValueById(item.id)}
            <form action="<spring:url value='/article/${item.id}/sub'/>" method="post" style="display:inline;">
                <input type="hidden" name="itemId" value="${item.id}" />
                <input type="hidden" name="itemName" value="${item.name}" />
                <input type="hidden" name="itemDensity" value="${item.density}" />
                <input type="hidden" name="itemPrice" value="${item.price}" />
                <input type="hidden" name="itemCategoryId" value="${item.categoryId}" />
                <input type="hidden" name="itemImagePath" value="${item.imagePath}" />
                <button type="submit" class="panierButton">-</button>
            </form>
            </c:when>
            <c:otherwise>
                <form action="<spring:url value='/article/${item.id}/add'/>" method="post" style="display:inline;">
                    <input type="hidden" name="itemId" value="${item.id}" />
                    <input type="hidden" name="itemName" value="${item.name}" />
                    <input type="hidden" name="itemDensity" value="${item.density}" />
                    <input type="hidden" name="itemPrice" value="${item.price}" />
                    <input type="hidden" name="itemCategoryId" value="${item.categoryId}" />
                    <input type="hidden" name="itemImagePath" value="${item.imagePath}" />
                    <button type="submit" class="panierButton"><spring:message code="cartButton"/></button>
                </form>
            </c:otherwise>
            </c:choose>
            </p>
        </div>
    </div>
</div>
</body>
</html>
