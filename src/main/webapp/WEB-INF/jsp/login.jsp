<%@ include file="./include/importTags.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>
        <spring:message code="loginPage"/>
    </title>
    <link rel="stylesheet" href="<spring:url value='/css/forms.css' />">
</head>
<body>
<div class="col d-flex flex-column align-items-center justify-content-center">
    <h2 class="row">
        <spring:message code="loginPage"/>
    </h2>
    <div class="row">
        <form:form class="col d-flex flex-column align-items-center justify-content-center"
                method="post"
                modelAttribute="User">
            <p>
                <form:label path="username">
                    <spring:message code="userName"/>
                </form:label>
                <form:input path="username"/>
            </p>
            <p>
                <form:label path="password">
                    <spring:message code="password"/>
                </form:label>
                <form:input path="password"/>
            </p>

            <span class="error">
                <form:errors path="*">
                    <spring:message code="loginError"/>
                </form:errors>
            </span>

            <form:button>
                <spring:message code="submitButton"/>
            </form:button>

        </form:form>
    </div>
</div>
</body>
</html>