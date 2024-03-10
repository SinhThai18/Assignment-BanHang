<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${listC}" var="o">
                <li class="list-group-item text-white">
                    <a href="category?cid=${o.cid}">${o.cname}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">New product</div>
        <div class="card-body">
            <img class="img-fluid" src="${p.image}" alt="Product Image" />
            <h5 class="card-title">${p.name}</h5>
            <p class="card-text">${p.description}</p>
            <p class="bloc_left_price">${p.price} VND</p>
        </div>
    </div>
</div>
