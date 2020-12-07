<%--
  Created by IntelliJ IDEA.
  User: MerakseS
  Date: 02.12.2020
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>PassTrans</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
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
    <script src="js/jquery.min.js"></script>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="banner">
    <div class="container">
        <div class="banner-info">
            <h1>Пассажирские перевозки в Беларуси!</h1>
            <a href="404.jsp" class="btn  btn-1c btn1 btn-1d">Заказать</a>
        </div>
    </div>
</div>
<div class="container">
    <div class="content-top">
        <div class="content">
            <div class="col-md-3 lente">
                <h4>Услуги</h4>
                <h6>Наша компания предоставляет следующие услуги</h6>
                <ul>
                    <li><a><span> </span>Онлайн заказ</a></li>
                    <li><a><span> </span>Колл-центр 24/7</a></li>
                    <li><a><span> </span>Отличная цена &ndash; 10р</a></li>
                    <li><a><span> </span>Удобное время отправления</a></li>
                    <li><a><span> </span>Бесплатный Wi-Fi</a></li>
                    <li><a><span> </span>Современный автопарк</a></li>
                    <li><a><span> </span>Отзывчивый персонал</a></li>
                </ul>
            </div>
            <div class="col-md-8 sedtell">
                <h3><a href="#">Пассажирские перевозки</a></h3>
                <h5>На нашем новом сайте мы собрали всю интересующую вас информацию!</h5>
                <div class="sedtell-top">
                    <div class="sedtell-left">
                        <img src="img/bus.png" class="img-responsive" alt=""/>
                    </div>
                    <div class="sedtell-right">
                        <p>Места сбора пассажиров по городам с фотографиями остановок, времена отправлений, фотогалерея
                            наших автобусов, новости и прочее &ndash; максимально доступно и понятно описано на нашем
                            сайте!</p>
                        <p>Любая поездка в другой город должна быть комфортной и не оставлять после себя тягостного
                            неприятного впечатления – вот почему мы стараемся, чтобы пассажирские перевозки в
                            НЕРЕГУЛЯРНОМ сообщении были удобными и быстрыми для всех!</p>
                        <a href="#" class="link">Read More</a>
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
