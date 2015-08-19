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
    body {
    }
    
    .query-div {
        position: fixed;
        top: 0;
        width: 100%;
        background-color: #EAE8E8;
        padding-left: 5px;
        padding-right: 5px;
        height: 10%;
    }
    
    .query-div select {
        font-size: 1.8em;
        margin-top: 5px;
        margin-bottom: 5px;
        padding: 5px;
        background-color: #EAE8E8;
        border-top: none;
        border-left: none;
        border-right: none; 
    }
    
    .fixed {
        position: absolute;
        top: 10%;
        width: 10%;
        height: 90%;
    }
    
    .fixed>table {
        height: 100%;
        text-align: center;
    }
    
    .data.fixed>table td {
        width:25px;
    }
    
    .data {
        width: 90%;
        left: 10%;
        text-align: center;
        overflow-x: auto;
    }
    
    .data>table tr:nth-child(9),
    .data>table tr:nth-child(10) {
        color: red;
    }
    
    .data>table tr:nth-child(3) {
    	background-color: azure;
    }
    
    .nav-left>table {
        border: #DBDBDB;
        width: 40px;
        background-color: #EFEFEF;
    }
    
    .nav-left.fixed table {
    	width: 100%;
    }
   
</style>
</head>
<body>

<div class="query-div">
    <select id="select" onchange="javascript:changeCalendar()" style="margin-right: 10px;">    
        <c:forEach var="item" items="${list }">
    	<option value="${item.getId() }">${item.getName() }</option>
    	</c:forEach>
    </select>
</div>
<div class="nav-left fixed" style="z-index:20;">
    <table border="1">
        <tr><td>月份</td></tr>
        <tr><td>学期</td></tr>
        <tr><td>周次</td></tr>
        <tr><td>周一</td></tr>
        <tr><td>周二</td></tr>
        <tr><td>周三</td></tr>
        <tr><td>周四</td></tr>
        <tr><td>周五</td></tr>
        <tr><td>周六</td></tr>
        <tr><td>周日</td></tr>
    </table>
</div>
<%int count =1; %>
<c:forEach var="item" items="${list }">
    <div class="data fixed" id="${item.getId()}" 
    <% if(count != 1){ %>
     style="display: none;"
    <%};
    count++;
    %>
    >
    ${item.getContent() }
    </div>    
</c:forEach>

<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
function changeCalendar() {
	$("div.data.fixed").hide();
    var bid = $("#select").val();
	$("#"+bid).show(); 
}
</script>
</body>
</html>