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
Id = GetPar('businessId');
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
	xhr.open("GET","http://www.hongyaoz.club/business/department/getDepartments.action?businessId="+Id);
	xhr.withCredentials = true;
	xhr.send(null);
}

function callBack(data){
	if(data.status==0){
		var str = "";//定义用于拼接的字符串
		var len = data.data.length;
		console.log(len);
		if(len == 0){
			alert('无部门信息~');
		}else{
			for(var i =0 ; i < len ; i++){
				str = "<tr><td>"+data.data[i].id+"</td><td>"+data.data[i].name+"</td><td>"+data.data[i].energy+"</td><td>"+data.data[i].energyId+"</td><td>"+data.data[i].leader+"</td><td>"+data.data[i].energyCount+"</td></tr>";
				//追加至table中
				tab.innerHTML+=str;
			}
		}
	}else{
		alert(data.error)
	}
}