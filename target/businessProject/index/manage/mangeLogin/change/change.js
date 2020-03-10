var energyId = document.getElementsByClassName('energyId')[0];
var energyName = document.getElementsByClassName('name')[0];
var price = document.getElementsByClassName('price')[0];
var count = document.getElementsByClassName('amount')[0];
var param;

function submit(){
	param = {
		"energyId":energyId.value,
		"name":energyName.value,
		"price":price.value,
		"count":count.value
	}
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("POST","http://www.hongyaoz.club/business/admin/updateenergy.action");
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.withCredentials = true;
	xhr.send(JSON.stringify(param));
}

function callBack(data){
	if(data.code == 0){
		alert("修改成功");
		energyId.value = '';
		energyName.value = '';
		price.value = '';
		count.value = '';
	}else{
		alert(data.msg)
	}
}