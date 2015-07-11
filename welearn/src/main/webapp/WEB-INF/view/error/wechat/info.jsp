<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/home/header.jsp" %>
<title>${title }</title>
<style type="text/css">
    body {
        text-align: center;
        padding: 20px;
    }
    
    .logo {
        margin-top: 30%;
        font-size: 7em;
    }
    
    .info {
        font-size: 1.2em;
        color: #6E6868;
    }
</style>
</head>
<body>
<div class="logo">
    <i class="glyph-icon icon-info"></i>
</div>
<div class="info">
    <p>${info }</p>
    <p>点击<a href="javascript:history.back();" style="color:#225FFF;">返回</a></p>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>