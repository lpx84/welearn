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
          text-align: center;
    }
    
    .content {
        margin-bottom: 5px;   
    }
    
    .rcd {
        padding: 5px 10px;
        border-bottom: 1px solid #d9d9d9;
    }
    
    .status {
        color: green;
        font-weight: bold;
        float: right;
    }
    
    .content .rcd div div {
        display: inline-block;
    }
    
    .content .r3 {
        line-height: 1.5em;
    }
    
    .lab {
        color: #d9d9d9;
    }
    
    .time {
        margin-right: 20px;
    }
    
    .btn-more {
   		display: block;
   		width: 100%;
   }
   
   .btn-more span {
   		position: absolute;
   		width: 100%;
   		text-align: center;
   }
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray">
        <p class="pad0L title">失物招领布告栏</p>
    </h3>
    <div class="content">
    <c:forEach var="item" items="${list }">
  
        <div class="rcd">
            <div class="r1">
                <div class="name"><span class="lab">物品：</span>${item.getThing() }</div>
                <div class="status">${item.getState() }</div>
            </div>
            <div class="r2"><span class="lab">描述：</span>${item.getDescribe() }</div>
            <div class="r3">
                <div class="time"><i class="fa fa-clock-o"></i>&nbsp;${item.getTime() }</div>
                <div class="place"><span class="lab">拾到地点：</span>${item.getPlace() }</div>
            </div>
        </div>
    </c:forEach>
    </div>
 
    <a href="javascript:fetchData();" class="btn btn-more medium float-none ui-state-default">
        <span class="button-content">查看更多</span>
    </a>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
var pageno=1;
function fetchData() {
	//记录当前页数
	pageno++;
	//用ajax获取页面信息

	$.ajax({
		
		url: $("#appName").val()+"/student/query/public/more-lost-thing",
		type: "POST",
		data: {
			pageno: pageno,
		},
		timeout: 5000,
		dataType: "JSON",
		success: function(res) {
			if(res.code == 100) {
				alert(res.msg);
			} else {
				if(res.length<1){
					$(".btn-more").removeAttr("href");
					$(".btn-more").html("没有更多了");		
				}else{
					joinData(res);
					$(".btn-more").html("查看更多");	
				}	
			}
		},
		complete: completeHandler
	});
	$(".btn-more").html("获取中...");
}

function joinData(res) {
	
	var html = new Array(
		"<div class='rcd'><div class='r1'><div class='name'><span class='lab'>物品：</span>",
		"thingname",
		"</div><div class='status'>",
		"state",
		"</div></div><div class='r2'><span class='lab'>描述：</span>",
		"descri",
		"</div><div class='r3'><div class='time'><i class='fa fa-clock-o'></i>&nbsp;",
		"time",
		"</div><div class='place'><span class='lab'>拾到地点：</span>",
		"place",
		"</div></div></div>"
	);
	for(var i=0; i<res.length; ++i) {
		html[1]=res[i].thing;
		html[3]=res[i].state;
		html[5]=res[i].describe;
		html[7]=res[i].time;
		html[9]=res[i].place;
		$(".content").append(html.join(''));
	}
}


</script>
</body>
</html>