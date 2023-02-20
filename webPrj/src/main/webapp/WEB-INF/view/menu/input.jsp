<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="size" value="1000" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 같은 이름의 변수들이 서버 저장소에 저장되어 있을 때, 불러오게 되는 순서는
		page, request, session, application 순서이다. 그중에서 원하는 저장소에서 불러오고 싶다면
		pageScope 와 같이 위에 Scope를 붙이면 된다.  -->
	<div>
		page : ${page},query : ${query}, size : ${requestScope.size}<br>
		param size : ${param.s}<br> header userAgent :
		${header["User-Agent"] }<br> header 유입경로 : ${header.referer }<br>
		hb length: ${cnt}
	</div>


	<a href="/input?p=2&q=hello&s=15">1</a>
	<br>
	<a href="/input?p=2&q=hello&s=15">2</a>
	<br>
	<a href="/input?p=2&q=hello&s=15">3</a>
	<br>

	<form action="/input" >
		<fieldset>
			<legend>쿼리 값</legend>
			<label>page:</label> 
			<input type="text" name="p"><br> 
			<label>검색어:</label>
			<input type="text" name="q"><br> 
			<label>size:</label> 
			<input type="text" name="s">
		</fieldset>

		<fieldset>
			<legend>취미</legend>
			<input type="checkbox" name="hb" value="1">
			<label>탁구</label>
			<input type="checkbox" name="hb" value="2">			
			<label>독서</label>
			<input type="checkbox" name="hb" value="3">
			<label>술</label>			
		</fieldset>
		
		<button type="submit">출력</button>


	</form>
</body>
</html>