var energyId = document.getElementsByClassName('num')[0];
var param;


function submit(){
	param = "energyid="+energyId.value;
	console.log(param);
	console.log(energyId.value);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("GET","http://www.hongyaoz.club/business/admin/deleteenergy.action?"+param);
	xhr.withCredentials = true;
	xhr.send(null);
}

function callBack(data){
	if(data.code == 0){
		alert('删除成功');
		energyId.value = '';
	}else{
		alert(data.error)
	}
}