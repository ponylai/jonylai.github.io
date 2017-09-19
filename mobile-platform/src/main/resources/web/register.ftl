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
</head>
<body>
	<div id="form-header" class="header">
		<div class="logo-con w clearfix">

			<div class="logo-title">欢迎注册</div>
			<div class="have-account">已有账号？ <a href="/toLogin">请登录</a></div>
		</div>

	</div>
	<div class="content w">
		<div class="main clearfix">
			<div class="reg-form fl">
					<div class="form-item form-item-account" id="form-item-account">
						<label>帐号</label>
						<input type="text" id="account" name="regName" class="field" autocomplete="off" maxlength="20" placeholder="您的账户名和登录名">

					</div>
					<div class="form-item form-item-password" id="form-item-password">
						<label>密码</label>
						<input type="password" id="onePassWord" name="password" class="field" autocomplete="off" maxlength="20" placeholder="输入你的密码">
					</div>
					<div class="form-item form-item-password" id="form-item-password">
						<label>确认密码</label>
						<input type="password" id="twoPassWord" name="password" class="field" autocomplete="off" maxlength="20" placeholder="输入你的密码">
					</div>
					<div class="form-item form-item-password" id="form-item-password">
						<label>姓名</label>
						<input type="text" id="chineseName" name="chineseName" class="field" autocomplete="off" maxlength="20" placeholder="姓名">
					</div>
					<div class="form-item form-item-password" id="form-item-password">
						<label>手机号码</label>
						<input type="text" id="phone" name="phone" class="field" autocomplete="off" maxlength="20" placeholder="手机号码">
					</div>
					<div class="form-item form-item-password" id="form-item-password">
						<label>邮箱</label>
						<input type="text" id="email" name="email" class="field" autocomplete="off" maxlength="20" placeholder="邮箱">
					</div>
					
					<div class="form-agreen">
						<div>
							<input type="checkbox" name="agreen" checked="">我已阅读并同意
							<a href="javascript:;" id="protocol">《用户注册协议》</a>
						</div>
						<div class="input-tip">
							<span></span>
						</div>
						
					</div>
					<div>
							<!-- <button  class="btn-register" onclick="register()">立即注册</button> -->
							<input type="button" class="btn-register" onclick="register();" value="立即注册" />
					</div>
		
			</div>
			<div id="form-company" class="reg-other">
				<div class="inter-cust">
					<a href="" target="_blank" clstag="pageclick|keycount|201612011|4">
						<i class="i-global"></i>
						<span>INTERNATIONAL<br>CUSTOMERS</span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div id="form-footer" class="footer w">
		<div class="links">
			<a rel="nofollow" target="_blank" href="/helper">关于我们</a>|
			<a rel="nofollow" target="_blank" href="/helper">联系我们</a>|
			<a rel="nofollow" target="_blank" href="/helper">人才招聘</a>|
			<a rel="nofollow" target="_blank" href="/helper">商家入驻</a>|
			<a rel="nofollow" target="_blank" href="/helper">广告服务</a>|
			<a rel="nofollow" target="_blank" href="/helper">手机浏览</a>|
			<a target="_blank" href="/helper">友情链接</a>|
			<a target="_blank" href="/helper">销售联盟</a>|
			<a href="/helper" target="_blank">我们的社区</a>|
			<a href="/helper" target="_blank">我们的公益</a>|
			<a target="_blank" href="/helper" clstag="pageclick|keycount|20150112ABD|9">English Site</a>
		</div>
		<div class="copyright">
			Copyright©2004-2016&nbsp;&nbsp;aichun.name&nbsp;版权所有
		</div>
	</div>
	
	
</body>
<script src="/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

function register(){

 	var userName = $("#account").val(); 
 	var onePassWord = $("#onePassWord").val();
 	var twoPassWord = $("#twoPassWord").val();
 	if(onePassWord!=twoPassWord){
 		alert("两次输入密码不一致");
 		return;
 	}
 	var phone = $("#phone").val(); 
 	var email = $("#email").val(); 
 	var chineseName = $("#chineseName").val(); 
 	var jsonreq = {"userName":userName,"password":twoPassWord,"phone":phone,"email":email,"chineseName":chineseName};

 			$.ajax({  
            type: "post",  
            url: "/register",
            contentType: "application/json; charset=utf-8", //必须有  
            dataType: "json", //表示返回值类型，不必须 
            async: false,
            data: JSON.stringify(jsonreq),     
            success: function(data){
            	   if(data.resultCode =="000000"){		
            //start....................
            $.ajax({  
            type: "post",  
            url: "/login", 
            data : {
                    username:userName,       
                    password:twoPassWord 
                },
            async: false,  
            success: function(data){
            	    if(data.resultCode =="999999"){
            	     	 window.location.href="/index";
            	     		}
            	     		}
            });     
           //end..........................

            	     		}else{
            	     	 alert("注册失败");			
            	     				} 	
            	    }
            });     
		
}
</script>
</html>