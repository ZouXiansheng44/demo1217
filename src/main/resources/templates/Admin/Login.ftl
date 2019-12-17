<!DOCTYPE html>
<html lang="en">
<#include "../nav/link.ftl">
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/Admin/Login" method="get">
                <div class="form-group" >
                    <label>账户</label><input type="text" class="form-control"  name="adminName" />
                </div>
                <div class="form-group">
                    <label>密码</label><input type="password" class="form-control"  name="adminPassword" />
                </div>
                <button type="submit" class="btn btn-default">登录</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>