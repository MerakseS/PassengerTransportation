<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="global" var="loc"/>
<fmt:message bundle="${loc}" key="global.about.about_company" var="about_company"/>
<fmt:message bundle="${loc}" key="global.about.our_job" var="our_job"/>
<fmt:message bundle="${loc}" key="global.about.our_job_paragraph" var="our_job_paragraph"/>
<fmt:message bundle="${loc}" key="global.about.convenient_booking" var="convenient_booking"/>
<fmt:message bundle="${loc}" key="global.about.convenient_booking_paragraph" var="convenient_booking_paragraph"/>
<fmt:message bundle="${loc}" key="global.about.our_website" var="our_website"/>
<fmt:message bundle="${loc}" key="global.about.our_website_first_paragraph" var="our_website_first_paragraph"/>
<fmt:message bundle="${loc}" key="global.about.our_website_sec_paragraph" var="our_website_sec_paragraph"/>

<div class="banner1">
    <div class="container">

    </div>
</div>
<div class="container">
    <div class="content-top1">
        <div class="content">
            <h2>${about_company}</h2>
            <div class="biography">
                <div class="biographys">
                    <div class="col-md-8 biography-into">
                        <h4>${our_job}</h4>
                        <p>${our_job_paragraph}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="biographys">
                    <div class="col-md-8 biography-into">
                        <h4>${convenient_booking}</h4>
                        <p>${convenient_booking_paragraph}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="biographys">
                    <div class="col-md-8 biography-into">
                        <h4>${our_website}</h4>
                        <p>${our_website_first_paragraph}</p>
                    </div>
                    <div class="col-md-8 biography-into">
                        <p>${our_website_sec_paragraph}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
