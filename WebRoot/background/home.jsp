<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>木西后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link href="./umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<!-- layUI -->
<link rel="stylesheet" href="layui/layui.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="bootstrap/font/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="adminLTE/dist/css/AdminLTE.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="adminLTE/dist/css/skins/_all-skins.min.css">
<!-- bootstrap datepicker -->
<link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
<!-- 分页js -->
<script src="lib/jquery/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
	src="bootstrap/js/bootstrap-paginator.min.js"></script>
<!-- layUi  js -->
<script type="text/javascript" src="layui/layui.all.js"></script>
<!-- 模板渲染的js -->
<script type="text/javascript" src="js/underscore.js"></script>



<!-- umediter  配置文件-->
<script type="text/javascript" src="./umeditor/third-party/template.min.js"></script>
<script type="text/javascript" src="./umeditor/umeditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="./umeditor/umeditor.min.js"></script>
<script type="text/javascript" src="./umeditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body class="skin-blue sidebar-mini" style="height: auto;">
	<div class="wrapper" style="height: auto;">

		<!-- Main Header -->
		<header class="main-header"> <!-- Logo --> <a
			href="https://almsaeedstudio.com/themes/AdminLTE/index2.html"
			class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span
			class="logo-mini">木子后台管理</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg">木子后台管理</span>
		</a> <!-- Header Navbar --> <nav class="navbar navbar-static-top"
			role="navigation"> <!-- Sidebar toggle button--> <a href="#"
			class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span
			class="sr-only">Toggle navigation</span>
		</a> <!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- Messages: style can be found in dropdown.less-->
				<!--  <li class="dropdown messages-menu">
					<!-- Menu toggle button  <a href="#" class="dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false"> <i
						class="fa fa-envelope-o"></i> <span class="label label-success">4</span>
				</a>
					<ul class="dropdown-menu">
					 <li class="header">你有4条消息</li>
						<li>
							inner menu: contains the messages
							<ul class="menu">
								<li>
									start message <a href="#">
										<div class="pull-left">
											User Image
											<img src="images/user2-160x160.jpg" class="img-circle"
												alt="User Image">
										</div> Message title and timestamp
										<h4>
											Support Team <small><i class="fa fa-clock-o"></i> 5
												mins</small>
										</h4> The message
										<p>Why not buy a new awesome theme?</p>
								</a>
								</li>
								end message
							</ul> /.menu
						</li>
						<li class="footer"><a href="#">See All Messages</a></li>
					</ul>
				</li>
				/.messages-menu

				Notifications Menu
				<li class="dropdown notifications-menu">
					Menu toggle button <a href="#" class="dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false"> <i
						class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">你有10条通知</li>
						<li>
							Inner Menu: contains the notifications
							<ul class="menu">
								<li>
									start notification <a href="#"> <i
										class="fa fa-users text-aqua"></i> 5 new members joined today
								</a>
								</li>
								end notification
							</ul>
						</li>
						<li class="footer"><a href="#">View all</a></li>
					</ul>
				</li>
				Tasks Menu
				<li class="dropdown tasks-menu">
					Menu Toggle Button <a href="#" class="dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false"> <i
						class="fa fa-flag-o"></i> <span class="label label-danger">9</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">9条任务</li>
						<li>
							Inner menu: contains the tasks
							<ul class="menu">
								<li>
									Task item <a href="#"> Task title and progress text
										<h3>
											Design some buttons <small class="pull-right">20%</small>
										</h3> The progress bar
										<div class="progress xs">
											Change the css width attribute to simulate progress
											<div class="progress-bar progress-bar-aqua"
												style="width: 20%" role="progressbar" aria-valuenow="20"
												aria-valuemin="0" aria-valuemax="100">
												<span class="sr-only">20% Complete</span>
											</div>
										</div>
								</a>
								</li>
								end task item
							</ul>
						</li>
						<li class="footer"><a href="#">View all tasks</a></li>
					</ul>
				</li> -->
				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false"> <!-- The user image in the navbar-->
						<img src="images/user2-160x160.jpg" class="user-image"
						alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-xs">木西</span>
				</a>
					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header"><img src="images/user2-160x160.jpg"
							class="img-circle" alt="User Image">

							<p>
								木西 - Web工程师 <small>16年入坑</small>
							</p></li>
						<!-- Menu Body -->
						<li class="user-body">
							<div class="row">
								<div class="col-xs-4 text-center">
									<a href="#">Followers</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Sales</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Friends</a>
								</div>
							</div> <!-- /.row -->
						</li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">修改密码</a>
							</div>
							<div class="pull-right">
								<a href="#" class="btn btn-default btn-flat">注销</a>
							</div>
						</li>
					</ul>
				</li>
				<!-- Control Sidebar Toggle Button -->
				<li><a href="#" data-toggle="control-sidebar"><i
						class="fa fa-gears"></i></a></li>
			</ul>
		</div>
		</nav> </header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar"> <!-- Sidebar user panel (optional) -->
		<!-- 侧导航栏用户信息 -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="images/user2-160x160.jpg" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>木西</p>
				<!-- Status -->
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>

		<!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<li class="header">导航栏</li>
			<!-- Optionally, you can add icons to the links -->
			<!-- 左侧导航栏 -->
			<li class="active"><a href="#"><i class="fa fa-area-chart"></i>
					<span>数据汇总</span></a></li>
			<li class="treeview"><a href="#"><i class="fa fa-home"></i>
					<span>首页管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="#">轮播管理</a></li>
					<li><a href="#">友链管理</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class="fa fa-pencil"></i>
					<span>博文管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="background/home.jsp#showArticles">查看所有文章</a></li>
					<li><a href="background/home.jsp#addArticle">发布文章</a></li>
					<li><a href="#"></a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class="fa fa-music"></i>
					<span>音乐管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="background/home.jsp#showPlaylist">歌单管理</a></li>
					<li><a href="#">查看歌曲</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i
					class="fa fa-pencil-square-o"></i> <span>说说管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="background/home.jsp#showTimeline">查看说说</a></li>
					<li><a href="background/home.jsp#addTimeline">发表说说</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i
					class="fa fa-commenting-o"></i> <span>留言管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="background/home.jsp#showMsgs">查看留言</a></li>
				</ul></li>
		</ul>
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>
		<!-- 左侧导航栏结束 -->
		<!-- Content Wrapper. Contains page content -->
		<!-- 内容区域 -->
		<div class="content-wrapper" style="min-height: 711px;" id="main">
			<!-- Content Header (Page header) -->
			<!-- <section class="content-header">
      <h1>
        Page Header
        <small>Optional description</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    Main content
    <section class="content">

      Your Page Content Here

    <div style="padding: 10px 0px; text-align: center;"><div class="text-muted">Excuse the ads! We need some help to keep our site up.</div><script async="" src="images/adsbygoogle.js"></script><div class="visible-xs visible-sm">AdminLTE<ins class="adsbygoogle" style="display:inline-block;width:300px;height:250px" data-ad-client="ca-pub-4495360934352473" data-ad-slot="5866534244"></ins><script>(adsbygoogle = window.adsbygoogle || []).push({});</script></div><div class="hidden-xs hidden-sm">Home large leaderboard<ins class="adsbygoogle" style="display:inline-block;width:728px;height:90px" data-ad-client="ca-pub-4495360934352473" data-ad-slot="1170479443"></ins><script>(adsbygoogle = window.adsbygoogle || []).push({});</script></div></div></section>
    /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer 底部区域-->
		<footer class="main-footer"> <!-- To the right  底部右侧-->
		<div class="pull-right hidden-xs">路漫漫其修远兮</div>
		<!-- Default to the left  默认版权--> <strong>Copyright © 2016 <a
			href="#">木西</a>.
		</strong> All rights reserved. </footer>

		<!-- Control Sidebar  右侧控制台-->
		<aside class="control-sidebar control-sidebar-dark"> <!-- Create the tabs -->
		<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
			<li class="active"><a href="#control-sidebar-home-tab"
				data-toggle="tab"><i class="fa fa-home"></i></a></li>
			<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
					class="fa fa-gears"></i></a></li>
		</ul>
		<!-- Tab panes -->
		<div class="tab-content">
			<!-- Home tab content -->
			<div class="tab-pane active" id="control-sidebar-home-tab">
				<h3 class="control-sidebar-heading">Recent Activity</h3>
				<ul class="control-sidebar-menu">
					<li><a href="javascript:;"> <i
							class="menu-icon fa fa-birthday-cake bg-red"></i>

							<div class="menu-info">
								<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

								<p>Will be 23 on April 24th</p>
							</div>
					</a></li>
				</ul>
				<!-- /.control-sidebar-menu -->

				<h3 class="control-sidebar-heading">Tasks Progress</h3>
				<ul class="control-sidebar-menu">
					<li><a href="javascript:;">
							<h4 class="control-sidebar-subheading">
								Custom Template Design <span class="pull-right-container">
									<span class="label label-danger pull-right">70%</span>
								</span>
							</h4>

							<div class="progress progress-xxs">
								<div class="progress-bar progress-bar-danger" style="width: 70%"></div>
							</div>
					</a></li>
				</ul>
				<!-- /.control-sidebar-menu -->

			</div>
			<!-- /.tab-pane -->
			<!-- Stats tab content -->
			<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
				Content</div>
			<!-- /.tab-pane -->
			<!-- Settings tab content -->
			<div class="tab-pane" id="control-sidebar-settings-tab">
				<form method="post">
					<h3 class="control-sidebar-heading">General Settings</h3>

					<div class="form-group">
						<label class="control-sidebar-subheading"> Report panel
							usage <input class="pull-right" checked="checked" type="checkbox">
						</label>

						<p>Some information about this general settings option</p>
					</div>
					<!-- /.form-group -->
				</form>
			</div>
			<!-- /.tab-pane -->
		</div>
		</aside>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg" style="position: fixed; height: auto;"></div>
	</div>
	<script src="lib/vue/vue.js"></script>
	<script src="https://cdn.bootcss.com/Director/1.2.8/director.min.js"></script>

	<!-- adminLTE App -->
	<script src="https://www.google-analytics.com/analytics.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="adminLTE/dist/js/app.min.js"></script>
	<script src="lib/requirejs/require.js"></script>
	<script src="js/require.config.js"></script>
	<script src="plugins/datepicker/bootstrap-datepicker.js"></script>


	<script>
		var main = $("#main");
		var pages = function(action, req) {
			require([ action ], function(data) {
				data(req);
			})
		};
		
		//layUi初始化
		!function() {
			//当使用了 layui.all.js，无需再执行layui.use()方法
			var from = layui.form(),
				layer = layui.layer;
		//…
		}();
	</script>
	<script src="js/router.js"></script>
</body>
</html>
