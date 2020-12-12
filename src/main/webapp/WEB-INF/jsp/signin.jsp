<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PassTrans</title>
    <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <link href="../../css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Trade Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
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
            <h2>Вход</h2>
            <div class="biography">
                <div class="biographys">
                    <div class="col-md-8 biography-into">
                        <p>Уважаемый, клиент! Для пользования системой онлайн-бронирования необходимо войти в свою
                            учетную запись. Если у вас еще нет своей учётной записи, то вы можете
                            <a href="signup">зарегестрироваться</a>. После регистрации вы сможете входить в свой личный
                            кабинет, бронируйте и отменяйте места, а также смотрите историю своих поездок.</p>
                        <form action="authorize" method="POST">
                            <h4>Телефон</h4>
                            <input type="tel" name="phone" pattern="\+375(33|29|44|25)[0-9]{7}"><br><br>
                            <h4>Пароль</h4>
                            <input type="password" name="password"><br><br>
                            <p><c:out value="${requestScope.error}"/></p>
                            <input class="biography-info-right" type="submit" value="Войти"><br><br>
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

