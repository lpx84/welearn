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
       <div class="glyph-icon icon-separator transparent" onclick="javascript: location.href='course-test'">
            <i class="glyph-icon fa-chevron-left"></i>
        </div>
        <span class="title">${courseName }</span>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="content">
    <%int count=0; %>
        <c:forEach var="item" items="${list }">
        <%count++; %>
        <div id="rcd${item.getId() }" class="rcd" data-id="${item.getId() }"> <!-- rcd32中32指的是problem的id号 -->
            <div class="problem-title">
                <!--这里的problem-no指的是题号，仅仅是从1自增的题号，不是problem真正的id-->
                <span class="problem-no"><%=count %></span>、
                <span>${item.getContent() }</span>
            </div>
            <div class="problem-options">
            
            <c:forEach var="item1" items="${item.getOptions() }">
                <div class="option">
                    <span class="code">${item1.getCode() }</span>
                    <span class="text">${item1.getContent() }</span>
                </div>
            </c:forEach>
            
            </div>
        </div>
        </c:forEach>

    </div>
    
    <a href="javascript:submitAnswer();" class="btn btn-submit large display-block float-none bg-blue">
        <span class="button-span">提交答案</span>
    </a>
    
    <form id="answer-form" action="<%=request.getContextPath() %>/student/manage/course/course-test-result" type=post"">
    	<input name="answer" id="answer" type="hidden">
    </form>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
$(".problem-options .option").click(function(){
    var $options = $(this).siblings();
    
    $options.each(function(n, node) {
        $(node).removeClass("selected");
    });
    $(this).addClass("selected");
    $(this).parent().parent().removeClass("unfinish");
    
    
});

function submitAnswer() {
    var ans = "";
    var finished = true;
    var firstUnfinishId = 0;

    var $problems = $(".rcd");
    for(var i=0; i<$problems.length; ++i) {
        var $problem = jQuery($problems.get(i));
        var id = $problem.attr("data-id");
        var answer = getProblemSelected($problem);
        var rcdDisplayNo = jQuery($problem.children(".problem-title")).children(".problem-no").html();
        if(answer == "null") {
            
            if(finished) {
            	firstUnfinishId = id;
            }
            finished = false;
            $("#rcd"+id).addClass("unfinish");
        } else {
            ans += (rcdDisplayNo + ":" + id + ":" + answer + ";");
        }
    }
    
    if(finished) {
        //提交操作 答案格式： "id:answer;id:answer;id:answer;"
       // alert(ans);
        //location.href = "./course-test-result.html";
		/*
		        ({
        	url: $("#appName").val()+"/student/manage/course/course-test-result",
        	type: "post",
        	data: {
        		answer: ans
        	}
        });
		*/
        
        $("#answer-form #answer").val(ans);
        $("#answer-form").submit();
        
        
    } else {
        location = "#rcd"+firstUnfinishId;
        alert("您还有未完成的题目，请完成后提交！");
    }
    
}

function getProblemSelected($node) {
    var $options = $node.children(".problem-options").children(".option");
    var res = "null";
    for(var i=0; i<$options.length; ++i) {
        var $option = jQuery($options.get(i));
        if($option.hasClass("selected")) {
            res = $option.children(".code").html();
        }
    }
    return res;
}
</script>
</body>
</html>