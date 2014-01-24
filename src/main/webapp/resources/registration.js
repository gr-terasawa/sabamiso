var newUserId;
var addUrl = "user/add";
var deleteUrl = "user/delete";
var updateUrl = "user/update";

function setUpdateForm(element){
	newUserId = document.userForm.userId.value;
	trElement = document.getElementById(element);
	document.userForm.userId.value = element;
	document.userForm.userName.value = trElement.children[1].innerHTML;
	document.userForm.password.value = trElement.children[2].innerHTML;
	document.userForm.nickname.value = trElement.children[3].innerHTML;
	document.userForm.companyId.value = trElement.children[4].innerHTML;
	//	changeSelectValue(document.userForm.sex, trElement.children[3].innerHTML);
	document.userForm.newUser.disabled = false;
	document.userForm.deleteUser.disabled = false;
	document.userForm.action = projectUrl + updateUrl;
}

function setAddForm(){
	document.userForm.userId.value = newUserId;
	document.userForm.userName.value = "";
	document.userForm.password.value = "";
	document.userForm.nickname.value = "";
	document.userForm.companyId.value = "";
//	changeSelectValue(document.userForm.sex, "Male");
	document.userForm.newUser.disabled = true;
	document.userForm.deleteUser.disabled = true;
	document.userForm.action = projectUrl + addUrl;
}

function setDeleteForm() {
	document.userForm.action = projectUrl + deleteUrl;
	return true;
}

