<%@ page contentType="text/html;charset=UTF-8" %>
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
                    <li><a href="home" data-hover="HOME">ДОМОЙ</a></li>
                    <li><a href="order" data-hover="ORDER">ЗАКАЗАТЬ</a></li>
                    <li><a href="about" data-hover="ABOUT">О НАС</a></li>
                    <li><a href="contact" data-hover="CONTACT">КОНТАКТЫ</a></li>
                    <li><a href="signup" data-hover="SIGN UP">РЕГИСТРАЦИЯ</a></li>
                    <li><a href="signin" data-hover="SIGN IN">ВХОД</a></li>
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
