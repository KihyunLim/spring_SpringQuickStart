<%@ page contentType="text/html; charset=EUC-KR"%>

<%
	// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
	session.invalidate();
	
	// 2. 화면 네비게이션
	response.sendRedirect("login.jsp");
%>