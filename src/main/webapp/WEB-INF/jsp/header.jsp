<%@ page contentType="text/html;charset=UTF-8" %>
<!-- header -->
<header class="container">
    <div class="header">
        <div class="logo">
            <a href="../../index.jsp"><img src="../../img/logo.png" class="img-responsive" alt=""/></a>
        </div>
        <div class="nav-top">
            <div class="head-nav">
                <span class="menu"> </span>
                <ul class="cl-effect-16">
                    <li><a href="controller?command=home" data-hover="HOME">HOME</a></li>
                    <li><a href="controller?command=notFound" data-hover="ORDER">ORDER</a></li>
                    <li><a href="controller?command=notFound" data-hover="ABOUT">ABOUT</a></li>
                    <li><a href="controller?command=notFound" data-hover="CONTACT">CONTACT</a></li>
                    <li><a href="controller?command=notFound" data-hover="SIGN IN">SIGN IN</a></li>
                    <li><a href="controller?command=notFound" data-hover="SIGN UP">SIGN UP</a></li>
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
