<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>insert Review</title>
</head>
<body class = "container">
	<div class="container p-3 my-3 bg-success text-white">
		<h2 align="center">리뷰 작성</h2>
	</div>
	<div class="container pt-3">
	<form method="post" action="${pageContext.request.contextPath}/loginCheck//insertReviewController">
		<table class="table table-bordered">
				<input type="hidden" name="purchaseId" value="${purchaseId}">
				<input type="hidden" name="productId" value="${productId}">
			<tr>
				<td>리뷰사진</td>
				<td><input type="file" name="reviewPhoto">
			</tr>		
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>	
			<tr>
				<td>내용</td>
				<td><input type="text" name="reviewContent"></td>
			</tr>	
			<tr>
				<td>평점</td>
				<td>
				<select name="star">
					<option value="">:: 평점을 선택해주세요 ::</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				</td>
			</tr>	
		</table>
		<button type="submit" class="btn btn-outline-success btn-sm" >리뷰 등록</button>
	</form>
	</div>
</body>
</html>