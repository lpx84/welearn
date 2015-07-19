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
   
       .title {
          text-align: center;
    }
    
    .content {
        margin-bottom: 5px;   
    }
    
    .rcd {
        padding: 5px 10px;
        border-bottom: 1px solid #d9d9d9;
    }
    
    .status {
        font-weight: bold;
        float: right;
    }
    
    .img-avatar {
        width: 50px;
        height: 50px;
        margin-right: 10px;
    }
    
    .inline-block {
        display: inline-block;
    }
    
    .rcd>div {
        vertical-align: top;
        margin-top: 10px;
    }
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray text-center">
    	<div class="glyph-icon icon-separator transparent back-btn">
            <i class="glyph-icon fa-chevron-left"></i>
        </div>
        <label class="pad0L title">${courseName}——签到记录</label>
    </h3>
    <div class="content">
    <c:forEach var="item" items="${list }">
        <div class="rcd">
            <img class="img-avatar inline-block" src="${item.getPicUrl() }">
            <div class="inline-block">
                <div class="font-bold">${item.getContent() }</div>
                <div><span class="font-gray ">签到于</span> ${item.getTime() }</div>
            </div>
            <c:if test="${item.getState() ==  0}">
                <div class="status inline-block font-gray"><i class="fa fa-close"></i>&nbsp;未签到</div>
            </c:if>              
            <c:if test="${item.getState() == 1 }">
                <div class="status inline-block font-red"><i class="fa fa-clock-o"></i>&nbsp;等待签到</div>
            </c:if>
            <c:if test="${item.getState() ==  2}">
                <div class="status inline-block font-red"><i class="fa fa-clock-o"></i>&nbsp;审核中</div>
            </c:if>
            <c:if test="${item.getState() ==  3}">
                <div class="status inline-block font-green"><i class="fa fa-check-circle"></i>&nbsp;成功</div>
            </c:if>            
            <c:if test="${item.getState() == 4 }">
                <div class="status inline-block font-gray"><i class="fa fa-close"></i>&nbsp;照片审核未通过</div>
            </c:if>                   
        </div>
    </c:forEach> 
    </div>
    
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>