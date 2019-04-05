<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/resources/lib/jquery-3.3.1.js"/>"></script>

<title><spring:message code="message.board.list.mainTitle"/></title>
</head>
<body>

<center>
	<h1><spring:message code="message.board.list.mainTitle"/></h1>
	<h3>${userName }<spring:message code="message.board.list.welcomeMsg"/><a href="logout.do">Log-out</a></h3>
	
	<!-- 검색 시작 -->
	<form action="getBoardList.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td align="right">
					<select name="searchCondition">
						<c:if test="${searchInfo.searchCondition eq 'CONTENT' }">
						<option value="TITLE">제목</option>
						<option value="CONTENT" selected>내용</option>
						</c:if>
						<c:if test="${searchInfo.searchCondition ne 'CONTENT' }">
						<option value="TITLE" selected>제목</option>
						<option value="CONTENT">내용</option>
						</c:if>
					<!-- 굳이 동적으로 표현할 필요없어보여 주석 처리 -->
					<%-- <c:forEach items="${conditionMap }" var="option">
						<option value="${option.value }">${option.key }</option>
					</c:forEach> --%>
					</select>
					
					<c:choose>
						<c:when test="${searchInfo.searchKeyword ne '' }">
						<input name="searchKeyword" id="asd" type="text" value="${searchInfo.searchKeyword }" />
						</c:when>
						
						<c:otherwise>
						<input name="searchKeyword" id="asd" type="text" />
						</c:otherwise>
					</c:choose>
					
					<!-- <input name="searchKeyword" type="text" /> -->
					<input type="submit" id="btnSearch" value="<spring:message code="message.board.list.search.condition.btn"/>" />
				</td>
			</tr>
		</table>
	</form>
	<!-- 검색 종료 -->
	
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq"/></th>
			<th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title"/></th>
			<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer"/></th>
			<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate"/></th>
			<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt"/></th>
		</tr>
		
		<c:forEach items="${boardList }" var="board">
		<tr>
			<td>${board.seq }</td>
			<td align="left"><a href="getBoard.do?seq=${board.seq }&page=${searchInfo.curPage}&searchCondition=${searchInfo.searchCondition}&searchKeyword=${searchInfo.searchKeyword}">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.regDate }</td>
			<td>${board.cnt }</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5" align="center">
				<c:if test="${pageMaker.prev }">
					<a href="getBoardList.do${pageMaker.makeQuery(pageMaker.startPage - 1) }">이전</a>
				</c:if>
			
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="page">
				<c:if test="${page eq searchInfo.curPage }">
				[${page }]
				</c:if>
				<c:if test="${page ne searchInfo.curPage }">
				<a href="getBoardList.do?page=${page }&searchCondition=${searchInfo.searchCondition}&searchKeyword=${searchInfo.searchKeyword}">[${page }]</a>
				</c:if>
				</c:forEach>
				
				<c:if test="${pageMaker.next }">
					<a href="getBoardList.do${pageMaker.makeQuery(pageMaker.endPage + 1) }">다음</a>
				</c:if>
			</td>
		</tr>
	</table>
	<br>
	<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
</center>


<script>
	console.log("HI");
	$("#btnSearch").click(function(e){
		e.preventDefault();

		alert($("#asd").val());
	});
</script>

</body>
</html>