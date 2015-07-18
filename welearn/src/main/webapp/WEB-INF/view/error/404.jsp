<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <c:choose>
    <c:when test="${title != null }">
    <title>${title }</title>
    </c:when>
	<c:otherwise>
	<title>页面找不到</title>
	</c:otherwise>
	</c:choose>
	<style type="text/css">
	.tips {
		text-align: center;
		padding:10px;
		color: #999;
	}
	
	.footer {
		text-align: right;
		padding: 0px 10px;
	}
	
	@media screen and (max-width: 1080px) {
		.tips {margin-top:10%; }
		.tips img {width: 100%; }
	}
	</style>
</head>
<body>
	<div class="tips">
		<img src="<%=request.getContextPath() %>/public/img/404.png">
		<h4>请确认地址是否正确！</h4>
	</div>
	<hr>
	
</body>
</html>