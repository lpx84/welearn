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
    .title-span {
        position: fixed;
        width: 100%;
        z-index: 100;
        text-align: center;
    }
    
    .reply-span {
        position: fixed;
        z-index: 100;
        bottom: 0;
        width: calc(100% - 20px);
    }
    
    .user-name,.info {
        font-size: 0.7em !important;
        line-height: 2em;
        color: #bebebe;
    }
    
    .popover {
        width: 95% !important;
    }
    
    .content-box {
        position: fixed;
        width: 100%;
        height: 90%;
        padding-bottom: 50px;
        overflow: auto;
    }   
   
</style>
</head>
<body>
<div class="content-box bg-white">
    <h3 class="title-span content-box-header ui-state-default">
        <label class="pad0L">${courseName}</label>
    </h3>
    <div class="content-box-wrapper" style="padding-top: 50px;">
        <div class="scrollable-content">
        
            <ul class="chat-box">
            	<c:forEach var="item" items="${list }">
            	<li <c:if test = "${!item.isMe() }">class="float-left" </c:if>>            	    
                    <div class="chat-author">
                        <img width="36" src="${item.getAvatar() }" alt="" />
                    </div>
                    <div <c:if test = "${!item.isMe() }">class="popover right no-shadow" </c:if>
                         <c:if test = "${item.isMe() }">class="popover left no-shadow" </c:if>>
                        <div class="arrow"></div>
                        <div class="popover-content">
                            <div class="info">
                                <span>${item.getRelayorName() }</span>
                                <span class="float-right"><i class="glyph-icon icon-time"></i> ${item.getTime() }</span>
                            </div>
                             ${item.getContent() }
                        </div>
                    </div>
                </li>
                </c:forEach>
                
            </ul>

        </div>
    </div>
    <div class="button-pane reply-span pad10A">
        <div class="form-row pad0B">
            <div class="form-input col-lg-12">
                <div class="input-append-wrapper input-append-right">
                    <a href="javascript:sendData();" class="btn input-append primary-bg">
                        <i class="glyph-icon fa-send"></i>
                    </a>
                    <div class="append-right">
                        <input type="text" placeholder="输入内容" name="content" id="content" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
	function refreshData() {
		//用ajax获取页面信息
		$.ajax({
			url : $("#appName").val()
					+ "/student/manage/course/refresh-course-discuss",
			type : "POST",
			timeout : 5000,
			dataType : "JSON",
			success : function(res) {
				if (res.code != 100) {
					joinData(res);
				}
			}
			//complete : completeHandler
		});
		setTimeout(refreshData, 3000);
	}
    
	refreshData();

	function joinData(res) {       
		var html = new Array(
				"<li class='float-left'>",
				"<div class='chat-author'><img width='36' src='",
				"avatar",
				"' alt='' /></div>",
				"<div class='popover right no-shadow'>",
				"<div class='arrow'></div><div class='popover-content'><div class='info'><span>",
				"name",
				"</span><span class='float-right'><i class='glyph-icon icon-time'></i> ",
				"time",
				"</span></div>",
				"content",
				"</div></div></li>"				
		);
		for (var i = 0; i < res.length; ++i) {
			if(res[i].me == true){
				html[0] = "<li>";
				html[4] = "<div class='popover left no-shadow'>";
			}
			html[2] = res[i].avatar;			
			html[4] = res[i].relayorName;			
			html[6] = res[i].time;
			html[8] = res[i].content;
			$(".chat-box").append(html.join(''));
		}
	}
	
	function sendData() {
		alert("nihao");
		//用ajax获取页面信息
		$.ajax({
			url : $("#appName").val()
					+ "/student/manage/course/send-course-discuss-content",
			type : "POST",
			data : {
				content : $("#content").val(),
			},
			timeout : 5000,
			dataType : "JSON",
			success : function(res) {
				if (res.code == 100) {
					alert(res.msg);
				} else {
					refreshData();
				}
			},
			complete : completeHandler
		});
	}
	
</script>
</body>
</html>