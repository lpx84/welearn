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
   
    .btn-more {
        width: 100%;
        padding: 5px 0;
    }
    
    .btn-more .button-content {
        font-size: 1.3em;
        width: 100%;
        text-align: center;
        padding: 0 !important;
    }
    
    
    .fixed-bottom {
        position: fixed !important;
        bottom: 0;
        width: 100%;
    }
    
    .title {
        display: inline-block;
        text-align: center;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        width: 72%;
    }
    
    .content-box {
        width: 100%;
        border: none;
    }
    
    .panel {
        box-shadow: 1px 5px 5px #D2D2D2;
        margin-top: 30% !important;
        border: solid 1px #D2D2D2;
    }   
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray text-center">
        <div class="glyph-icon icon-separator transparent" onclick="javascript: location.href='course-test'">
            <i class="glyph-icon fa-chevron-left"></i>
        </div>
        <label class="title">${courseName }</label>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="content">
        <div class="panel mrg10A pad10A">
            <div class="mrg10A">
                <span class="lab font-gray">您的得分：</span>
                <span class="font-size-20 font-red">${score }</span>
            </div>
            <div class="mrg10A">
                <span class="lab font-gray">系统评价：</span>
                <span class="font-size-15">看来你学的还是不够好啊，继续努力！</span>
                
            </div>
        </div>
        <a href="course-test-detail" class="btn btn-detail btn large display-block float-none bg-blue mrg5A">
            <span class="button-content">查看详请</span>
        </a>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>