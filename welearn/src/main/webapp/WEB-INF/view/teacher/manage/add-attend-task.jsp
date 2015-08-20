<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/teacher/header-mobile.jsp" %>
<title>${title }</title>
<style type="text/css">
    .main {
        
    }
    
    .img img {
        width: 100%;
    }
    
    .input-item {
        background-color: #fff;
        color: #000;
        margin: auto 0;
        padding: 10px;
        font-size: 1.2em;
        line-height: 2em;
        border: none;
    }
    
    input.submit {
        margin: 20px 2%;
        font-size: 1.5em;
        line-height: 2em !important;
        border: none;
        width: 96%;
        border-radius: 3px;
    }
   
</style>
</head>
<body>
<div class="main">
    <div class="header">
        <i class="glyph-icon icon-chevron-left float-left btn-back"></i>
        <p>发布签到任务</p>
    </div>
    <div class="content">
        <form action="add-attend-task.act" method="post">
            <input id="name" name="name" class="input-item mrg10T " type="text" placeholder="签到名称">
            <input id="startTime" name="startTime" class="input-item mrg10T " type="text" placeholder="开始时间" data-date-format="yyyy-mm-dd hh:ii" readonly>
            <input id="endTime" name="endTime" class="input-item mrg10T " type="text" placeholder="结束时间" data-date-format="yyyy-mm-dd hh:ii" readonly>

            <input type="submit" class="submit bg-blue" value="发布"></input>
        </form>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/public/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">
$("#startTime").datetimepicker({
    autoclose: true
});
$("#endTime").datetimepicker({
    autoclose: true
});
</script>
</body>
</html>