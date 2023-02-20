package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class InputController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		// 1. 쿼리 스트링을 이용한 입력
		// QueryString 이란? : 문서를 요청하면서 요청하는 추가 옵션 값
		// 예) 페이지, 검색어, 레코드 개수, 기간, ...
		// 대신 옵션은 서버측에서 제공하는 것이기 때문에 서버측에서 제공할 수 없는 값은 제공해줄 수 없다.
		// 사용자 측에서 질의를 한 것. 웹에서 질의는 문서를 달라는 것 이라고 정리하자.
		
		//	int page = request.getParameter("p"); 
		// 입력 값은 무조건 문자열이므로 바로 int로 사용할 수는 없다.
		
		// 왜 p,q,s 이런 식으로 줄일까? 길이 제한이 있어서
		// 웹의 주소는 원래 천자 내외의 길이제한을 가지고 있어서 값을 줄일 수는 없으니 키워드라도 줄여보자~ 고 했던
		// 여담이지만 최근에는 제한이 없다는 말도 있습니다.
		
		String page = request.getParameter("p");
		String q = request.getParameter("q");
		String s = request.getParameter("s");
		// 그럼 요청하는 방법은?
		// /input?p=1
		
		PrintWriter out = response.getWriter();
//		out.println(page);
//		out.println(q);
//		out.println(s);
//		
				
		// 2. form을 이용한 입력
		// 사실 쿼리 스트링은 사용자가 전달하는 값이라기 보다 페이지를 제공하는 쪽에서 정해진 값을 선택하게 하는 방식입니다.
		// 예를 들어서 쿼리스트링은 사용자가 URL 창을 직접 편집하는 것이 아니라 다음처럼 링크에 있는 경우가 일반적입니다.
		// <a href="/input?p=2&q=hello&s=15">2</a>
		// <a href="/input?p=2&q=hello&s=15">1</a>
		// 위와 같이 이미 정해진 값들 중에 하나의 링크를 선택함으로써 입력을 요청하게 됩니다.
		// 반면에 사용자가 값을 직접 입력하게 하고 싶다면 어떻게 할까? 그 때는 form을 제공함으로써 입력을 하게 합니다.
		
		request.setAttribute("page", page);
		request.setAttribute("query", q);
		request.setAttribute("size", s);
		
		request.getHeader("referer");
		// 배열로 받아들임.
		String[] hbs = request.getParameterValues("hb");
		request.setAttribute("cnt", hbs.length);
		
		// 3. 쿠키 입력
		// 사용자 데이터를 저장하는 방법.
		
		// 3-1 세션
		// : 서버에 사용장 데이터를 저장하는 공간
		// 기간, 빌려서 사용된 시간. 1교시,2교시,1세션,2세션 
		// 웹은 오프라인 형태의 서비스. (요청과 응답 후에 연결이 끊긴다.)
		// 세션은 연결이 유지가 안될 때 사용하는 법.
		// 식별자를 두고 구별 (섹션 키), 식별자에 대한 유지기간이 필요함. => 섹션 기간 (너무 많이 쌓이면 과부화)
		// Section Timeout 전에, 보관될 캐비넷 : 세션 객체.
		// 기억할 이유가 없다면 세션 키 지급안함. 정적 컨텐츠 (ex. html)
		// 서버 서블릿,jsp 파일일 경우에 처음 접속 시에 세션 키 지급.
		// 지속 시간 : 30분.
		// 다시 요청이 들어오면 계속 갱신.
		// 브라우저 마다 다르게 인식. 서로 공유 안함.
		
		
		// 3-2 쿠키
		// : 클라이언트에 저장하는 사용자 데이터.
		// 서버에 두면 원하는 용량을 쓸 수 없음. 용량이 클 경우엔 서버에 부담.
		// 단점 : 사용자에게 의사를 물어보아야 함.
		// 임시 데이터를 디비에 담긴 좀 그럼. 적당한건 세션인데 서버가 싫어함. 
		// 클라이언트(브라우저)에 저장하게 함. 대신 물어봐야 함.
		// 원래는 브라우저 닫으면 사라짐. 대신 설정 통해서 지속 가능.
		// 장점 두가지
		// 브라우저를 닫아도 쿠키 지속 가능. 세션 키와 상관 없음.
		// 저장 지속 시간이 30분 이내이면 세션, 그 이상이면 쿠키.
		// 원하는 경로 내의 서블릿에서만 사용 가능.
		// 경로 설정을 해두지 않으면 해당 서블릿 이하인 서블릿에만 쿠키가 공유됨.
		
		// 쿠키를 불러오는 과정이 상당히 복잡. 지옥.
		// 대신 스프링으로 사용하면 천상을 맛봄. 대신 지옥맛봐야함.
				
		// 4. Header 입력
		
		
		// 5. hidden 필드 입력
		
		request
		.getRequestDispatcher("/WEB-INF/view/menu/input.jsp")
		.forward(request, response);

	}
}

