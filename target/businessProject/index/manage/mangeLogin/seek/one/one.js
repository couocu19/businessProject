var energyId = document.getElementsByClassName('num')[0];
var param;
var main = document.getElementsByClassName('main')[0];

function submit(){
	param = energyId.value;
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("GET","http://www.hongyaoz.club/business/admin/selectenergy.action?energyid="+param);
	xhr.withCredentials = true;
	xhr.send(null);
}

function callBack(data){
	var str = "";
	if(data.code == 0){
		if(data.result != null){
			main.innerHTML = "";
			str+= "<div class='id' >编号：<input readonly='readonly' value='"+data.result.energyId+"' /></div>"+"<div class='count'>总量：<input readonly='readonly' value='"+data.result.count+" '/></div>" +"<div class='name'>名称：<input readonly='readonly' value='"+data.result.name+"' /></div><div class='price'>价格：<input readonly='readonly' value='"+data.result.price+"' /></div>"
			main.innerHTML+=str;
		}else{
			alert('您所查询的能源不存在~');
			energyId.value = '';
		}
	}else{
		alert('查询失败');
	}
}