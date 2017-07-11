<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function(){
		$("#del").click(function(e){
			e.preventDefault();
			var del = confirm("정말 게시글을 삭제하시겠습니까?");
			var number = ${byNo.number };
			if(del == true){
				location.href = "delete?number=" + number;
			}
		})
	});
</script>
<style>
	#container{
		margin:0 auto;
		width: 900px;
		height: 730px;
		overflow: hidden;
	}
	#top{
		width: 100%;
		padding: 15px 0 15px 10px;
		margin-bottom: 20px;
		background: green;
		color:white;
	}
	footer{
		width: 100%;
		padding: 5px 0 5px 0;
		margin-top: 20px;
		background: green;
		color:white;
		text-align: center;
	}
	table, td, th{
		border-spacing: 0px;
		border:1px solid black;
		border-collapse:collapse;
		text-align: center;
		margin:0 auto;
	}
	td{
		width:600px;
		text-align:left;
		margin-left: 10px;
	}
	th{
		width:200px;
	}
	a, form{
		display:inline;
		margin-left: 20px;
	}
	#button{
		width:250px;
		margin:0 auto;
		margin-top:20px;
	}
</style>
</head>
<body>
	<jsp:include page="../../resources/top/simProjectTop.jsp"/>
		<table>
			<tr>
				<th>프로젝트 이름</th>
				<td>${byNo.name }</td>
			</tr>
			<tr>
				<th>프로젝트 내용</th>
				<td>${byNo.content }</td>
			</tr>
			<tr>
				<th>시작날짜</th>
				<td>${byNo.resultStartDate }</td>
			</tr>
			<tr>
				<th>종료날짜</th>
				<td>${byNo.resultEndDate }</td>
			</tr>
			<tr>
				<th>상태</th>
				<td>${byNo.state }</td>
			</tr>
		</table>
		<div id="button">
			<a href="modify?number=${byNo.number }&name=${byNo.name }&content=${byNo.content }
			&startDate=${byNo.resultStartDate }&endDate=${byNo.resultEndDate }&state=${byNo.state }">
			<input type="submit" value="수정"></a>
			<a href="#" id="del"><input type="submit" value="삭제"></a>
			<form action="listAll" method="get"><input type="submit" value="돌아가기"></form>
		</div>
	<jsp:include page="../../resources/footer/simProjectFooter.jsp"/>
</body>
</html>