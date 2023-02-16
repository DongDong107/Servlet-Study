<%@page import="com.newlecture.web.entity.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<table border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>가격</td>
			<td>등록일</td>
		</tr>
		
		<c:forEach var="m" items="${menus}">
			<fmt:formatNumber var="price" pattern="#,###" value="${m.price+1}"/>
			<fmt:formatDate var="regDate" pattern="yyyy-MM-dd a hh:mm:ss " value="${m.regDate}"/>
			<tr>
				<td>${m.id}</td>
				<td>${m.name}</td>
				<td>${price} 원</td>
				<td>${regDate}</td>
				<%--<%= ((Menu) pageContext.getAttribute("m")).getName()%>/ --%>
				<%--
			<td><%=m.getId()%></td>			
			<td><%=m.getName() %></td>
			<td><%=m.getPrice() %></td>
		 --%>
			</tr>
			<tr>
				<td colspan="4">
					<c:forTokens var="img" begin="2" end="4" step="1" items="${m.images}" delims="," varStatus="st">
						<a download href="upload/${img}">${img}</a>
						<c:if test="${!st.last}"> | </c:if>
				
					</c:forTokens>
				</td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>