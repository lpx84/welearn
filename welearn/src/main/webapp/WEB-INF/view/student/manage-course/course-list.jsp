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
        text-align:  center;
    }
    ul.menu-float {
        position: fixed;
        top: 40px;
        left: 0;
        min-width: 100px;
        font-size: 1.2em;
        line-height: 1.8em;
        box-shadow: 1px 1px 5px #B2B2B2;
        background-color: #F2F2F0;
        text-align: center;
        z-index: 10;
    }
    
    ul.menu-float li {
        border-bottom: solid 1px #DBDBD9;
    }
    
    .content-list li span {
        font-size: 1.2em;
        line-height: 2em;
    }
    
    ul.ul-inner li:nth-child(even) {
        background-color: #F7F7F7;
    }
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray">
        <p class="pad0L title">我的课程</p>
    </h3>
    <div class="profile-box content-box">
        <div class="nav-list">
            <ul>
                <!-- 显示时当前学期先显示，其他学期隐藏-->
                <li id="rcd342">
                    <a href="javascript:;" class="grade-toggle" title=""  data-id="342">
                        <i class="glyph-icon font-purple icon-time"></i>
                        2014-2015学年第二学期
                        <i class="glyph-icon icon-chevron-down float-right"></i>
                    </a>
                    <ul class="ul-inner">
                        <li class="row">
                            <div class="col-xs-12">
                                <a href="#" >【专业课】软件系统分析与设计技术</a>
                            </div>
                        </li>
                        <li class="row">
                            <div class="col-xs-12">
                                <a href="#" >【专业课】软件系统分析与设计技术</a>
                            </div>
                        </li>
                        <li class="row">
                            <div class="col-xs-12">
                                <a href="#" >【专业课】软件系统分析与设计技术</a>
                            </div>
                        </li>
                    </ul>
                </li>
                
                <li id="rcd343">
                    <a href="javascript:;" class="grade-toggle" title=""  data-id="343">
                        <i class="glyph-icon font-purple icon-time"></i>
                        2014-2015学年第一学期
                        <i class="glyph-icon fa-chevron-right float-right"></i>
                    </a>
                    <ul class="ul-inner" style="display: none;">
                        <li class="row">
                            <div class="col-xs-12">
                                <a href="course-manager.html" >【专业课】软件系统分析与设计技术</a>
                            </div>
                        </li>
                        <li class="row">
                            <div class="col-xs-12">
                                <a href="#" >【专业课】软件系统分析与设计技术</a>
                            </div>
                        </li>
                        <li class="row">
                            <div class="col-xs-12">
                                <a href="#" >【专业课】软件系统分析与设计技术</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li id="rcd344">
                    <a href="javascript:;" class="grade-toggle" title=""  data-id="344">
                        <i class="glyph-icon font-purple icon-time"></i>
                        2013-2014学年第二学期
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                    <ul class="ul-inner" style="display: none;">
                        <li class="row">
                            <div class="col-xs-12">
                                <a href="#" >【专业课】软件系统分析与设计技术</a>
                            </div>
                        </li>
                        <li class="row">
                            <div class="col-xs-12">
                                <a href="#" >【专业课】软件系统分析与设计技术</a>
                            </div>
                        </li>
                        <li class="row">
                            <div class="col-xs-12">
                                <a href="#" >【专业课】软件系统分析与设计技术</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
$(".menu-toggle").click(function(){
    $("ul.menu-float").slideToggle("fast");
});
$(".menu-toggle li").click(function(){
    $("ul.menu-float").slideUp("fast");
    $("ul.menu-float").slideToggle("fast");
});

$(".grade-toggle").click(function(){
    var id = $(this).attr("data-id");
    $("#rcd"+id+" .ul-inner").slideToggle();
    var ico = $("#rcd"+id+" a i.float-right");
    if(ico.hasClass("icon-chevron-right")){
        ico.removeClass("icon-chevron-right");
        ico.addClass("icon-chevron-down");
    } else {
        ico.addClass("icon-chevron-right");
        ico.removeClass("icon-chevron-down");
    }
});
</script>
</body>
</html>