var departmentName = document.getElementsByClassName('name')[0];
var energy = document.getElementsByClassName('energy')[0];
var energyCount = document.getElementsByClassName('energyCount')[0];
var leader = document.getElementsByClassName('leader')[0];
var id = document.getElementsByClassName('id')[0];

var param;

function submit(){
	param = {
		"name":departmentName.value,
		"energy":energy.value,
		"leader":leader.value,
		"energyCount":energyCount.value,
		"id":id.value
	}
	var xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var jsonObj = xhr.responseText;
			var jsonText = JSON.parse(jsonObj);
			callBack(jsonText);
		}
	}
	xhr.open("POST","http://www.hongyaoz.club/business/department/userUpdate.action");
	xhr.withCredentials = true;
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.send(JSON.stringify(param));
}

function callBack(data){
	if(data.status == 0){
		alert('修改成功');
		departmentName.value = '';
		energy.value = '';
		energyCount.value = '';
		leader.value = '';
		id.value = '';
	}else{
		alert(data.msg);
	}
}