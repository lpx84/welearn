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
    
    .content {
        font-size: 1.2em;
    }
    
    .inline-block {
        display: inline-block;
    }
    
    .rcd {
        margin: 3px 3px;
        padding: 5px 10px;
        border: solid 1px #c3c3c3;
        border-radius: 3px;
    }
    
    .lab {
        color: #c3c0c0;
    }
    
    .rows12 {
        font-size: 0.8em;
    }
    
    .name {
        font-weight: bold;
        line-height: 2em;
    }
    
    .rows1 {
        position: relative;
        margin-left: auto;
    }
    
    .i-toggle {
        position: absolute;
        top: 15px;
        right: 0px;
    }
    
    .rows.rows2.text {
        margin-top: 5px;
        margin-bottom: -5px;
        padding: 10px 5px;
        background: #fafafa;
    }
       
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray">
        <div class="glyph-icon icon-separator transparent back-btn">
            <i class="glyph-icon fa-chevron-left"></i>
        </div>
        <span class="title">软件工程专业研究方法论与创新教育</span>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="content">
        <div class="rcd">
            <div class="rows rows1">
                <div class="inline-block">
                    <!-- font-red表示消息未读 已读消息设为font-gray -->
                    <div class="rows rows11 name"><i class="glyph-icon font-red fa-bullhorn"></i>&nbsp;第一次作业</div>
                    <div class="rows rows12">
                        <span class="time ">
                            <span class="lab">发布：</span>
                            <span class="label bg-gray">07-11 12:43</span>
                        </span>
                        <span class="time ">
                            <span class="lab">截止：</span>
                            <span class="label bg-green">07-15 00:00</span>
                        </span>
                    </div>
                </div>
                <div class="inline-block i-toggle">
                    <i class="fa fa-chevron-right"></i>
                </div>
            </div>
            <div class="row rows rows2 text" style="display: none;">
                这是作业这是作业这是作业这是作业这是作业这是作业
            </div>
        </div>
        <div class="rcd">
            <div class="rows rows1">
                <div class="inline-block">
                    <div class="rows rows11 name"><i class="glyph-icon font-gray fa-bullhorn"></i>&nbsp;第一次作业</div>
                    <div class="rows rows12">
                        <span class="time ">
                            <span class="lab">发布：</span>
                            <span class="label bg-gray">07-11 12:43</span>
                        </span>
                        <span class="time ">
                            <span class="lab">截止：</span>
                            <span class="label bg-green">07-15 00:00</span>
                        </span>
                    </div>
                </div>
                <div class="inline-block i-toggle">
                    <i class="fa fa-chevron-right"></i>
                </div>
            </div>
            <div class="row rows rows2 text" style="display: none;">
                这是作业这是作业这是作业这是作业这是作业这是作业
            </div>
        </div>
    </div>
    
    <!-- 当前页号，下一次请求在此基础上加1 -->
    <input id="pageNo" type="hidden" value="1">
    <a href="javascript:fetchData();" class="btn btn-more medium display-block float-none ui-state-default">
        <span class="button-content">查看更多</span>
    </a>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
$(".text-toggle").click(function(){
    if($(this).hasClass("fa-angle-double-down")) {
        $(".large-text").removeClass("limit-text");
        $(this).removeClass("fa-angle-double-down");            
        $(this).addClass("fa-angle-double-up");            
    } else {
        $(".large-text").addClass("limit-text");
        $(this).removeClass("fa-angle-double-up");            
        $(this).addClass("fa-angle-double-down");
    }
});

$(".rows.rows1").click(function(){
    $(this).siblings(".rows.text").slideToggle();
    var $i = $(this).children(".i-toggle").children("i.fa");
    if($i.hasClass("fa-chevron-right")) {
        $i.removeClass("fa-chevron-right");
        $i.addClass("fa-chevron-down");
    } else {
        $i.removeClass("fa-chevron-down");
        $i.addClass("fa-chevron-right");
    }
});

//如果页面内容高度小于屏幕高度，div#footer将绝对定位到屏幕底部，否则div#footer保留它的正常静态定位
if (($(document.body).height() + 10) < $(window).height()) {
    $(".btn-more").addClass("fixed-bottom");
};
</script>
</body>
</html>