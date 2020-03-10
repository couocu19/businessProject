var seek = document.getElementsByName('seek');

//获取参数封装
function GetPar(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return decodeURIComponent(r[2]);
	return null;
}	
//传入参数名称（为字符串形式）
//在这里获取，用变量储存，在后续页面才能获得，否则后续子页面无法获取
Id = GetPar('businessId');

function submit(){
	if(seek[0].checked){
		window.location.href="../all/all.html?businessId="+Id;
	}else if(seek[1].checked){
		window.location.href="../seekMessage.html?businessId="+Id;
	}else{
		alert("您未选择，请重新选择")
	}
}