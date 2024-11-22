<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
    <div class="col d-flex align-items-center justify-content-center">
        <form:form
            id="userForm"
            method="post"
            action="/mineral/inscription/send"
            modelAttribute="User">
            <p>
                <form:label path="username">
                    <spring:message code="userName"/>
                </form:label>
                <form:input path="username" required="true"/>
            </p>
            <p>
                <form:label path="first_name">
                    <spring:message code="firstName"/>
                </form:label>
                <form:input path="first_name" required="true"/>
            </p>
            <p>
                <form:label path="last_name">
                    <spring:message code="lastName"/>
                </form:label>
                <form:input path="last_name" required="true"/>
            </p>
            <p>
                <form:label path="address">
                    <spring:message code="address"/>
                </form:label>
                <form:input path="address" required="true"/>
            </p>
            <p>
                <form:label path="phone_number">
                    <spring:message code="phoneNumber"/>
                </form:label>
                <form:input path="phone_number" required="true"/>
            </p>
            <p>
                <form:label path="gender">
                    <spring:message code="gender"/>
                </form:label>
                <form:select path="gender">
                    <form:option value="M">Homme</form:option>
                    <form:option value="F">Femme</form:option>
                    <form:option value="X">Autre</form:option>
                </form:select>
            </p>
            <p>
                <form:label path="birth_date">
                    <spring:message code="birthDate"/>
                </form:label>
                <form:input path="birth_date" type="date" min="1900-01-01" max="${todayDate}" />
            </p>
            <p>
                <form:label path="password">
                    <spring:message code="password"/>
                </form:label>
                <form:input path="password" required="true"/>
            </p>
            <p>
                <form:button>
                    <spring:message code="submitButton"/>
                </form:button>
            </p>
        </form:form>
    </div>
</body>
</html>
