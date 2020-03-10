var businessName = document.getElementsByClassName('businessName')[0];
var legalPerson = document.getElementsByClassName('legalPerson')[0];
var userId = document.getElementsByClassName('userId')[0];
var type = document.getElementsByClassName('businessType')[0];

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
 
userId.value = Id;

function submit(){
	param={
		"businessName":businessName.value,
		"legalPersion":legalPerson.value,
		"type":type.value,
		"userId":Id
	};
	console.log(param);
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("POST","http://www.hongyaoz.club/business/user/addbusiness.action");
	xhr.withCredentials = true;
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.send(JSON.stringify(param));
}

function callBack(data){
	if(data.code==0){
		alert('添加成功');
		businessName.value='';
		legalPerson.value='';
		type.value='';
	}else{
		alert(data.error)
	}
}