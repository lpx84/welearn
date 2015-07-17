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
    .btn-more {
        margin-top: 5px;
        width: 100%;
    }
    
    .btn-more .button-content {
        font-size: 1.3em;
        line-height: 2em;
        display: block;
        text-align: center;
        width: 100%;
        
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
    
    .content {
        margin: 10px;
    }
    
    .option .text {
        word-wrap: break-word;
        word-break: break-all;
    }
    
    .btn-submit {
        margin: 10px 5px;
    }
    
    .row {
        line-height: 3em;
        margin-left: 10%;
    }

    .time {
        font-size: 1.5em;
        line-height: 1.5em;
    }
    
    .ecard-query {
        border: 1px solid #EDEDEB;
    }
    
    .rcd {
        padding: 5px;
        margin: 2px 0;
        border: 1px solid #e7e7e7;
    }   
   
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray">
        <div class="glyph-icon icon-separator transparent">
            <i class="glyph-icon fa-chevron-left"></i>
        </div>
        <span class="title">一卡通查询</span>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="content">
        
        <div class="ecard-query">
            <div class="row mrg10T">
                <div class="col-xs-1">从 </div>
                <div class="col-xs-9">
                    <input class="time start-time" type="text" value="20150723">
                </div>
            </div>
            <div class="row mrg5T">
                <div class="col-xs-1">到 </div>
                <div class="col-xs-9">
                    <input class="time end-time" type="text" value="20150725">
                </div>
            </div>

            <div class="text-center">
                <a href="javascript:queryData();" class="btn btn-submit  large float-none bg-blue mrg10T">
                    <span class="button-content">查询消费记录</span>
                </a>
            </div>
        </div>
        
        <div class="ecard-list" style="display:none;">
            <div class="pad10T pad5L pad5B font-bold font-gray font-size-15" style="">
                消费记录
            </div>
            <div class="item-list">
                <div class="rcd">
                    <div class="rows r1">
                        <span class="mrg5R">
                            <span class="font-gray">描述：</span>
                            <span class="">餐费支出</span>
                        </span>
                        <span class="mrg5R">
                            <span class="font-gray">消费：</span>
                            <span class="font-purple">￥4.67</span>
                        </span>
                        <span class="">
                            <span class="font-gray">余额：</span>
                            <span class="font-red">￥54.67</span>
                        </span>
                    </div>
                    <div class="rows r2">
                        <span class="mrg5R"><i class="fa fa-clock-o font-gray"></i>&nbsp;2015-7-15 12:45:23</span>
                        <span class=""><i class="fa fa-user font-gray"></i>&nbsp;虚拟职员</span>
                    </div>
                    <div class="rows r3">
                        <span class=""><i class="fa fa-hospital-o font-gray"></i>&nbsp;活动中心饮食工作站---二层商品服务部004</span>
                    </div>
                </div>
                
                <div class="rcd">
                    <div class="rows r1">
                        <span class="mrg5R">
                            <span class="font-gray">描述：</span>
                            <span class="">餐费支出</span>
                        </span>
                        <span class="mrg5R">
                            <span class="font-gray">消费：</span>
                            <span class="font-purple">￥4.67</span>
                        </span>
                        <span class="">
                            <span class="font-gray">余额：</span>
                            <span class="font-red">￥54.67</span>
                        </span>
                    </div>
                    <div class="rows r2">
                        <span class="mrg5R"><i class="fa fa-clock-o font-gray"></i>&nbsp;2015-7-15 12:45:23</span>
                        <span class=""><i class="fa fa-user font-gray"></i>&nbsp;虚拟职员</span>
                    </div>
                    <div class="rows r3">
                        <span class=""><i class="fa fa-hospital-o font-gray"></i>&nbsp;活动中心饮食工作站---二层商品服务部004</span>
                    </div>
                </div>
                
                <div class="rcd">
                    <div class="rows r1">
                        <span class="mrg5R">
                            <span class="font-gray">描述：</span>
                            <span class="">餐费支出</span>
                        </span>
                        <span class="mrg5R">
                            <span class="font-gray">消费：</span>
                            <span class="font-purple">￥4.67</span>
                        </span>
                        <span class="">
                            <span class="font-gray">余额：</span>
                            <span class="font-red">￥54.67</span>
                        </span>
                    </div>
                    <div class="rows r2">
                        <span class="mrg5R"><i class="fa fa-clock-o font-gray"></i>&nbsp;2015-7-15 12:45:23</span>
                        <span class=""><i class="fa fa-user font-gray"></i>&nbsp;虚拟职员</span>
                    </div>
                    <div class="rows r3">
                        <span class=""><i class="fa fa-hospital-o font-gray"></i>&nbsp;活动中心饮食工作站---二层商品服务部004</span>
                    </div>
                </div>
            </div>

            <!-- 当前页号，下一次请求在此基础上加1 -->
            <input id="pageNo" type="hidden" value="1">
            <a href="javascript:fetchData();" class="btn btn-more medium float-none ui-state-default">
                <span class="button-content">查看更多</span>
            </a>
        </div>
        
    </div>
    
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

	function queryData() {
		$(".ecard-list").show();
	}
</script>
</body>
</html>