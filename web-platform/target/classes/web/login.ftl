<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<title>17趣游网</title>
	<link rel="icon" type="image/x-icon" href="/images/favicon.ico">
	<meta name="description" content="">
	<meta name="keywords" content="">
	<link href="/css/base.css" rel="stylesheet">
	<link href="/css/style.css" rel="stylesheet">
	<link href="/css/login.css" rel="stylesheet">
	<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-appid="1106019799" data-redirecturi="http://localhost:8088/third/qq" charset="utf-8"></script>
	<script type="text/javascript"
src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" charset="utf-8" data-callback="true"></script>
</head>
<body  onkeydown="keyDownLogin();">
	<div id="form-header" class="header">
	
	
		<div class="logo-con w clearfix">
			<!--<a href="//en.qj.com/" class="logo">
			</a>-->
			<div class="logo-title">17趣游网</div>
		</div>

	</div>
	<div class="content">
		<div class="login-wrap">
			<div class="w">
				<div class="login-form">
					<div class="login-tab login-tab-r">
						<a href="javascript:void(0)" clstag="pageclick|keycount|201607144|2" class="checked" style="outline: rgb(109, 109, 109) none 0px;">账户登录</a>
					</div>
					<div class="login-box" style="display: block; visibility: visible;">
						<div class="mt tab-h">
						</div>
						<div class="msg-wrap">
							<div class="msg-error" style="display: none">错误提示<b></b></div>
						</div>
						<div class="mc">
							<div class="form">
								<form id="formlogin" method="post" onsubmit="return false;">
									<input type="hidden" id="uuid" name="uuid" value="">

									<div class="item item-fore1">
										<label for="loginname" class="login-label name-label"></label>
										<input id="loginname" type="text" class="itxt" name="username" tabindex="1" autocomplete="off" placeholder="用户名/手机/邮箱">
										<span class="clear-btn"></span>
									</div>

									<div id="entry" class="item item-fore2" style="visibility: visible;">
										<label class="login-label pwd-label" for="nloginpwd"></label>
										<input type="password" id="nloginpwd" name="password" class="itxt itxt-error" tabindex="2" autocomplete="off" placeholder="密码">
										<span class="clear-btn"></span>
										<span class="capslock" style="display: none;"><b></b>大小写锁定已打开</span>
									</div>

									<div class="item item-fore4">
										<span id="user-tips" class="forget-pw-safe" style="color:red"></span>
									</div>

									<div class="item item-fore5">
										<div class="login-btn">
											<a href="javascript:login();" class="btn-img btn-entry" id="loginsubmit" tabindex="6" clstag="pageclick|keycount|201607144|3">登&nbsp;&nbsp;&nbsp;&nbsp;录</a>
										</div>
									</div>
									
									<span class="forget-pw-safe">
									<a href="/helper" class="" target="_blank" clstag="pageclick|keycount|201607144|3">忘记密码</a>
									</span>
									<span class="forget-pw-safe">
									<a href="/toRegister" class="" target="_blank" clstag="pageclick|keycount|201607144|3">免费注册</a>
									</span>
									
									<span id="qqLoginBtn"></span>

								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="login-banner" style="background-color: #e93854">
					<div class="w">			         
						<div id="banner-bg" clstag="pageclick|keycount|20150112ABD|46" class="i-inner" style="background: url("") 0px 0px no-repeat;background-color: #e93854"></div>
					</div>		           	
				</div>
			</div>
		</div>
	</div>
	<div id="form-footer" class="footer w">
		<div class="links">
			<a rel="nofollow" target="_blank" href="http://blog.csdn.net/omrlai1"> 关于我们</a>|
			<a rel="nofollow" target="_blank" href="http://blog.csdn.net/omrlai1">联系我们</a>|
			<a rel="nofollow" target="_blank" href="http://blog.csdn.net/omrlai1">人才招聘</a>|
			<a rel="nofollow" target="_blank" href="http://blog.csdn.net/omrlai1">广告服务</a>|
			<a target="_blank" href="http://blog.csdn.net/omrlai1">友情链接</a>|
			<a href="http://blog.csdn.net/omrlai1" target="_blank">社区</a>|
			<a href="http://blog.csdn.net/omrlai1" target="_blank">公益</a>|
			<a target="_blank" href="http://blog.csdn.net/omrlai1" clstag="pageclick|keycount|20150112ABD|9">English Site</a>
		</div>
		<div class="copyright">
			Copyright©20014-2027&nbsp;&nbsp;aichun.vip&nbsp;版权所有
		</div>
	</div>


</body>
<script src="/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

function keyDownLogin(){
var username = $("#loginname").val(); 
 	var passwd = $("#nloginpwd").val();
 	if(!username){
 		return;
 		}
 	if(!passwd){
 		return;
 		}
if (event.keyCode==13) {
 	
 $.ajax({  
            type: "post",  
            url: "/login", 
            data : {//post请求参数  
                    username:username,       
                    password:passwd 
                },
            async: false,  
            success: function(data){
					 
            	     if(data.resultCode =="999999"){
            	     	 window.location.href="/";
            	     		}
            	     if(data.resultCode =="000000"){
            	     	 $("#user-tips").text("用户名或密码不对");
            	     	 setTimeout(function(){$("#user-tips").text("")},2000); 
            	     		} 	
                    	},
            error: function(data){
                    	   $("#user-tips").text("登录异常,请稍后再试");	
                    	   setTimeout(function(){$("#user-tips").text("")},2000); 
                    	}		
            });     
		
}else{
	return;
}
}

function login(){
 	var username = $("#loginname").val(); 
 	var passwd = $("#nloginpwd").val();
 	if(!username){
 		return;
 		}
 	if(!passwd){
 		return;
 		}
 	
 $.ajax({  
            type: "post",  
            url: "/login", 
            data : {//post请求参数  
                    username:username,       
                    password:passwd 
                },
            async: false,  
            success: function(data){
            
            	    if(data.resultCode =="999999"){
            	     	 window.location.href="/";
            	     		}
            	     if(data.resultCode =="000000"){
            	     	 $("#user-tips").text("用户名或密码不对");
            	     	 setTimeout(function(){$("#user-tips").text("")},2000); 
            	     		} 	
                    	},
            error: function(data){
                    	 $("#user-tips").text("登录异常,请稍后再试");
                    	 setTimeout(function(){$("#user-tips").text("")},2000); 	
                    	 
                    	}		
            });     
		
}
</script>
<script type="text/javascript">
   //调用QC.Login方法，指定btnId参数将按钮绑定在容器节点中
   QC.Login({
       //btnId：插入按钮的节点id，必选
       btnId:"qqLoginBtn",    
       //用户需要确认的scope授权项，可选，默认all
       scope:"all",
       //按钮尺寸，可用值[A_XL| A_L| A_M| A_S|  B_M| B_S| C_S]，可选，默认B_S
       size: "B_S"
   }, function(reqData, opts){//登录成功
       //根据返回数据，更换按钮显示状态方法
       var dom = document.getElementById(opts['btnId']),
       _logoutTemplate=[
            //头像
            '<span><img src="{figureurl}" class="{size_key}"/></span>',
            //昵称
            '<span>{nickname}</span>',
            //退出
            '<span><a href="javascript:QC.Login.signOut();">退出</a></span>'    
       ].join("");
       dom && (dom.innerHTML = QC.String.format(_logoutTemplate, {
           nickname : QC.String.escHTML(reqData.nickname), //做xss过滤
           figureurl : reqData.figureurl
       }));
   }, function(opts){//注销成功
         alert('QQ登录 注销成功');
   }
);
</script>
</html>