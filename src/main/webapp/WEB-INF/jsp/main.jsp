<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="global" var="loc"/>
<fmt:message bundle="${loc}" key="global.main.all_info" var="all_info"/>
<fmt:message bundle="${loc}" key="global.main.call_center" var="call_center"/>
<fmt:message bundle="${loc}" key="global.main.convenient_time" var="convenient_time"/>
<fmt:message bundle="${loc}" key="global.main.first_par" var="first_par"/>
<fmt:message bundle="${loc}" key="global.main.free_wifi" var="free_wifi"/>
<fmt:message bundle="${loc}" key="global.main.helpful_staff" var="helpful_staff"/>
<fmt:message bundle="${loc}" key="global.main.modern_vehicle_fleet" var="modern_vehicle_fleet"/>
<fmt:message bundle="${loc}" key="global.main.next_services" var="next_services"/>
<fmt:message bundle="${loc}" key="global.main.online_order" var="online_order"/>
<fmt:message bundle="${loc}" key="global.main.passtrans" var="passtrans"/>
<fmt:message bundle="${loc}" key="global.main.passtrans_bel" var="passtrans_bel"/>
<fmt:message bundle="${loc}" key="global.main.price" var="price"/>
<fmt:message bundle="${loc}" key="global.main.sec_par" var="sec_par"/>
<fmt:message bundle="${loc}" key="global.main.services" var="services"/>
<fmt:message bundle="${loc}" key="global.header.order" var="order"/>

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
<div class="banner">
    <div class="container">
        <div class="banner-info">
            <h1>${passtrans_bel}</h1>
            <a href="order" class="btn  btn-1c btn1 btn-1d">${order}</a>
        </div>
    </div>
</div>
<div class="container">
    <div class="content-top">
        <div class="content">
            <div class="col-md-3 lente">
                <h4>${services}</h4>
                <h6>${next_services}</h6>
                <ul>
                    <li><a><span> </span>${online_order}</a></li>
                    <li><a><span> </span>${call_center}</a></li>
                    <li><a><span> </span>${price}</a></li>
                    <li><a><span> </span>${convenient_time}</a></li>
                    <li><a><span> </span>${free_wifi}</a></li>
                    <li><a><span> </span>${modern_vehicle_fleet}</a></li>
                    <li><a><span> </span>${helpful_staff}</a></li>
                </ul>
            </div>
            <div class="col-md-8 sedtell">
                <h3>${passtrans}</h3>
                <h5>${all_info}</h5>
                <div class="sedtell-top">
                    <div class="sedtell-left">
                        <img src="../../img/bus.png" class="img-responsive" alt=""/>
                    </div>
                    <div class="sedtell-right">
                        <p>${first_par}</p>
                        <p>${sec_par}</p>
                        <a href="about" class="link">Read More</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>