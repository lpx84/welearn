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
   .content-item {
        background: none;
        padding: 0;
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
    
    .list-item {
        background-color: #fff;
        padding: 5px 10px;
        margin-bottom: 5px;
        line-height: 2.5em;
        font-size: 1.1em;
    }
    
    .list-item>.item-name {
        width: 70%;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }   
   
</style>
</head>
<body>
<div class="main">
    <div class="header">
        <i class="glyph-icon icon-chevron-left float-left btn-back"></i>
        <p>学校动态</p>
    </div>
    <div class="sub-header">
        <div class="display-inline header-item selected" data="notify">教务通知</div>
        <div class="display-inline header-item" data="news">新闻动态</div>
    </div>
    <div class="content">
        <div class="notify content-item">
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">关于2015-2016-1学期公共基础课重修班上课时间地点的通知</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 08-07
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">补考安排已经发布</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 08-01
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">双培计划学生登录我校迎新网方式说明</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 07-24
                </span>
            </div>
            
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">关于举办2015年北京市大学生英语演讲比赛预赛暨北京交通大学选拔赛的通知</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 07-06
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">2015年秋季学期辅修、双学位录取名单</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 07-03
                </span>
            </div>
            
            
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">关于2015年推荐优秀本科生参加产学联合人才培养试点项目的通知</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 06-25
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">关于公布2015年北京交通大学大学生数学竞赛评审结果的通知</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 06-19
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">关于举办2015年北京交通大学大学生书法大赛的通知</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 06-15
                </span>
            </div>
            
            <div class="span-more">
                <a href="javascript:void(0);" class="btn btn-more medium ui-state-default">
                    <span class="button-content">查看更多</span>
                </a>
            </div>
        </div>
        <div class="news content-item" style="display: none;">
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">学院本科教学审核评估试点工作顺利完成</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 07-21
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">我校加入“中国高校创新创业教育联盟”</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 07-03
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">学校召开2015年上半年本科教学工作总结会议</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 07-17
                </span>
            </div>
            
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">理学院物理演示与探索实验室积极探索服务社会</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 07-01
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">我校学生荣获第十四届全国大学生机器人大赛二等奖</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 06-26
                </span>
            </div>
            
            
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">教师发展中心举办“教学基本功之备课的探究与实践”工作坊</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 06-19
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">学校召开学院本科教学审核评估动员会</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 06-19
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">教师发展中心召开校级教学促进师工作交流会</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 06-15
                </span>
            </div>
            <div class="list-item">
                <i class="glyph-icon icon-rss"></i>
                <div class="item-name display-inline">我校电信学院大创作品获2015年中美青年创客大赛北京赛区赛二等奖</div>
                <span class="float-right font-gray font-italic">
                    <i class="glyph-icon icon-time"></i> 06-15
                </span>
            </div>
            <div class="span-more">
                <a href="javascript:void(0);" class="btn btn-more medium ui-state-default">
                    <span class="button-content">查看更多</span>
                </a>
            </div>
        </div>
    </div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/teacher/nav-mobile.jsp" %>
<script type="text/javascript">
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