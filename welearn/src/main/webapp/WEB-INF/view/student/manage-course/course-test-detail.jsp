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
<div class="main">
	<div class="header">
		<i class="glyph-icon icon-chevron-left float-left btn-back"></i>
        <p>${courseName }</p>
    </div>
    <div class="content">
    
    <c:forEach var="item" items="${list }">
        <div id="rcd34" class="rcd" data-id="34"> <!-- rcd32中32指的是problem的id号 -->
            <div class="problem-title mrg5B">
                <!--这里的problem-no指的是题号，仅仅是从1自增的题号，不是problem真正的id-->
                <span class="problem-no">${item.getDisplayNo() }</span>、
                <span>${item.getContent() }</span>
            </div>
            <div class="problem-options">
            
            <c:forEach var="item1" items="${item.getOptions() }">
               <c:if test="${item1.getCode().equals(item.getAnswer())}">
                   <div class="option selected">
                </c:if>
                <c:if test="${!item1.getCode().equals(item.getAnswer())}">
                   <div class="option">
                </c:if>                    
                    <span class="code">${item1.getCode() }</span>
                    <span class="text">${item1.getContent() }</span>
                </div>
            </c:forEach>

            </div>
            
            <div class="problem-answer">
                <div class="mrg10T">
                    <span class="font-gray">正确答案：</span>
                    <span class="font-green font-size-20">${item.getAnswer() }</span>
                </div>
                <div class="mrg5T">
                    <span class="font-gray">你的答案：</span>
                    <span class="font-blue font-size-20">${item.getWrongAnswer() }</span>
                </div>
                <div class="explain mrg10T">
                    <span class="font-gray">题解：</span>
                    <span class="font-size-15">${item.getComment() }</span>
                    
                </div>
            </div>
        </div>        
    </c:forEach>
        
    </div>
    
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>