<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form method="post" action="${pageContext.request.contextPath}/ProductSearchController">
      <table border="1">
         <tr>
            <td>연령</td>
            <td>
               <input type="radio" name="age" value="" checked="checked">선택안함
               <input type="radio" name="age" value="puppy" >퍼피
               <input type="radio" name="age" value="adult" >어덜트
               <input type="radio" name="age" value="senior" >시니어   
            </td>
         </tr>
         <tr>
            <td>알러지</td>
            <td>
               <select name="component">
                  <option value="">선택없음</option>
                  <c:forEach var="c" items="${componentList}">
	                  <option value="${c.componentId}">${c.name}</option>
	              </c:forEach>
               </select>
            </td>
         </tr>
         <tr>
            <td>사료타입</td>
            <td>
               <select name="feedType">
                  <option value="" checked="checked">선택없음</option>
                  <option value="dry">건식사료</option>
                  <option value="wet">습식사료</option>
                  <option value="soft">소프트사료</option>
               </select>
            </td>
         </tr>
         <tr>
            <td>알갱이 크기</td>
            <td>
               <select name="size">
                  <option value="" checked="checked">선택없음</option>
                  <option value="small">소</option>
                  <option value="medium">중</option>
                  <option value="big">대</option>
               </select>
            </td>
         </tr>
      </table>
      <button type="submit">검색</button>
   </form>
   
</body>
</html>