<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>tx 音乐是生活的调味剂</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />


    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
<div class="login-logo">
    <img src="images/logo.png" width="147" height="33" />
</div>

<div class="widget">
    <div class="login-content">
        <div class="widget-content" style="padding-bottom:0;">
            <form method="get" action="index.html" class="no-margin" />
            <h3 class="form-title">Login to your account</h3>
            <p class="login-box-msg">Sign in to start your session</p>

            <fieldset>
                <div class="form-group no-margin">
                    <label for="username">UserName</label>

                    <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <i class="icon-user"></i>
                                </span>
                        <input type="text" placeholder="Your Email" class="form-control input-lg" id="username" name="username" />
                    </div>

                </div>

                <div class="form-group">
                    <label for="password">Password</label>

                    <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <i class="icon-lock"></i>
                                </span>
                        <input type="password" placeholder="Your Password" class="form-control input-lg" id="password" name="password" />
                    </div>

                </div>
            </fieldset>
            <div class="form-actions">
                <label class="checkbox">
                    <div class="checker"><span><input type="checkbox" value="1" name="remember" /></span></div> Remember me
                </label>
                <button class="btn btn-warning pull-right" type="button" onclick="doLogin()">
                    Login <i class="m-icon-swapright m-icon-white"></i>
                </button>
                <div class="forgot"><a href="#" class="forgot">Forgot Username or Password?</a></div>
            </div>


            </form>


        </div>
    </div>
</div>








<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
    function doLogin(){
        var params={
            username:$("#username").val(),
            password:$("#password").val(),
        }
        var url="user/doLogin";
        console.log("params",params);
        $.post(url,params,function(result){
            console.log("login.result",result);
            if(result.state==1){
                //跳转到首页面
                location.href="/page/index";
            }else{
                $(".login-box-msg").html(result.message);
            }
            return false;//防止刷新时重复提交
        });
    }
</script>




</body>
</html>
