var id = document.getElementsByClassName('num')[0];
var main= document.getElementsByClassName('main')[0];
var param;

function submit(){
	param = "id="+id.value;
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("GET","http://www.hongyaoz.club/business/department/getEnergyInfo.action?id="+id.value);
	xhr.withCredentials = true;
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.send(null);
}

var str = '';

function callBack(data){
	if(data.status == 0){
		main.innerHTML = '';
		str+= "<div class='id' >能源编号：<input readonly='readonly' value='"+data.data.energyId+"'/></div>"+"<div class='count'>能源需求：<input readonly='readonly' value='"+data.data.count+" '/></div>" +"<div class='name'>能源名称：<input readonly='readonly' value='"+data.data.name+"' /></div><div class='price'>能源价格：<input readonly='readonly' value='"+data.data.price+"' /></div>"
		main.innerHTML+=str;
	}else{
		alert(data.error);
	}
}