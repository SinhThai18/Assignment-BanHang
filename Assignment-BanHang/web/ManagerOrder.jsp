<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manager Order</title>
</head>
<body>
    <h1>Orders</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Customer ID</th>
                <th>Total Money</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.date}</td>
                    <td>${order.cusid}</td>
                    <td>${order.totalmoney}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h1>Order Lines</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Product ID</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orderLines}" var="orderLine">
                <tr>
                    <td>${orderLine.oid}</td>
                    <td>${orderLine.pid}</td>
                    <td>${orderLine.quantity}</td>
                    <td>${orderLine.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h1>Accounts</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>User</th>
                <th>Password</th>
                <th>Is Sell</th>
                <th>Is Admin</th>
                <th>Amount</th>
                <th>Phone</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${accounts}" var="account">
                <tr>
                    <td>${account.id}</td>
                    <td>${account.user}</td>
                    <td>${account.pass}</td>
                    <td>${account.isSell}</td>
                    <td>${account.isAdmin}</td>
                    <td>${account.amount}</td>
                    <td>${account.phone}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
