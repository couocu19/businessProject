var energyName = document.getElementsByClassName('name')[0];
var price = document.getElementsByClassName('price')[0];
var count = document.getElementsByClassName('amount')[0];
var param;

function submit(){
	param = {
		"name":energyName.value,
		"price":price.value,
		"count":count.value
	}
	console.log(energyName.value);
	console.log(price.value);
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	
	xhr.open("POST","http://www.hongyaoz.club/business/admin/addenergy.action");
	xhr.withCredentials = true;
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.send(JSON.stringify(param));
}

function callBack(data){
	if(data.code == 0){
		alert("添加成功");
		energyName.value = '';
		price.value = '';
		count.value = '';
	}else{
		alert(data.error)
	}
}