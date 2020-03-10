var departmentName = document.getElementsByClassName('name')[0];
var leader = document.getElementsByClassName('leader')[0];
var energy = document.getElementsByClassName('energy')[0];
var energyCount = document.getElementsByClassName('energyCount')[0];
var businessId = document.getElementsByClassName('businessId')[0];
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
businessId.value = GetPar("businessId");

function submit(){
	param = {
		"name":departmentName.value,
		"leader":leader.value,
		"energy":energy.value,
		"energyCount":energyCount.value,
		"businessId":businessId.value
	}
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("POST","http://www.hongyaoz.club/business/department/userAdd.action");
	xhr.withCredentials = true;
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.send(JSON.stringify(param));
	xhr.send(param);
}

function callBack(data){
	if(data.status == 0){
		alert('成功添加');
		departmentName.value = '';
		leader.value = '';
		energy.value = '';
		energyCount.value = '';
	}else{
		alert(data.msg)
	}
}