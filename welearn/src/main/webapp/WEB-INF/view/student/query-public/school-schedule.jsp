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
    
    .fixed {
        position: absolute;
        top: 45px;
        height: calc(100% - 45px);
    }
    
    .fixed>table {
        height: 100%;
        text-align: center;
    }
    
    .fixed>table td {
        width:25px;
    }
    
    .data {
        width: calc(100% - 39px);
        left: 39px;
        text-align: center;
        overflow-x: auto;
    }
    
    .data>table tr:nth-child(9),
    .data>table tr:nth-child(10) {
        color: red;
    }
    
    .nav-left>table {
        border: #DBDBDB;
        width: 40px;
        background-color: #EFEFEF;
    }   
</style>
</head>
<body>
<div class="query-div">
    <select id="select">
        <option value="23">2015~2016学年（第二学期）</option>
        <option value="22">2015~2016学年（第一学期）</option>
        <option value="21">2014~2015学年（第二学期）</option>
        <option value="20">2014~2015学年（第一学期）</option>
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
<div class="data fixed">
<table align="center" border="1" cellspacing="0" style="width:841px">
	<tbody>
		<tr>
			<td colspan="1" style="text-align:center">二月</td>
			<td colspan="4" style="text-align:center">三月</td>
			<td colspan="4" style="text-align:center">四月</td>
			<td colspan="5" style="text-align:center">五月</td>
			<td colspan="4" style="text-align:center">六月</td>
			<td colspan="4" style="text-align:center">七月</td>
			<td colspan="5" style="text-align:center">八月</td>
		</tr>
		<tr>
			<td colspan="18" style="text-align:center">春季学期</td>
			<td colspan="9" style="text-align:center">夏季学期（含暑假）</td>
		</tr>
		<tr>
			<td style="text-align:center; width:25px"><strong>1</strong></td>
			<td style="text-align:center; width:25px"><strong>2</strong></td>
			<td style="text-align:center; width:25px"><strong>3</strong></td>
			<td style="text-align:center; width:25px"><strong>4</strong></td>
			<td style="text-align:center; width:25px"><strong>5</strong></td>
			<td style="text-align:center; width:25px"><strong>6</strong></td>
			<td style="text-align:center; width:25px"><strong>7</strong></td>
			<td style="text-align:center; width:25px"><strong>8</strong></td>
			<td style="text-align:center; width:25px"><strong>9</strong></td>
			<td style="text-align:center; width:25px"><strong>10</strong></td>
			<td style="text-align:center; width:25px"><strong>11</strong></td>
			<td style="text-align:center; width:25px"><strong>12</strong></td>
			<td style="text-align:center; width:25px"><strong>13</strong></td>
			<td style="text-align:center; width:25px"><strong>14</strong></td>
			<td style="text-align:center; width:25px"><strong>15</strong></td>
			<td style="text-align:center; width:25px"><strong>16</strong></td>
			<td style="text-align:center; width:25px"><strong>17</strong></td>
			<td style="text-align:center; width:26px"><strong>18</strong></td>
			<td style="text-align:center; width:26px"><strong>1</strong></td>
			<td style="text-align:center; width:26px"><strong>2</strong></td>
			<td style="text-align:center; width:26px"><strong>3</strong></td>
			<td style="text-align:center; width:26px"><strong>4</strong></td>
			<td style="text-align:center; width:26px"><strong>5</strong></td>
			<td style="text-align:center; width:26px"><strong>6</strong></td>
			<td style="text-align:center; width:26px"><strong>7</strong></td>
			<td style="text-align:center; width:26px"><strong>8</strong></td>
			<td style="text-align:center; width:26px"><strong>9</strong></td>
		</tr>
		<tr>
			<td style="text-align:center">29</td>
			<td style="text-align:center">7</td>
			<td style="text-align:center">14</td>
			<td style="text-align:center">21</td>
			<td style="text-align:center">28</td>
			<td style="text-align:center">4</td>
			<td style="text-align:center">11</td>
			<td style="text-align:center">18</td>
			<td style="text-align:center">25</td>
			<td style="text-align:center">2</td>
			<td style="text-align:center">9</td>
			<td style="text-align:center">16</td>
			<td style="text-align:center">23</td>
			<td style="text-align:center">30</td>
			<td style="text-align:center">6</td>
			<td style="text-align:center">13</td>
			<td style="text-align:center">20</td>
			<td style="text-align:center">27</td>
			<td style="text-align:center">4</td>
			<td style="text-align:center">11</td>
			<td style="text-align:center">18</td>
			<td style="text-align:center">25</td>
			<td style="text-align:center">1</td>
			<td style="text-align:center">8</td>
			<td style="text-align:center">15</td>
			<td style="text-align:center">22</td>
			<td style="text-align:center">29</td>
		</tr>
		<tr>
			<td style="text-align:center">1</td>
			<td style="text-align:center">8</td>
			<td style="text-align:center">15</td>
			<td style="text-align:center">22</td>
			<td style="text-align:center">29</td>
			<td style="text-align:center">5</td>
			<td style="text-align:center">12</td>
			<td style="text-align:center">19</td>
			<td style="text-align:center">26</td>
			<td style="text-align:center">3</td>
			<td style="text-align:center">10</td>
			<td style="text-align:center">17</td>
			<td style="text-align:center">24</td>
			<td style="text-align:center">31</td>
			<td style="text-align:center">7</td>
			<td style="text-align:center">14</td>
			<td style="text-align:center">21</td>
			<td style="text-align:center">28</td>
			<td style="text-align:center">5</td>
			<td style="text-align:center">12</td>
			<td style="text-align:center">19</td>
			<td style="text-align:center">26</td>
			<td style="text-align:center">2</td>
			<td style="text-align:center">9</td>
			<td style="text-align:center">16</td>
			<td style="text-align:center">23</td>
			<td style="text-align:center">30</td>
		</tr>
		<tr>
			<td style="text-align:center">2</td>
			<td style="text-align:center">9</td>
			<td style="text-align:center">16</td>
			<td style="text-align:center">23</td>
			<td style="text-align:center">30</td>
			<td style="text-align:center">6</td>
			<td style="text-align:center">13</td>
			<td style="text-align:center">20</td>
			<td style="text-align:center">27</td>
			<td style="text-align:center">4</td>
			<td style="text-align:center">11</td>
			<td style="text-align:center">18</td>
			<td style="text-align:center">25</td>
			<td style="text-align:center">1</td>
			<td style="text-align:center">8</td>
			<td style="text-align:center">15</td>
			<td style="text-align:center">22</td>
			<td style="text-align:center">29</td>
			<td style="text-align:center">6</td>
			<td style="text-align:center">13</td>
			<td style="text-align:center">20</td>
			<td style="text-align:center">27</td>
			<td style="text-align:center">3</td>
			<td style="text-align:center">10</td>
			<td style="text-align:center">17</td>
			<td style="text-align:center">24</td>
			<td style="text-align:center">31</td>
		</tr>
		<tr>
			<td style="text-align:center">3</td>
			<td style="text-align:center">10</td>
			<td style="text-align:center">17</td>
			<td style="text-align:center">24</td>
			<td style="text-align:center">31</td>
			<td style="text-align:center">7</td>
			<td style="text-align:center">14</td>
			<td style="text-align:center">21</td>
			<td style="text-align:center">28</td>
			<td style="text-align:center">5</td>
			<td style="text-align:center">12</td>
			<td style="text-align:center">19</td>
			<td style="text-align:center">26</td>
			<td style="text-align:center">2</td>
			<td style="text-align:center">9</td>
			<td style="text-align:center">16</td>
			<td style="text-align:center">23</td>
			<td style="text-align:center">30</td>
			<td style="text-align:center">7</td>
			<td style="text-align:center">14</td>
			<td style="text-align:center">21</td>
			<td style="text-align:center">28</td>
			<td style="text-align:center">4</td>
			<td style="text-align:center">11</td>
			<td style="text-align:center">18</td>
			<td style="text-align:center">25</td>
			<td style="text-align:center">1</td>
		</tr>
		<tr>
			<td style="text-align:center">4</td>
			<td style="text-align:center">11</td>
			<td style="text-align:center">18</td>
			<td style="text-align:center">25</td>
			<td style="text-align:center">1</td>
			<td style="text-align:center">8</td>
			<td style="text-align:center">15</td>
			<td style="text-align:center">22</td>
			<td style="text-align:center">29</td>
			<td style="text-align:center">6</td>
			<td style="text-align:center">13</td>
			<td style="text-align:center">20</td>
			<td style="text-align:center">27</td>
			<td style="text-align:center">3</td>
			<td style="text-align:center">10</td>
			<td style="text-align:center">17</td>
			<td style="text-align:center">24</td>
			<td style="text-align:center">1</td>
			<td style="text-align:center">8</td>
			<td style="text-align:center">15</td>
			<td style="text-align:center">22</td>
			<td style="text-align:center">29</td>
			<td style="text-align:center">5</td>
			<td style="text-align:center">12</td>
			<td style="text-align:center">19</td>
			<td style="text-align:center">26</td>
			<td style="text-align:center">2</td>
		</tr>
		<tr>
			<td style="text-align:center">5</td>
			<td style="text-align:center">12</td>
			<td style="text-align:center">19</td>
			<td style="text-align:center">26</td>
			<td style="text-align:center">2</td>
			<td style="text-align:center">9</td>
			<td style="text-align:center">16</td>
			<td style="text-align:center">23</td>
			<td style="text-align:center">30</td>
			<td style="text-align:center">7</td>
			<td style="text-align:center">14</td>
			<td style="text-align:center">21</td>
			<td style="text-align:center">28</td>
			<td style="text-align:center">4</td>
			<td style="text-align:center">11</td>
			<td style="text-align:center">18</td>
			<td style="text-align:center">25</td>
			<td style="text-align:center">2</td>
			<td style="text-align:center">9</td>
			<td style="text-align:center">16</td>
			<td style="text-align:center">23</td>
			<td style="text-align:center">30</td>
			<td style="text-align:center">6</td>
			<td style="text-align:center">13</td>
			<td style="text-align:center">20</td>
			<td style="text-align:center">27</td>
			<td style="text-align:center">3</td>
		</tr>
		<tr>
			<td style="text-align:center">6</td>
			<td style="text-align:center">13</td>
			<td style="text-align:center">20</td>
			<td style="text-align:center">27</td>
			<td style="text-align:center">3</td>
			<td style="text-align:center">10</td>
			<td style="text-align:center">17</td>
			<td style="text-align:center">24</td>
			<td style="text-align:center">1</td>
			<td style="text-align:center">8</td>
			<td style="text-align:center">15</td>
			<td style="text-align:center">22</td>
			<td style="text-align:center">29</td>
			<td style="text-align:center">5</td>
			<td style="text-align:center">12</td>
			<td style="text-align:center">19</td>
			<td style="text-align:center">26</td>
			<td style="text-align:center">3</td>
			<td style="text-align:center">10</td>
			<td style="text-align:center">17</td>
			<td style="text-align:center">24</td>
			<td style="text-align:center">31</td>
			<td style="text-align:center">7</td>
			<td style="text-align:center">14</td>
			<td style="text-align:center">21</td>
			<td style="text-align:center">28</td>
			<td style="text-align:center">4</td>
		</tr>
	</tbody>
</table>

</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
</body>
