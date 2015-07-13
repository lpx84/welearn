<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>${title }</title>
<!-- Favicons -->
<link rel="shortcut icon" href="<%=request.getContextPath() %>/public/img/bjtu_48X48.ico" />

<!--[if lt IE 9]>
  <script src="assets/js/minified/core/html5shiv.min.js"></script>
  <script src="assets/js/minified/core/respond.min.js"></script>
<![endif]-->

<!-- Fides Admin CSS Core -->

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/public/assets/css/minified/aui-production.min.css" />

<!-- Theme UI -->

<link id="layout-theme" rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/public/assets/themes/minified/fides/color-schemes/dark-blue.min.css" />

<!-- Fides Admin Responsive -->

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/public/assets/themes/minified/fides/common.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/public/assets/themes/minified/fides/responsive.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/public/assets/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/public/assets/themes/minified/fides/color-schemes/dark-blue.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/public/css/teacher-global.css">

<!-- Fides Admin JS -->
<script type="text/javascript" src="<%=request.getContextPath() %>/public/bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/public/assets/js/minified/aui-production.min.js"></script>
<!-- Global JS -->
<script type="text/javascript" src="<%=request.getContextPath() %>/public/js/teacher-global.js"></script>

<script type="text/javascript">
jQuery(window).load(
    function(){
        var wait_loading = window.setTimeout( function(){
          $('#loading').slideUp('fast');
          jQuery('body').css('overflow','auto');
        },1000
    );
});

</script>

