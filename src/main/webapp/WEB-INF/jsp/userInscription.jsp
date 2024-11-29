<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Inscription</title>
    <link rel="stylesheet" href="<spring:url value='/css/forms.css' />">

</head>
<body>
<div class="col d-flex flex-column align-items-center justify-content-center">
    <h2 class="row">
        <spring:message code="userFormTitle"/>
    </h2>
    <div class="row">
    <form:form class="col d-flex flex-column align-items-center justify-content-center"
        id="currentUser"
        method="POST"
        action="/mineral/inscription/send"
        modelAttribute="User">
        <p>
            <form:label path="username">
                <spring:message code="userName"/>*
            </form:label>
            <form:input path="username" required="true"/>
            <span class="error">
                <form:errors path="username">
                    <spring:message code="usernameError"/>
                </form:errors>
            </span>
        </p>
        <p>
            <form:label path="firstName">
                <spring:message code="firstName"/>*
            </form:label>
            <form:input path="firstName" required="true"/>
        </p>
        <p>
            <form:label path="lastName">
                <spring:message code="lastName"/>*
            </form:label>
            <form:input path="lastName" required="true"/>
        </p>
        <p>
            <form:label path="address">
                <spring:message code="address"/>*
            </form:label>
            <form:input path="address" required="true"/>
        </p>
        <p>
            <form:label path="email">
                <spring:message code="email"/>*
            </form:label>
            <form:input type="email" path="email" required="true"/>
        </p>
        <p>
            <form:label path="phoneNumber">
                <spring:message code="phoneNumber"/>*
            </form:label>
            <form:input path="phoneNumber" required="true"/>
        </p>
        <p>
            <form:label path="gender">
                <spring:message code="gender"/>
            </form:label>
            <form:select path="gender">
                <form:option value="M">
                    <spring:message code="genderM"/>
                </form:option>
                <form:option value="F">
                    <spring:message code="genderF"/>
                </form:option>
                <form:option value="X">
                    <spring:message code="genderX"/>
                </form:option>
                <form:option value="${null}">
                    <spring:message code="unknowGender"/>
                </form:option>
            </form:select>
        </p>
        <p>
            <form:label path="birthDate">
                <spring:message code="birthDate"/>
            </form:label>
            <form:input path="birthDate" type="date" min="1900-01-01" max="${todayDate}" />
        </p>
        <p>
            <form:label path="password">
                <spring:message code="password"/>*
            </form:label>
            <form:input path="password" type="password" required="true"/>
            <span class="error">
                <form:errors path="password">
                    <spring:message code="passwordLenghtError"/>
                </form:errors>
            </span>
        </p>
        <p>
            <form:button>
                <spring:message code="submitButton"/>
            </form:button>
            <span style="color: red"><spring:message code="requiredInfoMessage"/></span>
        </p>
    </form:form>
    </div>
</div>
</body>
</html>
