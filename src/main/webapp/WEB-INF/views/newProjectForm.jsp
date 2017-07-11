<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../../resources/js/common.js"></script>
<script>
	$(function(){
		var dateCheck = /^[0-9]{4}-([0]{1}[1-9]{1})|([1]{1}[0-2]{1})-([0-2]{1}[0-9]{1})|([3]{1}[0-1]{1})$/;
		
		$("#cancel").click(function() {
			location.href="listAll";
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
		<form name='f1' action="newProject" method="post">
			<p>
				<label>프로젝트 이름</label><input type="text" name="name">
				<span class="error">프로젝트 이름을 입력하세요</span>
			</p>
			<p>
				<label>프로젝트 내용</label><textarea rows="13" cols="50" name="content"></textarea>
				<span class="error">프로젝트 내용을 입력하세요</span>
			</p>
			<p>
				<label>시작날짜</label><input type="text" name="startDate" placeholder="yyyy-MM-dd">
				<span class="error">시작날짜를 입력하세요</span>
			</p>
			<p>
				<label>마감날짜</label><input type="text" name="endDate" placeholder="yyyy-MM-dd">
				<span class="error">마감날짜를 입력하세요</span>
			</p>
			<p>
				<label>상태 :</label><select id="state" name="state">
					<option selected="selected">준비</option>
					<option>진행중</option>
					<option>종료</option>
					<option>보류</option>
				</select>
			</p>
			<p>
				<input type="submit" value="저장">
				<input type="reset" value="취소" id="cancel">
			</p>
		</form>
	<jsp:include page="../../resources/footer/simProjectFooter.jsp"/>
</body>
</html>