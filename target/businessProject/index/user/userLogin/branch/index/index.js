var businessId = document.getElementsByClassName('num')[0];

//获取参数封装
function GetPar(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return decodeURIComponent(r[2]);
	return null;
}	
//传入参数名称（为字符串形式）
//在这里获取，用变量储存，在后续页面才能获得，否则后续子页面无法获取
var Id=GetPar("userId");

// var businessIdArr = new Array();
function submit(){
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState ==4 && xhr.status ==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("GET","http://www.hongyaoz.club/business/user/selectbusiness.action?userId="+Id);
	xhr.setRequestHeader("Content-Type",'application/json');
	xhr.withCredentials = true;
	xhr.send(null);
	
}

var len;

function callBack(data){
	if(data.code==0){
		len = data.result.length;
		for(var i = 0; i < len ; i++){
			
			if(businessId.value == data.result[i].businessId){
				window.location.href="../log/log.html?businessId="+businessId.value+"&userId="+Id;
			}else{
				alert('不存在此企业信息~');
				businessId.value = '';
			}
		}
	}
}