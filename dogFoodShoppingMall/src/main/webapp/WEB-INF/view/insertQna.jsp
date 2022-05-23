<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>insert Q&A</title>
</head>
<body class = "container">
	<div class="container p-3 my-3 bg-success text-white">
		<h2 align="center">질문 작성</h2>
	</div>
	<div class="container pt-3">
	<form method="post" action="${pageContext.request.contextPath}/insertQnaController">
		<input type="hidden" name="productId" value="${productId}">
		<input type="hidden" name="memberId" value="${memberId}" >
			<table class="table table-bordered">
				<tr>
					<td>종류</td>
					<td>
					<select name="qnaKind">
						<option value="">:: 유형을 선택해 주세요. ::</option>
						<option value="질문">질문</option>
						<option value="답변">답변</option>
					</select>
					</td>
				</tr>		
				<tr>
					<td>질문내용</td>
					<td><input type="text" name="memo"></td>
				</tr>	
			</table>
			<button type="submit" class="btn btn-outline-success btn-sm" >질문 등록</button>
		</form>
	</div>
</body>
</html>