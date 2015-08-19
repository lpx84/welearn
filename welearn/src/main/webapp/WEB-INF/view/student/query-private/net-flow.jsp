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
    
    .row {
        margin-left: 0;
        margin-right: 0;
        font-size: 1.3em;
        width: 100%;
        padding: 10px;
    }
    
    .content .row:nth-child(even) {
        background-color: #F7F7F7;
    }
    
    .flag {
        color: #ff5800;
        font-weight: bold;
    }
   
</style>
</head>
<body>
<div class="main ">
	<div class="header">
		<i class="glyph-icon icon-chevron-left float-left btn-back"></i>
        <p>本月流量</p>
    </div>
    <div class="content">
        <div class="row">
            <div class="col-xs-4 col-sm-4">账户余额</div>
            <div class="col-xs-8 col-sm-8"><label class="flag">${netFlow.getBalance() }</label> 元</div>
        </div>
        <div class="row">
            <div class="col-xs-4 col-sm-4">本月时长</div>
            <div class="col-xs-8 col-sm-8">${netFlow.getTime() } 分钟</div>
        </div>
        <div class="row">
            <div class="col-xs-4 col-sm-4">本月流量</div>
            <div class="col-xs-8 col-sm-8">${netFlow.getFlow() } MB</div>
        </div>
        <div class="row">
            <div class="col-xs-4 col-sm-4">剩余流量</div>
            <div class="col-xs-8 col-sm-8"><label class="flag">${netFlow.getRestFlow() }</label> MB</div>
        </div>
        <div class="row">
            <div class="col-xs-4 col-sm-4">超出费用</div>
            <div class="col-xs-8 col-sm-8">${netFlow.getExtraFee() } 元</div>
        </div>
        
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>