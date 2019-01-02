$(function(){
	$("#btnSubmit").click(function(){
		if(!checkName())
		{
			return false;
		}
		if(!checkPassword())
		{
			return false;
		}

		var url = "http://192.168.4.227:8089/root-quick4j/api/user/login";
		var userName = $("#username").val();
		var password = $("#password").val();
		var parm = { "userAcc": userName, "userPwd": password };
		var n4_url = window.location.protocol + "//" + window.location.host;
		postApiTrue(url, parm, function (data, status) {
		    if (data.flag == 1) {
		        $("#username").val(data.rows[0].n4Acc);
		        $("#password").val(data.rows[0].n4Pwd);
				$.cookie("access_token", data.rows[0].token);
				$.cookie("userId", data.rows[0].userId);
		        $.cookie("n4_url", n4_url);
		        return doLogin();
		    }
		    else {
		        alert(data.des);
		    }
		});
		return false;
	});
    $("#btnChange").click(function(){
    	window.location.href="/prelogin?clear=true";
    });
});

function postApiTrue(url, parm, callBack) {
    $.ajax({
        type: 'POST',
        url: url,
        dataType: "json",
        data: parm,
        success: callBack,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.responseText);
        }
    });
}

function checkName(){
	var name = $('#username').val();
	if(name == null || name == ""){
		$('#msg').html("用户名不能为空");
		return false;
	}
	$('#msg').empty();
	return true;
}

function checkPassword(){
	var password = $('#password').val();
	if(password == null || password == ""){
		$('#msg').html("密码不能为空");
		return false;
	}
	$('#msg').empty();
	return true;
}

function setAccount(acc)
{
    document.getElementById("username").value=acc;
    document.getElementById("username").setAttribute("readonly","true");
}

function loginFail()
{
	$("#msg").html("请正确输入用户和密码！");
}