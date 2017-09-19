<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<title>17趣游网</title>
	<link rel="icon" type="image/x-icon" href="/images/favicon.ico">
    <link rel="icon" type="image/x-icon" href="/images/favicon.ico">
    <link href="/css/base.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">

    <style type="text/css">
        .bg-selector {
            display: inline-block;
            width: 34px;
            height: 34px;
            margin: 3px;
            border: 1px solid #000;
            cursor:pointer;
        }
    </style>

</head>
<body>
    <div class="kui-layout" style="width:100%; height:100%;position:fixed;background-color:#fff;">
        <div center=":center" style="width:1100px;height:100%;top:50px;">
            <div id="preview" class="lovewall-panel" style="left: 150px;z-index:999;">
                <div class="lovewall-panel-header">
                    第10000条&nbsp;&nbsp;&nbsp;2017-03-20 12:43
                </div>
                <div class="lovewall-panel-body">
                </div>
            </div>
            <div style="position:absolute;left:50px; top:230px;">
                选择背景颜色
            </div>
            <div style="position:absolute;left:143px;top:170px;">
                <div>
                    <span class="bg-selector" style="background-color: #ffffff;" color="#ffffff"></span>
                    <span class="bg-selector" style="background-color: #ffffcc;" color="#ffffcc"></span>
                    <span class="bg-selector" style="background-color: #ffcc33;" color="#ffcc33"></span>
                    <span class="bg-selector" style="background-color: #ccff99;" color="#ccff99"></span>
                    <span class="bg-selector" style="background-color: #ff4b1c;" color="#ff4b1c"></span>
                </div>
                <div>
                    <span class="bg-selector" style="background-color: #ffcccc;" color="#ffcccc"></span>
                    <span class="bg-selector" style="background-color: #ff9999;" color="#ff9999"></span>
                    <span class="bg-selector" style="background-color: #66ff99;" color="#66ff99"></span>
                    <span class="bg-selector" style="background-color: #669999;" color="#669999"></span>
                    <span class="bg-selector" style="background-color: #cc99cc;" color="#cc99cc"></span>
                </div>
                <div>
                    <span class="bg-selector" style="background-color: #cc9966;" color="#cc9966"></span>
                    <span class="bg-selector" style="background-color: #33ccff;" color="#33ccff"></span>
                    <span class="bg-selector" style="background-color: #eeeeee;" color="#eeeeee"></span>
                    <span class="bg-selector" style="background-color: #ff8dde;" color="#ff8dde"></span>
                    <span class="bg-selector" style="background-color: #fffa48;" color="#fffa48"></span>
                </div>
            </div>
            <div style="position:absolute;left:143px;top:330px;">
                QQ：375113044
            </div>
            <div style="position:absolute;left:470px;top:80px;">
                <div>输入你的祝福纸条内容</div>
                <div>还能输入&nbsp;<span id="remLen" style="color:red;font-size:14px;font-weight:bold;">300</span>&nbsp;个字</div>
            </div>
            <div style="position:absolute;left:600px;top:0;">
                <textarea id="post-content" maxlength="300" style="background-color: #fffbc5;" cols="50" rows="7" onkeydown="textCounter();" onkeyup="textCounter();" wrap="physical"></textarea>
                
            <div class="form-group">  
   <label>验证码 </label> 
   <input name="j_code" type="text" id="kaptcha" maxlength="4" class="form-control" />
   <br/> 

        <img alt="验证码" onclick = "this.src='/code?d='+new Date()*1" src="/code"/>    
			</div>
			         
                <div style="margin:10px 0 0 0;">
                    <a id="btnFabu" class="btn">发布</a>
                </div>
                <div id="tips" style="display: none;">
        		</div>
            </div>
            <div style="position: absolute; left: 600px; top: 300px; width: 336px; height: 151px; width: 336px; height: 151px;border:1px solid #ccc;padding:20px 10px 0 10px;line-height:22px;">
                <div>
                    &nbsp;&nbsp;&nbsp;&nbsp; 一、发布的祝福纸条永久免费,永久珍藏。记住您的祝福纸条号码可以随时查看。
                </div>
                <div style="margin: 10px 0 0 0"">
                    &nbsp;&nbsp;&nbsp;&nbsp; 二、请勿发布有违法律、道德、公序良俗以及任何本站认为不适合发布的信息。本站保留随时删除此类纸条的权利。删除这些纸条之前不会通知发布人。
                </div>
            </div>
        </div>
    </div>

    <script src="/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script type="text/javascript"> 
	$(function(){  //生成验证码         
   		$('#kaptchaImage').click(function () {  
    	$(this).hide().attr('src', '/code?' + Math.floor(Math.random()*100) ).fadeIn(); });      
	});   

	window.onbeforeunload = function(){  
    //关闭窗口时自动退出  
    if(event.clientX>360&&event.clientY<0||event.altKey){     
        alert(parent.document.location);  
    }  
};  
  		  
	function changeCode() {  //刷新
    $('#kaptchaImage').hide().attr('src', '/code?' + Math.floor(Math.random()*100) ).fadeIn();  
    event.cancelBubble=true;  
}  
	</script> 
    <script type="text/javascript">
        var bgColor = '#ff4b1c';
        function textCounter() {
            if ($("#post-content").val().length > 300) {
                $("#remLen").html('0');
                $("#post-content").val($("#post-content").val().substr(0, 300));
            }
            else {
                $("#remLen").html(300 - $("#post-content").val().length);
            }
            $('#preview .lovewall-panel-body').html($("#post-content").val());
        }
        $(function () {
            $('#preview').css('background-color', bgColor);
            $("#post-content").val('');//浏览器会记住内容.
            $('.bg-selector').click(function () {
                bgColor = $(this).attr('color');
                $('#preview').css('background-color', bgColor);
            });
            $('#btnFabu').click(function () {
                var _content = $("#post-content").val();
                if (_content == null || _content == undefined || _content == '') {
                    $("#tips").css('display','block');
                    	var divshow = $("#tips");
                		divshow.text("心愿不能没有内容");// 清空数据
                		divshow.append(data); // 添加Html内容，不能用Text 或 Val
                    	setTimeout(function(){
                        $("#tips").css('display','none');
                    	},2000);       
                    return;
                }
                if ($("#kaptcha").val() == "") {
                $("#tips").css('display','block');
                    	$("#tips").innerHTML = "验证码不能为空";
                    	setTimeout(function(){
                        $("#tips").css('display','none');
                    	},2000);                 
        			return ;
        		}
        		var jsonreq = {"color":bgColor,"content":_content,"code":$("#kaptcha").val()};
        		$.ajax({  
            type: "post",  
            url: "/api/add",  
            contentType: "application/json; charset=utf-8", //必须有  
            dataType: "json", //表示返回值类型，不必须 
            async: false,
            data: JSON.stringify(jsonreq),   
            success: function (data) {
            	//alert(data.wish.id+","+data.resultCode+","+data.resultMsg);
                   if (data.resultCode=="000000") {
                    	$("#tips").css('display','block');
                    	$("#tips").innerHTML = "发布成功，等待审核.你的心愿号是:"+data.wish.id+","+"请记住，方便下次查询";
                    	setTimeout(function(){
                        $("#tips").css('display','none');
                    	},2000);                 
                    }else{                
                    	$("#tips").css('display','block');
                    	$("#tips").innerHTML = data.resultMsg;
                    	setTimeout(function(){
                        $("#tips").css('display','none');
                    	},2000);                  
                    }
            },
            error: function (data) {  
                		$("#tips").css('display','block');
                		$("#tips").innerHTML = data.resultMsg;
                    	setTimeout(function(){
                        $("#tips").css('display','none');
                    	},2000); 
            }  
            });
                
            });
        });
    </script>
        <div id="_tongjiscipts" style="display:none;">
    </div>

</body>
</html>
