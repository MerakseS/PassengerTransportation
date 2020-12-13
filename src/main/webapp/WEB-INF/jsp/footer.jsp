<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="global" var="loc"/>
<fmt:message bundle="${loc}" key="global.footer.copyrights" var="copyrights"/>
<!-- footer -->
<div class="footer">
    <div class="container">
        <p>${copyrights}</p>
        <p><a href="locale?local=en">English</a> <a href="locale?local=ru">Русский</a></p>
    </div>
</div>
<!-- footer -->
