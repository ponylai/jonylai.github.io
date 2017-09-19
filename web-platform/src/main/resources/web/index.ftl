<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<!-- 固定水平菜单栏js start -->   
	<script>    
        // 定义菜单栏离页面顶部的距离，默认为200    
        var divOffsetTop = 200;    
        //滚动事件    
        window.onscroll=function(){    
            var WidthMenuId = document.getElementById("WidthMenuId");    
            // 计算页面滚动了多少（需要区分不同浏览器）    
            var topVal = 0;    
            if(window.pageYOffset){//这一条滤去了大部分， 只留了IE678    
                topVal = window.pageYOffset;    
            }    
            else if(document.documentElement.scrollTop ){//IE678 的非quirk模式    
                topVal = document.documentElement.scrollTop;    
            }    
            else if(document.body.scrolltop){//IE678 的quirk模式    
                topVal = document.body.scrolltop;    
            }    
            if(topVal <= divOffsetTop){    
                WidthMenuId.style.position = "";    
            }    
            else {    
                WidthMenuId.style.position = "fixed";    
                WidthMenuId.style.width = "100%";   
                WidthMenuId.style.top = 0;   
            }    
        };    
        // 页面加载完之后，计算菜单栏到页面顶部的实际距离    
        window.onload=function(){    
            var WidthMenuId = document.getElementById("WidthMenuId");    
            divOffsetTop = WidthMenuId.offsetTop;    
        };    
    </script>
    <!-- 固定水平菜单栏js end -->       
    <title>17趣游网</title>
    <link rel="icon" type="image/x-icon" href="/images/favicon.ico">
    <link href="/css/base.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">
    <link href="/css/foot.css" rel="stylesheet">
    <link href="/css/right.css" rel="stylesheet">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/left.css" rel="stylesheet">
   	<script type="text/javascript"
src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" charset="utf-8" data-callback="true"></script>
</head>
<body>
    <!-- 头部 start-->
    <div class="m-nav">
        <div class="m-link-box">
            <ul class="nav-tools">
            	<li class="link-btn">
                    <span id="user-label"></span>
                </li>
                <li class="link-btn">
                    <a href="/toLogin" >账号登录</a>
                </li>           
                <li class="link-btn">
                    <a href="/toRegister" >免费注册</a>
                </li>
                <li class="link-btn">
                    <a href="/helper" target="_blank">帮助与支持</a>
                </li>
                <li class="link-btn">
                    <a href="/toUserCenter" target="_blank">个人中心</a>
                </li>
                <li class="link-btn">
                    <a href="/logout" >退出</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="m-header">
        <div class="m-inner">
            <div class="logo"><a href="/" title="返回首页"></a></div>
        </div>
    </div>

    <!-- 头部 end-->

    <!-- 固定水平菜单栏 start-->
    <div id="WidthMenuId" class="fixed-menu-box">
       <div class="fixed-menu">
          <div class="link">
              <a href="/toWall" target="_blank">首页</a>
          </div>
          <div class="link">
              <a href="/toPhoto" target="_blank">照片PK</a>
          </div>
          <div class="link">
              <a href="/toMyWish" target="_blank">我的心愿</a>
          </div>
        <div class="link">
           <a href="/toWall" target="_blank">谁留下的心愿</a>
        </div>   
        <div class="link">
           <a href="/selectVideo" target="_blank">搜视屏</a>
        </div>
        <div class="link">
           <a href="/selectPhoto" target="_blank">搜照片</a>
        </div>
        <div class="link">
           <a href="/toStrategy" target="_blank">搜旅游攻略</a>
        </div>  
        <div class="link">
           <a href="/city" target="_blank">我的测试菜单</a>
        </div>  
   </div>
</div> 
<!-- 固定水平菜单栏 end-->

<!-- 中间内容 start-->
<div class="index-content">
   <!-- 中间内容的左边固定菜单栏 start-->
   <div class="left-fixd-menu">
    <div class="index-nav-wrap">
        <div class="index-nav-list">
            <ul>
                <li><a href="/toPhoto" target="_blank" class="index-nav-item curr">照片分享</a>
                </li>
                <li><a href="/toVideo" target="_blank" class="index-nav-item curr">视频分享</a>
                </li>
                <li><a href="/toGoddess" target="_blank" class="index-nav-item curr">旅游达人</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- 中间内容的左边固定菜单栏 end-->

<!-- 中间内容的右边  start-->
<div class="right-content" id="right-content-id">

</div>
<!-- 中间内容的右边  end-->
</div>
<!-- 中间内容 end-->

<!-- 右边 start-->
<div class="right-consult-default">
    <a href="/helper" target="_blank" class="js-clickRightConsult zx-teacher" title="遇到问题点我帮你"></a>
    <div class="yesMentor-box" style="display: none;">
        <dl class="js-clickRightConsult" style="cursor: pointer;">
            <dt class="at"></dt>
            <dd class="name"></dd>
        </dl>
    </div>
</div>
<!-- 右边 end-->

<!-- 尾部 start-->
<div class="m-footer">
    <div class="m-inner">
        <div class="w-fl-left">
            <div class="copyright">
                <p>Copyright © 2017-2020 17quyou Corporation. All Rights Reserved.</p>
              <!--  <p>ICP证沪B2-20150026 沪ICP备13031855号-2 <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010502032354" target="_blank" style="color:#999"><img src="https://cdn.17zuoye.com/static/project/icp-beian.png" style="display: inline-block;vertical-align: middle;">京公网安备 11010502032354号</a></p>
				-->
            </div>
            
     </div>
     <div class="m-foot-link w-fl-right">
        <div class="w-fl-left">
            <a href="/helper" target="_blank">关于我们</a>
            <a href="/helper" target="_blank">用户声音</a>
            <a href="/helper" target="_blank">诚聘英才</a>
            <a href="/helper" target="_blank">隐私保护</a>
        </div>
        <div class="w-fl-left">
            <a href="/helper" target="_blank">新闻中心</a>
            <a href="/helper" target="_blank">课题相关</a>
            <a href="/helper" target="_blank">帮助中心</a>
            <a href="/helper" target="_blank">用户协议</a>
        </div>
        <div class="m-code">
            <p class="c-image"></p>
            <p class="c-title">关注我们</p>
        </div>
    </div>
</div>
</div>

<!--尾部 end -->

</body>
<script src="/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script>
	 $.ajax({
	 	url: '/api/getAllWish',
	 	type: 'GET',
	 	dataType: 'json'
	 })
	 .done(function(respone) {
	 	var historyArr = respone.wishList;
	 	var str = ""
	 	for(var index in historyArr){
	 		var item = historyArr[index];
//	 		str +='<div>'
	 		str +=''
	 			+'<div class="select-content">'
	 			+'<img src="/images/demo.jpg" />'
				+'<p class="select-name">'+ '测试照片' +'</p>'
	 		    +'</div>'
//	 		    +'<div class="select-content">'+'<img src="/images/demo.jpg" />' 
//				+'<p class="select-name">'+ 'aaaa' +'</p>'
//	 		    +'</div>'
//	 		    +'</div>';
	 	}
	 	$('#right-content-id').append(str);
	 });
	 
	 
	  $.ajax({
	 	url: '/api/getUser',
	 	type: 'GET',
	 	dataType: 'json',
	 	async: false,  
        success: function(data){
        	if(data.resultCode =="000000"){
        	var user = data.user;
	 		var userName = user.userName;
	 		$('#user-label').text(userName);
        	}
        }
	 });

</script>

<script type="text/javascript">
    QC.Login({
       btnId:"qqLoginBtn"    //插入按钮的节点id
});
</script>
</html>