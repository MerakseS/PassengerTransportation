<%@ page import="by.bsuir.poit.entity.User" %>
<%@ page import="by.bsuir.poit.controller.Controller" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="global" var="loc"/>
<fmt:message bundle="${loc}" key="global.header.home" var="home"/>
<fmt:message bundle="${loc}" key="global.header.about" var="about"/>
<fmt:message bundle="${loc}" key="global.header.order" var="order"/>
<fmt:message bundle="${loc}" key="global.header.signup" var="signup"/>
<fmt:message bundle="${loc}" key="global.header.signin" var="signin"/>
<fmt:message bundle="${loc}" key="global.header.logout" var="logout"/>

<%
    User user = Controller.checkAuthorization(request, response);

    if (user != null) {
        request.setAttribute("userName", user.getFirstName() + " " + user.getSurname());
    }
%>


<!-- header -->
<header class="container">
    <div class="header">
        <div class="logo">
            <a href="home"><img src="../../img/logo.png" class="img-responsive" alt=""/></a>
        </div>
        <div class="nav-top">
            <div class="head-nav">
                <span class="menu"> </span>
                <ul class="cl-effect-16">
                    <li><a href="home" data-hover="HOME">${home}</a></li>
                    <li><a href="order" data-hover="ORDER">${order}</a></li>
                    <li><a href="about" data-hover="ABOUT">${about}</a></li>
                    <c:if test="${userName == null}">
                        <li><a href="signup" data-hover="SIGN UP">${signup}</a></li>
                        <li><a href="signin" data-hover="SIGN IN">${signin}</a></li>
                    </c:if>
                    <c:if test="${userName != null}">
                        <li><a href="user" data-hover=\"USER\">${userName}</a></li>
                        <li><a href="logout" data-hover=\"LOGOUT\">${logout}</a></li>
                    </c:if>
                    <div class="clearfix"></div>
                </ul>
            </div>
        </div>
        <div class="clearfix"></div>
        <!-- script-for-nav -->
        <script>
            $("span.menu").click(function () {
                $(".head-nav ul").slideToggle(300, function () {
                    // Animation complete.
                });
            });
        </script>
        <!-- script-for-nav -->
    </div>
</header>
<!-- header -->
