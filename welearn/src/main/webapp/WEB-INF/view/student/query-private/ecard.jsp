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
   
    .btn-more .button-content {
        font-size: 1.3em;
        line-height: 2em;
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
        border: none;
    }
    
    .test-new,
    .lab {
        margin: 10px 5px;
    }
    
    .lab {
        font-size: 1.4em;
        border-bottom: 1px solid #e7e7e7;
    }
    
    .content {
        margin: 10px;
    }
    
    .option .text {
        word-wrap: break-word;
        word-break: break-all;
    }
    
    .btn-submit {
        margin: 10px 5px;
    }
    
    .rcd .row:nth-child(even) {
        background-color: #e7e7e7;
    }
    
    .row {
        line-height: 3em;
    }   
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray">
        <div class="glyph-icon icon-separator transparent">
            <i class="glyph-icon"></i>
        </div>
        <span class="title">一卡通查询</span>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="content">
        <div class="info">
            <div class="row">
                <div class="col-xs-5 text-right">姓名：</div>
                <div class="col-xs-4">${ecard.getName() }</div>
            </div>
            <div class="row">
                <div class="col-xs-5 text-right">卡状态：</div>
                <div class="col-xs-6">${ecard.getState() }</div>
            </div>
            <div class="row">
                <div class="col-xs-5 text-right">专用钱包余额：</div>
                <div class="col-xs-6"><span class="font-red font-size-20">${ecard.getSpecialWallet() }</span> 元</div>
            </div>
            <div class="row">
                <div class="col-xs-5 text-right">主钱包余额：</div>
                <div class="col-xs-6"><span class="font-red font-size-20">${ecard.getWallet() }</span> 元</div>
            </div>
            <div class="row">
                <div class="col-xs-5 text-right">补助余额：</div>
                <div class="col-xs-6"><span class="font-red font-size-20">${ecard.getAllowance() }</span> 元</div>
            </div>
        </div>
        
        <a href="ecard-detail" class="btn btn-more display-block large float-none bg-blue mrg20T">
            <span class="button-content">查询消费记录</span>
        </a>
        
    </div>
    
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>