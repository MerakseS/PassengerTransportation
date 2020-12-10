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
            <h2>Регистрация</h2>
            <div class="">
                <form action="register" method="POST">
                    Телефон: <input type="tel" name="phone" pattern="\+375(33|29|44|25)[0-9]{7}"><br><br>
                    Имя: <input type="text" name="firstname"><br><br>
                    Фамилия: <input type="text" name="surname"><br><br>
                    Пароль: <input type="password" name="password"><br><br>
                    Email: <input type="email" name="email"><br><br>
                    <input type="submit" value="Зарегистрироваться"><br><br>
                    <%=
                       request.getAttribute("error") != null ? "<p>" + request.getAttribute("error") + "</p>" : "<p></p>"
                    %>
                </form>
            </div>

        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>

