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
               <label class="app-title">微信教学平台教师端</label>
           </div>
           
           <div class="user-profile dropdown">
               <a href="javascript:;" title="" class="user-ico clearfix" data-toggle="dropdown">
                   <img width="36" src="<%=request.getContextPath() %>/public/assets/images/gravatar.jpg" alt="" />
                   <span><%=request.getSession().getAttribute("truename") %></span>
                   <i class="glyph-icon icon-chevron-down"></i>
               </a>
               <ul class="dropdown-menu float-right">
                   <li>
                       <a href="<%=request.getContextPath() %>/admin-detail.html" title="">
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
                           <i class="glyph-icon icon-home"></i>课程首页
                       </a>
                   </li>
                   <li>
                       <a href="contact.html" title="课程讨论">
                           <i class="glyph-icon icon-bullhorn"></i>公告管理
                       </a>
                   </li>
                   <li>
                       <a href="contact.html" title="课程讨论">
                           <i class="glyph-icon icon-pencil"></i>作业管理
                       </a>
                   </li>
                   <li>
                       <a href="contact.html" title="课程讨论">
                           <i class="glyph-icon icon-phone"></i>签到管理
                       </a>
                   </li>
                   <li>
                       <a href="contact.html" title="课程讨论">
                           <i class="glyph-icon icon-comments-alt"></i>课程讨论
                       </a>
                   </li>
                   <li>
                       <a href="javascript:;" title="在线测评">
                           <i class="glyph-icon icon-lightbulb"></i>在线测评
                       </a>
                       <ul>
                           <li>
                               <a href="<%=request.getContextPath() %>/" title="题库管理">
                                   <i class="glyph-icon icon-chevron-right"></i>题库管理
                               </a>
                           </li>
                           <li>
                               <a href="<%=request.getContextPath() %>/" title="学生答题情况">
                                   <i class="glyph-icon icon-chevron-right"></i>学生答题情况
                               </a>
                           </li>
                           
                       </ul>
                   </li>
                   <li>
                       <a href="contact.html" title="课程讨论">
                           <i class="glyph-icon icon-star-half-full"></i>课程反馈
                       </a>
                   </li>
               </ul>
               <div class="divider mrg5T mobile-hidden"></div>
               
           </div>

       </div><!-- #page-sidebar -->