<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 引入 css -->
<link rel="stylesheet" type="text/css" 
href="resources/bootstrap.css">
<LINK href="resources/css/css.css" type="text/css" rel="stylesheet">
<!-- 引入js -->
<script type="text/javascript" src="resources/jquery-3.2.1.js"></script>
</head>
<body>

		<c:forEach items="${list }" var="list">
			<div style="float: left ;margin-left: 50px;" align="center">
		
				<img alt="" src="${list.pic }"   ><br><br>
			<font color="blue">	商品名称:${list.gname } &nbsp;&nbsp; 英文名称:${list.ename }<br>
				商品品牌:${list.bname } &nbsp;&nbsp; 商品种类:${list.kname }<br>
				商品尺寸:${list.size } &nbsp;&nbsp;单价:${list.price }<br> 
				数量:${list.num }&nbsp;&nbsp; 标签:${list.tab }</font>
				<a href="/xiangqing"><input type="button" value="详情"/></a>
				
			</div>
		</c:forEach>
		
</body>
</html>