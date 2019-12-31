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
<style type="text/css">
img{
	height: 220px;
	width: 150px;
	
}
</style>
</head>
<body>
	
	<form action="/selectGoods" method="post">
		<p>
		商品名称:<input type="text" name="gname" value="${g.gname }"/>
			<input type="submit" value="查询"/>
			<a href="/add"><input type="button" value="添加"/></a>
			<input type="button" value="批量删除" onclick="ps()"/>
		</p>
		<c:forEach items="${info.list }" var="list">
			<div style="float: left ;margin-left: 50px;" align="center">
		
				<img alt="" src="${list.pic }"   ><br><br>
			<font color="blue">	商品名称:${list.gname } &nbsp;&nbsp; 英文名称:${list.ename }<br>
				商品品牌:${list.bname } &nbsp;&nbsp; 商品种类:${list.kname }<br>
				商品尺寸:${list.size } &nbsp;&nbsp;单价:${list.price }<br> 
				数量:${list.num }&nbsp;&nbsp; 标签:${list.tab }</font>
				<input type="button" value="详情" onclick="xq(${list.gid})"/>
				<input type="checkbox" name="gids" value="${list.gid }" />
				<input type="button" value="删除" onclick="delOne(${list.gid})"/>
				<input type="button" value="编辑" onclick="toUpdate(${list.gid})"/>
				 
			</div>
		</c:forEach>
		<div style="clear: both" align="center">
			<button  name="pageNum" value="1">首页</button>
			<button  name="pageNum" value="${info.prePage==0?1:info.prePage }">上一页</button>
			<button  name="pageNum" value="${info.nextPage==0?info.pages:info.nextPage }">下一页</button>
			<button  name="pageNum" value="${info.pages }">尾页</button>
			当前页/总页数:${info.pageNum }/${info.pages }     共${info.total }条数据
		</div>
	</form>
	<script type="text/javascript">
		function xq(gid){
			location="/xiangqing?gid="+gid;
		}
		function delOne(gid){
			
			if(confirm("你确认要删除选中的数据吗?")){
				$.post(
						"/delOne",
						{gid:gid},
						function(msg){
							if(msg){
								alert("删除成功");
								location="/selectGoods";
							}else{
								alert("删除失败");
							}
						}
					)
			}
			
		}
		function ps(){
			var gid=$("[name=gids]:checked").map(function() {
				return this.value;
			}).get().join();
			//alert(gid)
			if(confirm("你确定删除所选中的数据吗?")){
				$.post(
						"/delAll",
						{gid:gid},
						function(msg){
							if(msg){
								alert("删除成功");
								location="/selectGoods";
							}else{
								alert("删除失败");
							}
						}
					)
			}
			
		}
		function toUpdate(gid){
			location="/toUpdate?gid="+gid;
			
		}
	</script>
</body>
</html>