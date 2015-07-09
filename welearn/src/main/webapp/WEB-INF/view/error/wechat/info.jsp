<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</body>
</html>