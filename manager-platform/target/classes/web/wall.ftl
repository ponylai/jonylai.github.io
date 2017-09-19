<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<title>17趣游网</title>
	<link rel="icon" type="image/x-icon" href="/images/favicon.ico">
	<link href="/css/base.css" rel="stylesheet">
	<link href="/css/main.css" rel="stylesheet">
</head>
<body>
<!-- 中间内容 start-->
	<div class="wall-content" id="Jwall" align="center">
		<div id="JearchBox" style="position: absolute; z-index: 1000000; left: 405px; top: 50px; background-color: rgb(62, 148, 254);">
            <span style="color:#fff;">&nbsp;&nbsp;纸条号：</span><input type="text" id="JsearchText" style="width:100px;height:22px;">
            <a id="JbtnSearch" class="btn blue"><i class="iconfont icon-mamaosusuo" style="font-size:18px;font-style:normal; vertical-align:bottom;height:30px;line-height:30px;"></i>&nbsp;搜索</a>
        </div>
        <div style="position:absolute;z-index:1000000;left:100px;top:50px;">
            <a href="/api/toAdd" target="_blank" class="btn blue"><i class="iconfont icon-jiahao" style="font-size: 18px; font-style: normal; vertical-align: bottom; height: 30px; line-height: 30px;"></i>&nbsp;我要贴纸条</a>
        </div>
			
	</div>
<!-- 中间内容 end-->

</body>
<script src="/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script>
	var levelNum = 10;//临时统计层级
	$.ajax({
		url: '/api/getAllWish.do',
		type: 'GET',
		dataType: 'json'
	})
	.done(function(respone) {
		var historyArr = respone.wishList;
		var str = ""
		for(var index in historyArr){
			var item = historyArr[index];
			var offsetLeft = Math.floor(Math.random() * ($('#Jwall').width() - 205));
			var offsetTop = Math.floor(Math.random() * ($('#Jwall').height() - 205));
			str += '<div class="lovewall-panel JloveWallPanel" id="JWallPanel" ' + item.id + ' style="cursor: move; z-index: 10; left: ' + offsetLeft + 'px; top: ' + offsetTop + 'px; background-color: ' + item.color + '"> <div class="lovewall-panel-header"> 第' + item.id + '条&nbsp;&nbsp;&nbsp;' + item.createTime + ' </div> <div clasid="lovewall-panel-body"> ' + item.content + ' </div> </div>'
		}
		$('#Jwall').append(str);
	});

	$('#JbtnSearch').click(function(event) {
		var searchId = $('#JsearchText').val();
		if(!searchId){
			return;
		}
		 	var postData={};
         	postData["ID"]=searchId;
		 	$.post('/getWish.do', postData, function (result) {     
              if (result.result =="01") {
                  var _str = '您的祝福纸条为：第'  + result.wish.id +'条' 
                  + ' 创建时间：' +result.wish.createTime
                  + ' 内容：'+ result.wish.content
                  + ' 背景：'+ result.wish.color;
              	alert(_str);                
              }
          });
	});

	

    var dragging = false;
    var iX, iY;
    var dragObj;
	$('#Jwall').on('mousedown', '.JloveWallPanel', function(e) {
		var newLevelNum = levelNum + 1;
		$(this).css("z-index", newLevelNum);
		levelNum = newLevelNum;

		dragObj = $(this);
     	dragging = true;
        iX = e.clientX - this.offsetLeft;
        iY = e.clientY - this.offsetTop;
        this.setCapture && this.setCapture();
        return false;
	});
    document.onmousemove = function(e) {
        if (dragging) {
        var e = e || window.event;
        var oX = e.clientX - iX;
        var oY = e.clientY - iY;
        dragObj.css({"left":oX + "px", "top":oY + "px"});
        return false;
        }
    };
    $(document).mouseup(function(e) {
        dragging = false;
        dragObj[0].releaseCapture();
        e.cancelBubble = true;
    })

</script>
</html>