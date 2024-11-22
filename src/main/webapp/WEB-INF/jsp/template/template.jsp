<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="<spring:url value='/css/template.css' />"/>
    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr"/>
    </spring:url>
    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en"/>
    </spring:url>
</head>
<body>
    <div id="header" class="row">
        <div class="col text-center d-flex align-items-center justify-content-center">
            <div class="col text-center d-flex align-items-center justify-content-center">
                <a href="<spring:url value='/home' />">
                    <spring:message code="homePage"/>
                </a>
            </div>
            <div class="col text-center d-flex align-items-center justify-content-center">
                <a href="${localeFr}">
                    <img alt="fr" src='<spring:url value="/images/flag_fr.png"/>' />
                </a>
                <a href="${localeEn}">
                    <img alt="en" src='<spring:url value="/images/flag_en.png"/>' />
                </a>
            </div>
        </div>
        <div class="col text-center d-flex align-items-center justify-content-center">
            <spring:message code="welcomeMessage"/>
        </div>
        <div class="col text-center d-flex align-items-center justify-content-center">
            <a href="<spring:url value='/inscription' />">
                s'inscrire
            </a>
        </div>
    </div>

    <div class="row">
      <tiles:insertAttribute name="main-content"/>
    </div>

    <div id="footer" class="row">
        <div class="col text-center d-flex align-items-center justify-content-center">
            <a href="<spring:url value='/html/informations.html' />">
                <spring:message code="companyInfos"/>
            </a>
        </div>
    </div>
</body>
</html>
