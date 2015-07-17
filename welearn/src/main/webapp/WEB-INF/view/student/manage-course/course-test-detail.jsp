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
    
    .rcd {
        margin-top: 5px;
        padding: 10px;
        font-size: 1.3em;
/*        border-bottom: 1px solid #e7e7e7;*/
    }
    
    .content {
        margin: 10px;
    }
    
    .content .rcd .problem-options .option {
        margin-bottom: 5px;
        border-left: solid 5px #0099CC;
        padding: 5px 10px;
        background-color: rgb(235, 246, 255);
    }
    
    .rcd.unfinish {
        background-color: #FFD9D9 !important;
        border-radius: 3px;
    }
    
    .option.selected {
        background-color: #0099cc !important;
        border-left-color: #fff !important;
        color: #fff;
    }
    
    .option .text {
        word-wrap: break-word;
        word-break: break-all;
    }
    
    .btn-submit {
        margin: 10px 5px;
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
        <div id="rcd34" class="rcd" data-id="34"> <!-- rcd32中32指的是problem的id号 -->
            <div class="problem-title mrg5B">
                <!--这里的problem-no指的是题号，仅仅是从1自增的题号，不是problem真正的id-->
                <span class="problem-no">1</span>、
                <span>北京交通大学是哪一年建立的？</span>
            </div>
            <div class="problem-options">
                <div class="option selected">
                    <span class="code">A</span>
                    <span class="text">1896</span>
                </div>
                <div class="option">
                    <span class="code">B</span>
                    <span class="text">1856</span>
                </div>
                <div class="option">
                    <span class="code">C</span>
                    <span class="text">1886</span>
                </div>
                <div class="option">
                    <span class="code">D</span>
                    <span class="text">1897</span>
                </div>
            </div>
            <div class="problem-answer">
                <div class="mrg10T">
                    <span class="font-gray">正确答案：</span>
                    <span class="font-green font-size-20">A</span>
                </div>
                <div class="mrg5T">
                    <span class="font-gray">你的答案：</span>
                    <span class="font-blue font-size-20">C</span>
                </div>
                <div class="explain mrg10T">
                    <span class="font-gray">题解：</span>
                    <span class="font-size-15">这道题你都不会？？？？？？？还是交大人么</span>
                    
                </div>
            </div>
        </div>
        
        <div id="rcd35" class="rcd" data-id="35"> <!-- rcd32中32指的是problem的id号 -->
            <div class="problem-title mrg5B">
                <!--这里的problem-no指的是题号，仅仅是从1自增的题号，不是problem真正的id-->
                <span class="problem-no">2</span>、
                <span>北京交通大学是哪一年建立的？</span>
            </div>
            <div class="problem-options">
                <div class="option selected">
                    <span class="code">A</span>
                    <span class="text">1896</span>
                </div>
                <div class="option">
                    <span class="code">B</span>
                    <span class="text">1856</span>
                </div>
                <div class="option">
                    <span class="code">C</span>
                    <span class="text">1886</span>
                </div>
                <div class="option">
                    <span class="code">D</span>
                    <span class="text">1897</span>
                </div>
            </div>
            <div class="problem-answer">
                <div class="mrg10T">
                    <span class="font-gray">正确答案：</span>
                    <span class="font-green font-size-20">A</span>
                </div>
                <div class="mrg5T">
                    <span class="font-gray">你的答案：</span>
                    <span class="font-blue font-size-20">C</span>
                </div>
                <div class="explain mrg10T">
                    <span class="font-gray">题解：</span>
                    <span class="font-size-15">这道题你都不会？？？？？？？还是交大人么</span>
                    
                </div>
            </div>
        </div>
        
    </div>
    
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>