<%@page import="com.newlecture.web.entity.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Menu> menus = (List<Menu>) request.getAttribute("menus");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메뉴 목록 1111</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>가격</td>
		</tr>

		<c:forEach begin="1" end="5" step="1">

			<tr>
				<td>1</td>
				<td>아이스</td>
				<td>5000원</td>
				<%--
			<td><%=m.getId()%></td>			
			<td><%=m.getName() %></td>
			<td><%=m.getPrice() %></td>
		 --%>
			</tr>
		</c:forEach>


	</table>
</body>
</html>