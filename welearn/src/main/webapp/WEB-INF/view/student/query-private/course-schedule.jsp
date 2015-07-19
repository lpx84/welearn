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
   .fixed {
        position: absolute;
    }
    
    .fixed>table td,
    .fixed>table th {
        min-width:40px;
    }
    
    .data {
        width: 100%;
        overflow-x: hidden;
    }
    
    .data>table {
       border: #DBDBDB; 
    }
    
    .data>table thead th {
/*        background-color: #e3ffe3;*/
        text-align: center;
    }
    
    .data>table tr td:first-child,
    .data>table thead th:first-child {
        width: 20px;
        text-align: center;
    }
    
    .data>table tr td:first-child {
/*        background-color: #d9ffd9;*/
    }
    
    .course-no {
        width: 20px;
        text-align: center;
    }
    
    .has-course {
        background-color: #CCFFCC;
    }
   
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray text-center">
        <label class="title">2014~2015学年 第一学期</label>
    </h3>
    <div class="data fixed">
    <table border="1" cellspacing="1" style="width: 100%;">
        <thead>
            <th class="course-no">节次</th>
            <th>周一</th>
            <th>周二</th>
            <th>周三</th>
            <th>周四</th>
            <th>周五</th>
            <th>周六</th>
            <th>周日</th>
        </thead>
        <tbody>
           <tr>
               <td class="course-no">1</td>
               <td></td>
               <td class="has-course">高清人文电影鉴赏与研究_01 何腾</td>
               <td></td>
               <td class="has-course">软件工程综合实践_03 张红延</td>
               <td></td>
               <td></td>
               <td></td>
            </tr>
            <tr>
                <td class="course-no">2</td>
               <td class="has-course">信息安全理论与实践_01 刘铎</td>
               <td class="has-course">软件体系结构_01 冀振燕</td>
               <td></td>
               <td class="has-course">软件工程综合实践_03 张红延</td>
               <td></td>
               <td></td>
               <td></td>
            </tr>
            <tr>
                <td class="course-no">3</td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
            </tr>
            <tr>
                <td class="course-no">4</td>
               <td></td>
               <td class="has-course">前沿技术讲座_01 Brain</td>
               <td class="has-course">软件市场调查与营销_01 孙熙安</td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
            </tr>
            <tr>
                <td class="course-no">5</td>
               <td></td>
               <td class="has-course">前沿技术讲座_01 Brain</td>
               <td class="has-course">软件工程专业研究方法论与创新教育_01 张红延</td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
            </tr>
            <tr>
                <td class="course-no">6</td>
               <td class="has-course">.NET架构与应用_01 郑萌</td>
               <td class="has-course">婚姻、家庭与继承法_01 罗冠男</td>
               <td></td>
               <td></td>
               <td class="has-course">移动应用开发技术_01 王光宇</td>
               <td></td>
               <td></td>
            </tr>
            <tr>
                <td class="course-no">7</td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
               <td></td>
            </tr>
        </tbody>
    </table>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>