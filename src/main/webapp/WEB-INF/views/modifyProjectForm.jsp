<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function(){
		var dateCheck = /^[0-9]{4}-([0]{1}[1-9]{1})|([1]{1}[0-2]{1})-([0-2]{1}[0-9]{1})|([3]{1}[0-1]{1})$/;
		
		$("#cancel").click(function() {
			location.href = "content?number="+${sim.number};
		});
		
		$("form[name='f1']").submit(function(){
			$(".error").css("display","none");
				
			if(checkInputEmpty($("input[name]")) == false || 
					checkInputEmpty($("textarea[name]")) == false){
				return false;
			}
			if(dateCheck.test($("input[name='startDate']").val()) == false ||
					dateCheck.test($("input[name='endDate']").val()) == false ||
					$("input[name='startDate']").val().length>10 ||
					$("input[name='endDate']").val().length>10){
				alert("날짜 입력양식이 맞지않습니다. (yyyy-MM-dd 년:y, 월:M, 일:d)");
				return false;
			}
			
		});
		
		function checkInputEmpty($obj){
			var count = 0;
			// i : index
			// element : object
			$obj.each(function(i, element) {
				if( $(element).val() == ""){
					var $next = $(element).next(".error");
					$next.css("display","block");
					count++;
				}
			})
			
			if(count > 0)
				return false;
			
			return true;
		}
	});
</script>
<style>
	form{
		width:600px;
		margin:0 auto;
		border: 1px solid gray;
	}
	form p:LAST-CHILD {
		text-align: center;
	}
	label{
		padding-right:50px;
		padding-left: 10px;
		height:20px;
		font-size: 12px;
		font-weight: bold;
		float: left;
	}
	p:FIRST-CHILD{
		margin-bottom: 10px;
	}
	.error{
		color:red;
		display:none;
		font-size: 12px;
		margin-left:140px;
	}	
</style>
</head>
<body>
	<jsp:include page="../../resources/top/simProjectTop.jsp"/>
		<form name='f1' action="modify" method="post">
			<input type="hidden" name="number" value="${sim.number }">
			<p>
				<label>프로젝트 이름</label><input type="text" name="name" value="${sim.name }">
				<span class="error">프로젝트 이름을 입력하세요</span>
			</p>
			<p>
				<label>프로젝트 내용</label><textarea rows="13" cols="50" name="content">${sim.content }</textarea>
				<span class="error">프로젝트 내용을 입력하세요</span>
			</p>
			<p>
				<label>시작날짜</label><input type="text" name="startDate" value="${startDate }" placeholder="yyyy-MM-dd">
				<span class="error">시작날짜를 입력하세요</span>
			</p>
			<p>
				<label>마감날짜</label><input type="text" name="endDate" value="${endDate }" placeholder="yyyy-MM-dd">
				<span class="error">마감날짜를 입력하세요</span>
			</p>
			<p>
				<label>상태 :</label><select id="state" name="state">
					<c:if test="${sim.state == '준비' }"><option selected="selected">준비</option></c:if>
					<c:if test="${sim.state != '준비' }"><option>준비</option></c:if>
					<c:if test="${sim.state == '진행중' }"><option selected="selected">진행중</option></c:if>
					<c:if test="${sim.state != '진행중' }"><option>진행중</option></c:if>
					<c:if test="${sim.state == '종료' }"><option selected="selected">종료</option></c:if>
					<c:if test="${sim.state != '종료' }"><option>종료</option></c:if>
					<c:if test="${sim.state == '보류' }"><option selected="selected">보류</option></c:if>
					<c:if test="${sim.state != '보류' }"><option>보류</option></c:if>
				</select>
			</p>
			<p>
				<input type="submit" value="수정">
				<input type="reset" value="취소" id="cancel">
			</p>
		</form>
	<jsp:include page="../../resources/footer/simProjectFooter.jsp"/>
</body>
</html>