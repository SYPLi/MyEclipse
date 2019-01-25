<%@ page language="java" import="java.util.*,com.beans.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.img,.video{
			float left;
		}
		.imgs,.videos{
			width:200px;
			height: 150px;
		}
		img,video{
			width:100%;
			width:100%;
		}
		.btn{
			width: 200px;
			height:40px;
		}
	</style>
  </head>
  
  <body>
    <c:choose>
    	<c:when test="${status==1 }">
    		<c:forEach var="goodsInfo" items="${goodsInfos }">
    			<div class="img">
    				<div class="imgs"><img src="http://100.100.255.254:8080/Bos/${goodsInfo.goodsUrl }"/></div>
    				<div class="btn"><a href="http://100.100.255.254:8080/Bos/${goodsInfo.goodsUrl }">下载</a></div>
    			</div>
    		</c:forEach>
    	</c:when>
    	<c:otherwise>
    		<c:forEach var="goodsInfo" items="${goodsInfos }">
    			<div class="video">
    				<div class="videos"><video src="http://100.100.255.254:8080/Bos/${goodsInfo.goodsUrl }" /></div>
    				<div class="btn"><a href="http://100.100.255.254:8080/Bos/${goodsInfo.goodsUrl }">下载</a></div>
    			</div>
    		</c:forEach>
    	</c:otherwise>
    </c:choose>
  </body>
</html>
