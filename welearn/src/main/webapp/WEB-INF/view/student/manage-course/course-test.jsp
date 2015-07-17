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
        border: none;
    }
    
    .introduce {
        padding: 10px;
    }
    
    ol {
        display: block;
        list-style: decimal;
        list-style-type: decimal;
        -webkit-margin-before: 1em;
        -webkit-margin-after: 1em;
        -webkit-margin-start: 0px;
        -webkit-margin-end: 0px;
        -webkit-padding-start: 40px;
    }
    
    ol li {
        list-style: decimal;
    }
    
    .test-new,
    .lab {
        margin: 10px 5px;
    }
    
    .lab {
        font-size: 1.4em;
        border-bottom: 1px solid #e7e7e7;
    }
    
    .rcd {
        padding: 10px;
        font-size: 1.3em;
        border-bottom: 1px solid #e7e7e7;
    }
    
    .rcd:nth-child(even) {
        background-color: #F7F7F7;
    }
    
   
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray">
        <span class="title">软件工程专业研究方法论与创新教育</span>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="content">
        <div class="test-new">
            <div class="introduce">
                <p>测试说明：</p>
                <p>
                    <ol>
                        <li>测试题目全部为选择题；</li>
                        <li>开始答题时原则不允许退出，如果中途退出，已答题目将丢失；</li>
                        <li>题目必须全部答完才允许提交；</li>
                    </ol>
                </p>
            </div>
            <a href="course-testing" class="btn large display-block float-none primary-bg">
                <span class="button-content"><i class="fa fa-share"></i> 开始新测试</span>
            </a>
        </div>
        <p class="lab font-gray pad5A">历史测评</p>
        <div class="item-list">
            <div class="rcd">
                <span><i class="fa fa-clock-o font-purple"></i> 07-14 10:34</span>
                <span class="font-size-14"><span class="font-gray ">用时 </span>12<span class="font-gray"> 分钟</span></span>
                <span class="score float-right font-green font-bold mrg10R">80</span>
            </div>
            <div class="rcd">
                <span><i class="fa fa-clock-o font-purple"></i> 07-14 10:34</span>
                <span class="font-size-14"><span class="font-gray ">用时 </span>12<span class="font-gray"> 分钟</span></span>
                <span class="score float-right font-green font-bold mrg10R">80</span>
            </div>
            <div class="rcd">
                <span><i class="fa fa-clock-o font-purple"></i> 07-14 10:34</span>
                <span class="font-size-14"><span class="font-gray ">用时 </span>12<span class="font-gray"> 分钟</span></span>
                <span class="score float-right font-green font-bold mrg10R">80</span>
            </div>
        </div>
    </div>
    
    <!-- 当前页号，下一次请求在此基础上加1 -->
    <input id="pageNo" type="hidden" value="1">
    <a href="javascript:fetchData();" class="btn btn-more medium float-none ui-state-default">
        <span class="button-content">查看更多</span>
    </a>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>