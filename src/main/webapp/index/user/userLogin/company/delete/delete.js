var businessId = document.getElementsByClassName('num')[0];
var param;

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
console.log(Id);
 

function submit(){
	param = "businessId="+businessId.value+"&userId="+Id;
	console.log(param);
		
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("GET","http://www.hongyaoz.club/business/user/deletebusiness.action?"+param);
	xhr.withCredentials = true;
	xhr.send(null);
}

function callBack(data){
	if(data.code == 0){
		alert('删除成功');
		businessId.value = '';
	}else{
		alert(data.error)
	}
}