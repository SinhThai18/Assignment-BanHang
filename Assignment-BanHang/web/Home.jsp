<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="Boo1.jpg" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="home">Home</a></li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>
                    <div class="col-sm-9">
                        <div id="content" class="row">
                        <c:forEach items="${listP}" var="o" varStatus="loop">
                            <c:set var="id" value="${o.id}"/>
                            <div class="product col-12 col-md-4">
                                <div class="card">
                                    <img class="card-img-top" src="${o.image}" alt="Card image cap" width="100%" height="auto">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.description}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.price} VND</p>
                                            </div>
                                            <form id="addToCartForm" action="buy" method="get" name="f">
                                                <div class="col">
                                                    <a href="buy?id=${o.id}&num=1" title="Add to Cart">Add to cart</a>
                                                </div>
                                                <div class="col">
                                                    Enter number: <input type="number" name="num" value="1"/>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%-- Đóng hàng nếu đã đến sản phẩm thứ 3 hoặc là sản phẩm cuối cùng --%>
                            <c:if test="${loop.index % 3 == 2 || loop.last}">
                            </div><div class="row">
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>
<script type="text/javascript">
    function buy(id, index) {
        var form = document.getElementsByName('f')[index];
        var num = form.querySelector('[name="num"]').value;
        form.action = "buy?id=" + id + "&num=" + num;
        form.submit();
    }
</script>
