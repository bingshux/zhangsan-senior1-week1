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
	<form id="form1">
	<input type="hidden" name="gid" value="${g.gid }">
	
		<table>
			<tr>
				<td>商品名称:</td>
				<td><input type="text" name="gname" value="${g.gname }"/></td>
			</tr>
			<tr>
				<td>英文名称:</td>
				<td><input type="text" name="ename" value="${g.ename }"/></td>
			</tr>
			<tr>
				<td>商品品牌:</td>
				<td>
					<select name="bid" id="bid">
					
					</select>
				</td>
			</tr>
				<tr>
				<td>商品种类:</td>
				<td>
					<select name="kid" id="kid">
					
					</select>
				</td>
			</tr>
			<tr>
				<td>商品尺寸:</td>
				<td><input type="text" name="size"  value="${g.size }"/></td>
			</tr>
			<tr>
				<td>商品单价:</td>
				<td><input type="text" name="price"  value="${g.price}"/></td>
			</tr>
			<tr>
				<td>商品数量:</td>
				<td><input type="text" name="num"  value="${g.num }" /></td>
			</tr>
			<tr>
				<td>商品标签:</td>
				<td><input type="text" name="tab"  value="${g.tab }"/></td>
			</tr>
			<tr>
				
				<td>商品图片上传</td>
				<td>
				<input type="hidden" name="pic" value="${g.pic }">
					<input type="file" name="file"/>
				</td>
			</tr>
			<tr>
				<td colspan="100">
					<input type="button" value="修改"  onclick="update()" />
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
	$(function(){
		$.post(
			"/selectBrands"	,
			function(msg){
				for ( var i in msg) {
					$("#bid").append("<option value='"+msg[i].bid+"'>"+msg[i].bname+"</option>")
					var bid=${g.bid};
					if(bid==msg[i].bid){
						$("option[value='"+msg[i].bid+"']").attr("selected" ,true);
					}
				}
				
				
			}
		)
			$.post(
			"/selectGoodskinds"	,
			function(msg){
				for ( var i in msg) {
					$("#kid").append("<option value='"+msg[i].kid+"'>"+msg[i].kname+"</option>")
					var kid=${g.kid};
					if(kid==msg[i].kid){
						$("option[value='"+msg[i].kid+"']").attr("selected" ,true);
					}
				}
			}
		)
		
	})
		function update(){
			var formData = new FormData($("#form1")[0]);
			$.ajax({
				type:"post",
				url:"/update",
				data:formData,
				processData: false,
				contentType:false,
				success: function(flag){
					if(flag){
						alert("修改成功")
						location.href="/selectGoods";
					}else{
						alert("修改失败")
						
					}
				}
			});
		}
	</script>
</body>
</html>