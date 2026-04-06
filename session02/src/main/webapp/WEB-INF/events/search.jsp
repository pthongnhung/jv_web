<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 06/04/2026
  Time: 8:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Kết quả tìm kiếm</title>
</head>
<body>

<h2>Kết quả tìm kiếm cho: <c:out value="${keyword}" escapeXml="true"/></h2>

<c:if test="${empty events}">
    <p>Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<c:if test="${not empty events}">
    <p>Tìm thấy ${fn:length(events)} sự kiện</p>

    <table border="1">
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>

        <c:forEach var="event" items="${events}" varStatus="st">
            <tr>
                <td>${st.count}</td>
                <td><c:out value="${event.name}" escapeXml="true"/></td>
                <td>${event.date}</td>
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span style="color:green;font-weight:bold">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number" groupingUsed="true"/> VNĐ
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span style="color:red">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                            <span style="color:orange">Sắp hết (còn ${event.remainingTickets} vé)</span>
                        </c:when>
                        <c:otherwise>
                            <span style="color:blue">${event.remainingTickets}</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span style="color:gray">Đặt vé (disabled)</span>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/events/${event.id}/book'/>">Đặt vé</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<hr/>

<c:if test="${not empty events}">
    <p>Sự kiện đầu tiên: ${fn:toUpperCase(events[0].name)}</p>
</c:if>
<p>Từ khóa có ${fn:length(keyword)} ký tự.</p>

</body>
</html>
