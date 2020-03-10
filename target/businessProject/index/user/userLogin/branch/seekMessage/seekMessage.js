var id = document.getElementsByClassName('num')[0];
var main = document.getElementsByClassName('main')[0];

var param;

function submit(){
	param = "id="+id.value;
	console.log(param);
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("GET","http://www.hongyaoz.club/business/department/getInfo.action?id="+id.value);
	xhr.withCredentials = true;
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.send(null);
}

var str = '';
function callBack(data){
	if(data.status == 0){
		main.innerHTML = '';
		str+= "<div class='id' >部门编号：<br/><input readonly='readonly' value='"+data.data.id+"' /></div>"+"<div class='name'>部门名称：<br/><input readonly='readonly' value='"+data.data.name+" '/></div>" +"<div class='energy'>所用能源：<br/><input readonly='readonly' value='"+data.data.energy+"' /></div><div class='energyId'>能源编号：<br/><input readonly='readonly' value='"+data.data.energyId+"' /></div>"+"<div class='leader'>部门负责人：<br/><input readonly='readonly' value='"+data.data.leader+"' /></div>"+"<div class='energyCount'>能源需求量：<br/><input readonly='readonly' value='"+data.data.energyCount+"'/></div>"
		main.innerHTML+=str;
	}else{
		alert(data.msg);
	}
}