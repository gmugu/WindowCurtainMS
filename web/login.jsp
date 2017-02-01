<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title> - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
<input type="hidden" name="msg" id="msg" value="${msg}"/>
<br/>

<div class="signinpanel">
    <div class="row">
        <div class="col-sm-12">
            <form method="post" action="login.do">
                <h4 class="no-margins">登录：</h4>

                <p class="m-t-md">登录到窗帘布艺管理系统</p>
                <input name="username" type="text" class="form-control uname" placeholder="用户名"/>
                <input name="password" type="password" class="form-control pword m-b" placeholder="密码"/>
                <button class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; YuSha
        </div>
    </div>
</div>
</body>

</html>
<script>
    var msgStr = document.getElementById('msg').value;
    if (msgStr != null && msgStr != '') {
        alert(msgStr);
    }
</script>
