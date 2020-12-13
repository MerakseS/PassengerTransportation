<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="global" var="loc"/>
<fmt:message bundle="${loc}" key="global.signin.first_par" var="first_par"/>
<fmt:message bundle="${loc}" key="global.signin.password" var="password"/>
<fmt:message bundle="${loc}" key="global.signin.phone" var="phone"/>
<fmt:message bundle="${loc}" key="global.signin.register" var="register"/>
<fmt:message bundle="${loc}" key="global.signin.sec_par" var="sec_par"/>
<fmt:message bundle="${loc}" key="global.signin.signin" var="signin"/>
<fmt:message bundle="${loc}" key="global.signin.submit" var="submit"/>

<html>
<head>
    <title>PassTrans</title>
    <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <link href="../../css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900' rel='stylesheet'
          type='text/css'>
    <script src="../../js/jquery.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="banner1">
    <div class="container">

    </div>
</div>
<div class="container">
    <div class="content-top1">
        <div class="content">
            <h2>${signin}</h2>
            <div class="biography">
                <div class="biographys">
                    <div class="col-md-8 biography-into">
                        <p>${first_par}<a href="signup">${register}</a>${sec_par}</p>
                        <form action="authorize" method="POST">
                            <h4>${phone}</h4>
                            <input type="tel" name="phone" pattern="\+375(33|29|44|25)[0-9]{7}"><br><br>
                            <h4>${password}</h4>
                            <input type="password" name="password"><br><br>
                            <p><c:out value="${requestScope.error}"/></p>
                            <input class="biography-info-right" type="submit" value="${submit}"><br><br>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>

