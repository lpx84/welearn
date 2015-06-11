<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <select id="select">
        <option value="_all">选择教学楼</option>
        <option value="sy">思源楼</option>
        <option value="yf">逸夫楼</option>
        <option value="jj">第九教学楼</option>
    </select>
    <table class="table-head empty-room" border="1" cellpadding="2">
        <thead>
            <tr>
                <th colspan="2">6月10日<br>(星期三)</th>
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
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">第十七号教学楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">思源楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">思源西楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            <tr id="building-yf">
                <td class="building-name">逸夫楼</td>
                <td class="room-name">YF106</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-borrow">借用</td>
                <td class="room-cell room-inclass">有课</td>
                <td class="room-cell room-empty">空</td>
                <td class="room-cell room-empty">空</td>
            </tr>
            
        </tbody>
    </table>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
</body>
</html>