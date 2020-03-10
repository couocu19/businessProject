var tab = document.getElementById('tab');

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

ajax();
function ajax(){
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("GET","http://www.hongyaoz.club/business/user/selectbusiness.action?userId="+Id);
	xhr.withCredentials = true;
	xhr.send(null);
}

function callBack(data){
	if(data.code==0){
		var str = "";//定义用于拼接的字符串
		var len = data.result.length;
		for(var i =0 ; i < len ; i++){
			str = "<tr><td>"+data.result[i].businessId+"</td><td>"+data.result[i].businessName+"</td><td>"+data.result[i].legalPersion+"</td><td>"+data.result[i].type+"</td></tr>"
			//追加至table中
			tab.innerHTML+=str;
		}
	}else{
		alert(data.error)
	}
}