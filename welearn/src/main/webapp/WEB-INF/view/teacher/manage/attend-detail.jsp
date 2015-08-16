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
     .nav-footer {
        padding: 0;
        text-align: left;
    }
    
    .nav-footer>.record {
        text-align: center;
    }
    
    .sub-header {
        text-align: center;
        font-size: 1.2em;
        line-height: 2em;
        background-color: aliceblue;
        position: fixed;
        width: 100%;
    }
    
    .sub-header>.header-item {
        width: 45%;
    }
    
    .sub-header>.header-item.selected {
        border-bottom: solid 2px #7d7df8;
    }
    
    .content {
        margin-top: 80px;
    }
    
    
    .record-item {
        width: 48%;
        border: 1px solid #7d7df8;
        margin-bottom: 3px;
    }
    
    .record-item>img {
        width: 100%;
    }
    
    .similarity {
        font-size: 1.5em;
        color: #ffb700;
        margin-right: 5px;
        margin-top: 10px;
    }
    
    .descript {
        line-height: 1.5em;
    }
    
    .oper {
        line-height: 2em;
    }
    
    .oper .oper-item {
        width: 48%;
        display: inline-block;
    }
    
    .pass {
        color: #fff;
        background-color: #35B531;
    }
    
    .not-pass {
        color: #fff;
        background-color: #d0cbcb;
    }
    
    
    .label.name,
    p.time {
        margin-left: 3px;
    }
    
    .pass-all {
        width: 100%;
        line-height: 3em;
        font-size: 1.3em;
    }
    
    .margin-center {
        margin-left: auto;
        margin-right: auto;
        width: 300px;
    }
    
    .color-span {
        width: 5px;
        height: 5px;
        margin-right: 5px;
    }
    
    .match-item {
        margin-left: 10px;
        display: inline-block;
        width: 45%;
    }
    
    .footer-item.statistics {
        margin: 10px;
    }  
   
</style>
</head>
<body>
<div class="main">
    <div class="header">
        <i class="glyph-icon icon-chevron-left float-left btn-back"></i>
        <p>签到任务详情</p>
    </div>
    <div class="sub-header">
        <div class="display-inline header-item selected" data="record">审核记录</div>
        <div class="display-inline header-item" data="statistics">情况统计</div>
    </div>
    <div class="content">
        <div class="record content-item">
            <div class="record-item display-inline">
                <img src="../img/attend-test-0031.jpg">
                <div class="descript">
                    <span class="similarity float-right">89%</span>
                    <div>
                        <span class="label bg-blue-alt name">12301124 李鹏翔</span>
                        <p class="time"><i class="glyph-icon icon-time font-gray "></i> 07-11 12:54:32</p>
                        <div class="oper text-center">
                            <div class="oper-item not-pass">不通过</div>
                            <div class="oper-item pass">通过</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="record-item display-inline">
                <img src="../img/attend-test-0031.jpg">
                <div class="descript">
                    <span class="similarity float-right">89%</span>
                    <div>
                        <span class="label bg-blue-alt name">12301124 李鹏翔</span>
                        <p class="time"><i class="glyph-icon icon-time font-gray "></i> 07-11 12:54:32</p>
                        <div class="oper text-center">
                            <div class="oper-item not-pass">不通过</div>
                            <div class="oper-item pass">通过</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="record-item display-inline">
                <img src="../img/attend-test-0031.jpg">
                <div class="descript">
                    <span class="similarity float-right">89%</span>
                    <div>
                        <span class="label bg-blue-alt name">12301124 李鹏翔</span>
                        <p class="time"><i class="glyph-icon icon-time font-gray "></i> 07-11 12:54:32</p>
                        <div class="oper text-center">
                            <div class="oper-item not-pass">不通过</div>
                            <div class="oper-item pass">通过</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="record-item display-inline">
                <img src="../img/attend-test-0031.jpg">
                <div class="descript">
                    <span class="similarity float-right">89%</span>
                    <div>
                        <span class="label bg-blue-alt name">12301124 李鹏翔</span>
                        <p class="time"><i class="glyph-icon icon-time font-gray "></i> 07-11 12:54:32</p>
                        <div class="oper text-center">
                            <div class="oper-item not-pass">不通过</div>
                            <div class="oper-item pass">通过</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="statistics content-item" style="display: none;margin-top: 100px;">
            <div class="attend-statistics margin-center"></div>
        </div>
    </div>
    
    <div class="nav-footer footer">
        <div class="record footer-item">
            <div class="pass pass-all">一键通过</div>
        </div>
        <div class="statistics footer-item"  style="display: none;">
            <div class="display-inline">
<!--                <span class="color-span"></span>-->
                <span class="match-item">
                    <i class="glyph-icon icon-stop" style="color: #D5D5D6;"></i> 未签到 <span class="label m0"></span>
                </span>
                <span class="match-item">
                    <i class="glyph-icon icon-stop" style="color: #ffb673;"></i> 准备签到 <span class="label m1"></span>
                </span>
                <span class="match-item">
                    <i class="glyph-icon icon-stop" style="color: #2381e9;"></i> 等待审核 <span class="label m2"></span>
                </span>
                <span class="match-item">
                    <i class="glyph-icon icon-stop" style="color: #ff7a00;"></i> 审核未通过 <span class="label m3"></span>
                </span>
                <span class="match-item">
                    <i class="glyph-icon icon-stop" style="color: #00c322;"></i> 审核通过 <span class="label m4"></span>
                </span>
            </div>
        </div>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/teacher/nav-mobile.jsp" %>
<script type="text/javascript">
$(function(){
    var num = 60;
    var rate = [1, 2, 2, 0, 55];
    for(var i in rate) {
        var tt = new Number((rate[i]/num*100).toString()).toFixed(2);
        $('.label.m'+i).html(rate[i] + "人 " + tt + "%");
    }
    
    $(".attend-statistics").sparkline(rate, {
        type: "pie",
        width: "300",
        height: "300",
        sliceColors: ["#D5D5D6", "#ffb673", "#2381e9", "#ff7a00", "#00c322"],
        offset: 0,
        borderWidth: 0,
        borderColor: "#000000"
    });
    
    
});

$(".sub-header>.header-item").click(function(){
    $(".sub-header>.header-item").removeClass("selected");
    $(this).addClass("selected");
    $(".content>.content-item").hide();
    $(".footer>.footer-item").hide();
    $("."+$(this).attr("data")).fadeIn();
    
});
</script>
</body>
</html>