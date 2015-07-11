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
</style>
</head>
<body>
<div class="content-box">
    <ul class="menu-float" style="display: none;">
        <li><a href="grade-english.html">英语成绩</a></li>
    </ul>
    <h3 class="content-box-header bg-gray">
        <div class="glyph-icon icon-separator transparent menu-toggle">
            <i class="glyph-icon icon-reorder"></i>
        </div>
        <span class="pad0L  menu-toggle">课程成绩</span>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="">
        <div class="profile-box content-box">
            <div class="nav-list">
                <ul>
                
                
                    <li id="rcd342">
                        <a href="javascript:;" class="grade-toggle" title=""  data-id="342">
                            <i class="glyph-icon font-purple icon-time"></i>
                            2014-2015学年第二学期
                            <i class="glyph-icon icon-chevron-right float-right"></i>
                        </a>
                        <ul class="ul-inner" style="display: none;">
                            <li class="row">
                                <div class="col-xs-8">【专业课】软件系统分析与设计技术</div>
                                <div class="col-xs-2">2学分</div>
                                <div class="col-xs-2">A</div>
                            </li>
                        </ul>
                    </li>



                </ul>
            </div>
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
    $("ul.menu-float").slideToggle("fast");
});
</script>
</body>
</html>