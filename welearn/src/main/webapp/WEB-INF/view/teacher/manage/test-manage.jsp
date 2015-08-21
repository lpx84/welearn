<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/teacher/header-mobile.jsp"%>
<title>${title }</title>
<style type="text/css">
.nav-footer {
	padding: 0;
	text-align: left;
}

.nav-footer>.problem {
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
	width: 30%;
}

.sub-header>.header-item.selected {
	border-bottom: solid 2px #7d7df8;
}

.content {
	margin-top: 80px;
}

.problem .problem-item {
	padding: 10px;
	margin-bottom: 5px;
	background-color: #fff;
}

.problem-item i {
	margin-right: 5px;
}

.footer-item.problem {
	line-height: 3em;
	font-size: 1.3em;
}

.record-item {
	padding: 10px;
	margin-bottom: 10px;
}

.record-item .name {
	line-height: 2em;
}

.record-item .grade {
	font-size: 1.8em;
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

.footer-item.score {
	margin: 10px;
}
</style>
</head>
<body>
	<div class="main">
		<div class="header">
			<i class="glyph-icon icon-chevron-left float-left btn-back"></i>
			<p>测评管理</p>
		</div>
		<div class="sub-header">
			<div class="display-inline header-item selected" data="problem">题库管理</div>
			<div class="display-inline header-item" data="test-record">答题记录</div>
			<div class="display-inline header-item" data="score">分数统计</div>
		</div>
		<div class="content">
			<div class="problem content-item">
				<div class="problem-list">
					<div class="problem-item bg-white">
						<i class="glyph-icon fa fa-circle-o"></i> 在Java中，负责对字节代码解释执行的是   
					</div>
					<div class="problem-item bg-white">
						<i class="glyph-icon fa fa-circle-o"></i> 一个栈的输入序列为1 2 3 4 5，则下列序列中不可能是栈得输出序列的是
					</div>
					<div class="problem-item bg-white">
						<i class="glyph-icon fa fa-circle-o"></i> LDAP是什么? 
					</div>
					<div class="problem-item bg-white">
						<i class="glyph-icon fa fa-circle-o"></i> 要想在你的视图上成功的执行查询需要做什么？  
					</div>
					<div class="problem-item bg-white">
						<i class="glyph-icon fa fa-circle-o"></i> Oracle中VARCHAR2类型的最大长度是
					</div>
					<div class="problem-item bg-white">
						<i class="glyph-icon fa fa-circle-o"></i> 以下哪些不是javascript的全局函数
					</div>
					<div class="problem-item bg-white">
						<i class="glyph-icon fa fa-circle-o"></i> 操作系统具有进程管理、存储管理、文件管理和设备管理的功能，在以下有关的描述中，哪一个是不正确的  
					</div>
					<div class="problem-item bg-white">
						<i class="glyph-icon fa fa-circle-o"></i> 下面有关系统并发访问数估算数据那个最有效：
					</div>
				</div>
				<div class="span-more">
					<a href="javascript:void(0);"
						class="btn btn-more medium ui-state-default"> <span
						class="button-content">已显示全部</span>
					</a>
				</div>
			</div>
			<div class="test-record content-item" style="display: none;">
				<div class="record-list">
					<div class="record-item bg-white">
						<span class="grade float-right mrg10R font-orange">90</span>
						<div class="name">12301124 李鹏翔</div>
						<div class="other">
							<span> <i class="glyph-icon icon-time font-gray"></i>
								07-16 12:34:54
							</span> <span> <span class="font-gray">用时：</span><span
								class="label bg-blue-alt">5分钟</span>
							</span>
						</div>
					</div>
					<div class="record-item bg-white">
						<span class="grade float-right mrg10R font-orange">70</span>
						<div class="name">12301121 金林荣</div>
						<div class="other">
							<span> <i class="glyph-icon icon-time font-gray"></i>
								08-16 14:44:04
							</span> <span> <span class="font-gray">用时：</span><span
								class="label bg-blue-alt">9分钟</span>
							</span>
						</div>
					</div>
					<div class="record-item bg-white">
						<span class="grade float-right mrg10R font-orange">80</span>
						<div class="name">12301124 李鹏翔</div>
						<div class="other">
							<span> <i class="glyph-icon icon-time font-gray"></i>
								07-06 10:34:50
							</span> <span> <span class="font-gray">用时：</span><span
								class="label bg-blue-alt">4分钟</span>
							</span>
						</div>
					</div>
				</div>
				<div class="span-more">
					<a href="javascript:void(0);"
						class="btn btn-more medium ui-state-default"> <span
						class="button-content">已显示全部</span>
					</a>
				</div>
			</div>
			<div class="score content-item"
				style="display: none; margin-top: 120px;">
				<div class="score-statistics margin-center"></div>
			</div>
		</div>

		<div class="nav-footer footer">
			<div class="problem footer-item bg-blue"
				onclick="javascript: location.href = 'test-problem-add';">
				<i class="glyph-icon icon-plus-sign font-white"></i> 增加题目
			</div>
			<div class="test-record footer-item" style="display: none;"></div>
			<div class="score footer-item" style="display: none;">
				<div class="display-inline">
					<span class="match-item"> <i class="glyph-icon icon-stop"
						style="color: #D5D5D6;"></i> 60以下 <span class="label m0"></span>
					</span> <span class="match-item"> <i class="glyph-icon icon-stop"
						style="color: #bf8030;"></i> 60~70 <span class="label m1"></span>
					</span> <span class="match-item"> <i class="glyph-icon icon-stop"
						style="color: #ffb673;"></i> 70~80 <span class="label m2"></span>
					</span> <span class="match-item"> <i class="glyph-icon icon-stop"
						style="color: #2381e9;"></i> 80~90 <span class="label m3"></span>
					</span> <span class="match-item"> <i class="glyph-icon icon-stop"
						style="color: #ff7a00;"></i> 90~100 <span class="label m4"></span>
					</span> <span class="match-item"> <i class="glyph-icon icon-stop"
						style="color: #00c322;"></i> 100 <span class="label m5"></span>
					</span>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/public/section/public.jsp"%>

<script type="text/javascript">
$(function(){
    var num = 65;
    var rate = [1, 5, 2, 2, 0, 55];
    for(var i in rate) {
        var tt = new Number((rate[i]/num*100).toString()).toFixed(2);
        $('.label.m'+i).html(rate[i] + "人 " + tt + "%");
    }
    
    $(".score-statistics").sparkline(rate, {
        type: "pie",
        width: "300",
        height: "300",
        sliceColors: ["#D5D5D6", "#bf8030", "#ffb673", "#2381e9", "#ff7a00", "#00c322"],
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