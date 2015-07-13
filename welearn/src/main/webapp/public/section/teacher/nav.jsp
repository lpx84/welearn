<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- nav-left -->
		<div id="page-header" class="clearfix">
           <div id="header-logo">
               <a href="javascript:;" class="tooltip-button" data-placement="bottom" title="Close sidebar" id="close-sidebar">
                   <i class="glyph-icon icon-caret-left"></i>
               </a>
               <a href="javascript:;" class="tooltip-button hidden" data-placement="bottom" title="Open sidebar" id="rm-close-sidebar">
                   <i class="glyph-icon icon-caret-right"></i>
               </a>
               <a href="javascript:;" class="tooltip-button hidden" title="Navigation Menu" id="responsive-open-menu">
                   <i class="glyph-icon icon-align-justify"></i>
               </a>
               <label class="app-title">招办微信后台管理系统</label>
           </div>
           
           <div class="user-profile dropdown">
               <a href="javascript:;" title="" class="user-ico clearfix" data-toggle="dropdown">
                   <img width="36" src="<%=request.getContextPath() %>/public/assets/images/gravatar.jpg" alt="" />
                   <span><%=request.getSession().getAttribute("truename") %></span>
                   <i class="glyph-icon icon-chevron-down"></i>
               </a>
               <ul class="dropdown-menu float-right">
                   <li style="display: none;">
                       <a href="admin-detail.html" title="">
                           <i class="glyph-icon icon-user mrg5R"></i>&nbsp;&nbsp;账户详情
                       </a>
                   </li>
                   <li>
                       <a href="<%=request.getContextPath() %>/admin/admin/modify-pwd" title="修改密码">
                           <i class="glyph-icon icon-flag mrg5R"></i>&nbsp;&nbsp;修改密码
                       </a>
                   </li>
                   <li class="divider"></li>
                   <li>
                       <a href="<%=request.getContextPath() %>/admin/admin/logout.act" title="">
                           <i class="glyph-icon icon-signout font-size-13 mrg5R"></i>
                           <span class="font-bold">注销</span>
                       </a>
                   </li>
                   
               </ul>
           </div>

       </div><!-- #page-header -->
       
       <!-- nav-left -->
       <div id="page-sidebar" class="scrollable-content">

           <div id="sidebar-menu">
               <ul>
                   <li>
                       <a href="<%=request.getContextPath() %>/admin/admin/home" title="首页">
                           <i class="glyph-icon icon-home"></i>首页
                       </a>
                   </li>
                   <li>
                       <a href="javascript:;" title="文章管理">
                           <i class="glyph-icon icon-book"></i>文章管理
                       </a>
                       <ul>
                           <li>
                               <a href="<%=request.getContextPath() %>/admin/article/article-theme" title="文章主题管理">
                                   <i class="glyph-icon icon-chevron-right"></i>文章主题管理
                               </a>
                           </li>
                           <li>
                               <a href="<%=request.getContextPath() %>/admin/article/article-list" title="文章管理">
                                   <i class="glyph-icon icon-chevron-right"></i>文章管理
                               </a>
                           </li>
                           
                       </ul>
                   </li>
                   <li>
                       <a href="javascript:;" title="专业导读">
                           <i class="glyph-icon icon-puzzle-piece"></i>专业导读
                       </a>
                       <ul>
                           <li>
                               <a href="<%=request.getContextPath() %>/admin/major/academy-list" title="学院管理">
                                   <i class="glyph-icon icon-chevron-right"></i>学院管理
                               </a>
                           </li>
                           <li>
                               <a href="<%=request.getContextPath() %>/admin/major/major-list" title="专业管理">
                                   <i class="glyph-icon icon-chevron-right"></i>专业管理
                               </a>
                           </li>
                           <li>
                               <a href="<%=request.getContextPath() %>/admin/major/major-cat-list" title="专业大类管理">
                                   <i class="glyph-icon icon-chevron-right"></i>专业大类管理
                               </a>
                           </li>
                       </ul>
                   </li>
                   
                   <li>
                       <a href="javascript:;" title="多彩交大">
                           <i class="glyph-icon icon-picture"></i>多彩交大
                       </a>
                       <ul>
                           <li>
                               <a href="<%=request.getContextPath() %>/admin/pic/pic-theme" title="图片主题管理">
                                   <i class="glyph-icon icon-chevron-right"></i>图片主题管理
                               </a>
                           </li>
                           <li>
                               <a href="<%=request.getContextPath() %>/admin/pic/pic-list" title="图片管理">
                                   <i class="glyph-icon icon-chevron-right"></i>图片管理
                               </a>
                           </li>
                           
                       </ul>
                   </li>
                   <li>
                       <a href="javascript:;" title="招生计划">
                           <i class="glyph-icon icon-tasks"></i>招生计划
                       </a>
                       <ul>
                           <li>
                               <a href="<%=request.getContextPath() %>/admin/plan/plan-tz-list" title="统招计划">
                                   <i class="glyph-icon icon-chevron-right"></i>统招计划
                               </a>
                           </li>
                           <li>
                               <a href="<%=request.getContextPath() %>/admin/plan/plan-ts-list" title="特殊类计划">
                                   <i class="glyph-icon icon-chevron-right"></i>特殊类计划
                               </a>
                           </li>
                           
                       </ul>
                   </li>
                   <li>
                       <a href="javascript:;" title="历年分数统计">
                           <i class="glyph-icon icon-bar-chart"></i>历年分数统计
                       </a>
                       <ul>
                           <li>
                               <a href="score-tz.html" title="统招类管理">
                                   <i class="glyph-icon icon-chevron-right"></i>统招类管理
                               </a>
                           </li>
                           <li>
                               <a href="score-ts.html" title="特殊类管理">
                                   <i class="glyph-icon icon-chevron-right"></i>特殊类管理
                               </a>
                           </li>
                           <li>
                               <a href="score-fs.html" title="各省份分数管理">
                                   <i class="glyph-icon icon-chevron-right"></i>各省份分数管理
                               </a>
                           </li>
                       </ul>
                   </li>
                   <li>
                       <a href="contact.html" title="联系方式管理">
                           <i class="glyph-icon icon-phone"></i>联系方式管理
                       </a>
                   </li>
                   <li>
                       <a href="javascript:;" title="更多操作">
                           <i class="glyph-icon icon-folder-open"></i>更多操作
                       </a>
                       <ul>
                           <li>
                               <a href="year.html" title="年份管理">
                                   <i class="glyph-icon icon-chevron-right"></i>年份管理
                               </a>
                           </li>
                           <li>
                               <a href="train-way.html" title="培养方式管理">
                                   <i class="glyph-icon icon-chevron-right"></i>培养方式管理
                               </a>
                           </li>
                           <li>
                               <a href="subject-cat.html" title="学科门类管理">
                                   <i class="glyph-icon icon-chevron-right"></i>学科门类管理
                               </a>
                           </li>
                           <li>
                               <a href="school-len.html" title="学制管理">
                                   <i class="glyph-icon icon-chevron-right"></i>学制管理
                               </a>
                           </li>
                       </ul>
                   </li>
               </ul>
               <div class="divider mrg5T mobile-hidden"></div>
               
           </div>

       </div><!-- #page-sidebar -->