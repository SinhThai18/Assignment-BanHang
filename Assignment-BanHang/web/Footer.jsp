<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Footer -->
<footer class="text-light">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-lg-4 col-xl-4">
                <h5>About</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <p class="mb-0">
                    Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.
                </p>
            </div>

            <%-- Information links --%>
            <div class="col-md-4 col-lg-4 col-xl-4">
                <h5>Informations</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <c:set var="informationLinks" value="${{'Link 1', 'Link 2', 'Link 3', 'Link 4'}}"/>
                    <c:forEach items="${informationLinks}" var="link">
                        <li><a href="">${link}</a></li>
                    </c:forEach>
                </ul>
            </div>

            <%-- Contact information --%>
            <div class="col-md-4 col-lg-4 col-xl-4">
                <h5>Contact</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><i class="fa fa-home mr-2"></i> My company</li>
                    <li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
                    <li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
                    <li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
                </ul>
            </div>
        </div>
    </div>
</footer>
