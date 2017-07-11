<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p{
		text-align: center;
	}
	#number{
		float: right;
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<jsp:include page="../../resources/top/simProjectTop.jsp"/>
		<p>프로젝트가 수정되었습니다.</p>
		<div id="number">
			<a href="content.do?number=${number}"><input type="submit" value="돌아가기"></a>
		</div>
	<jsp:include page="../../resources/footer/simProjectFooter.jsp"/>
</body>
</html>