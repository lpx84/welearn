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
   
    .query-div {
        position: fixed;
        top: 0;
        width: calc(100% - 10px);
        background-color: #EAE8E8;
        padding-left: 5px;
        padding-right: 5px;
    }
    
    .query-div select {
        font-size: 1.2em;
        margin-top: 5px;
        margin-bottom: 5px;
        padding: 5px;
        background-color: #EAE8E8;
        border-top: none;
        border-left: none;
        border-right: none;
    }
    
    .data {
        margin-top: 109px;
    }
    
    table.table-head {
        width: calc(100% + 10px);
        margin-left: -5px;
        margin-right: -5px;
    }
    
    .empty-room {
        width: 100%;
        text-align: center;
        border: lightgray;
        font-family: "Microsoft YaHei";
    }
    
    table.empty-room thead,
    table.empty-room .left {
        background-color: rgb(231, 231, 231);
    }
    
    table.empty-room .room-cell {
        min-width: 25px;
    }
    
    table.empty-room .room-inclass {
        background-color: rgb(90, 200, 90);
        color: #fff;
    }
    
    table.empty-room .room-borrow {
        background-color: #5677fc;
        color: #fff;
    }
    
    table.empty-room .room-empty {
        
    }
    
    .building-name {
        width: 60px;
    }
    
    .room-name {
        width: 50px;
    }
    
</style>
</head>
<body>
<div class="query-div">
    <select id="select" onchange="javascript:changeBuilding()">
        <option value="_all">选择教学楼</option>
    	<c:forEach var="b" items="${buildingList }">
    	<option value="${b.getCode() }">${b.getName() }</option>
    	</c:forEach>
    </select>
    <table class="table-head empty-room" border="1" cellpadding="2">
        <thead>
            <tr>
                <th colspan="2">${curDate }<br>(${curWeek })</th>
                <th colspan="7">节次</th>
            </tr>
            <tr>
                <th class="building-name">教学楼</th>
                <th class="room-name">教室</th>
                <th class="room-cell">1</th>
                <th class="room-cell">2</th>
                <th class="room-cell">3</th>
                <th class="room-cell">4</th>
                <th class="room-cell">5</th>
                <th class="room-cell">6</th>
                <th class="room-cell">7</th>
            </tr>
        </thead>
    </table>
</div>
<div class="data">
    <table class="empty-room" border="1" cellpadding="2">
        <tbody>
            <c:forEach var="r" items="${roomList }">
                <tr class="_all ${r.getBuildingCode() }">
                    <td class="building-name">${r.getBuilding() }</td>
                    <td class="room-name">${r.getBuilding() }</td>
                    <c:forEach var="room" items="${r.getStatus() }">
                    <c:choose>
                    <c:when test="${'有课' == room }">
                    	<td class="room-cell room-inclass">${room }</td>
                    </c:when>
                    <c:when test="${'借用' == room }">
                    	<td class="room-cell room-borrow">${room }</td>
                    </c:when>
                    <c:otherwise>
                    	<td class="room-cell room-empty">${room }</td>
                    </c:otherwise>
                    </c:choose>
    	            </c:forEach>                                   
                </tr>
    	    </c:forEach> 
<!--             <tr class="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr> -->

            
        </tbody>
    </table>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
function changeBuilding() {
	$("table.empty-room tbody tr").hide();
	var bname = $("#select").val();
	$("table.empty-room tbody tr."+bname).slideDown();
}

</script>
</body>
</html>