<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td, th{
		border-spacing: 0px;
		border:1px solid black;
		border-collapse:collapse;
		text-align: center;
	}
	table{
		margin:0 auto;
		clear: both;
	}
	#th_name{
		width:200px;
	}
	#th_startDate{
		width: 150px;
	}
	#th_endDate{
		width:150px;
	}
	#th_state{
		width:80px;
	}
	#new_project{
		float: right;
		text-decoration: none;
		margin-bottom: 10px;
	}
	#new_project:HOVER{
		text-decoration: underline;
	}
	#number{
		text-decoration: none;
	}
	#number:HOVER{
		text-decoration: underline;
	}
</style>
</head>
<body>
	<jsp:include page="../../resources/top/simProjectTop.jsp"/>
		<a href="newProject" id="new_project">[새 프로젝트 등록]</a>
		<table>
			<tr>
				<th id="th_name">프로젝트 이름</th>
				<th id="th_startDate">시작날짜</th>
				<th id="th_endDate">종료날짜</th>
				<th id="th_state">상태</th>
			</tr>
			<c:forEach var="viewSimProjectList" items="${viewSimProjectList}">
				<tr>
					<td><a href="content?number=${viewSimProjectList.number}" id="number">${viewSimProjectList.name }</a></td>
					<td>${viewSimProjectList.resultStartDate }</td>
					<td>${viewSimProjectList.resultEndDate }</td>
					<td>${viewSimProjectList.state }</td>
				</tr>
			</c:forEach>
		</table>
	<jsp:include page="../../resources/footer/simProjectFooter.jsp"/>
</body>
</html>