<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>PassTrans 404</title>
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

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="global" var="loc"/>
<fmt:message bundle="${loc}" key="global.notfound.dead_link" var="dead_link"/>
<fmt:message bundle="${loc}" key="global.notfound.back_home" var="back_home"/>

<body>
<jsp:include page="header.jsp"/>
<div class="banner1">
    <div class="container">

    </div>
</div>
<div class="container">
    <div class="content-top4">
        <div class="content">
            <div class="error-404 text-center">
                <h3>404</h3>
                    <p>${dead_link}</p>
                <a class="b-home" href="home">${back_home}</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
