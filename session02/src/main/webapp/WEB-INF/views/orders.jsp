<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 06/04/2026
  Time: 8:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Danh sách đơn hàng</title>
</head>
<body>
<h2>Xin chào, ${sessionScope.loggedUser}! Vai trò: ${sessionScope.role}</h2>

<c:if test="${not empty errorMessage}">
    <p style="color:red">${errorMessage}</p>
</c:if>

<table border="1">
    <tr>
        <th>Mã đơn</th>
        <th>Sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.code}</td>
            <td><c:out value="${order.product}"/></td>
            <td><fmt:formatNumber value="${order.total}" type="currency" currencySymbol="VNĐ"/></td>
            <td><fmt:formatDate value="${order.date}" pattern="dd/MM/yyyy"/></td>
        </tr>
    </c:forEach>
</table>

<p>Tổng lượt xem đơn hàng toàn hệ thống: ${applicationScope.totalViewCount}</p>
<a href="/logout">Đăng xuất</a>
</body>
</html>
