<ul class="nav nav-tabs" style="margin-top: 10px">
    <li class="active">
        <a><h4>后台管理系统</h4></a>
    </li>
        <#--<a href="/Admin/Question/List"><h4>题目库</h4></a>-->
    <li class="dropdown">
        <a href="#" data-toggle="dropdown" class="dropdown-toggle" id="dropdownMenu1"><h4>题目库</h4><strong class="caret"></strong></a>
        <ul class="dropdown-menu">
            <li>
                <a href="/Admin/Question/List"><h5>题目列表</h5></a>
            </li>
            <li>
                <a href="/Admin/Question/Detail"><h5>题目添加</h5></a>
            </li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" data-toggle="dropdown" class="dropdown-toggle" id="dropdownMenu1"><h4>答案解析</h4><strong class="caret"></strong></a>
        <ul class="dropdown-menu">
            <li>
                <a href="/Admin/Answer/Analysis"><h5>解析列表</h5></a>
            </li>
            <li>
                <a href="/Admin/Answer/Detail"><h5>添加解析</h5></a>
            </li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" data-toggle="dropdown" class="dropdown-toggle" id="dropdownMenu1"><h4>用户数据</h4><strong class="caret"></strong></a>
        <ul class="dropdown-menu">
            <li>
                <a href="/Admin/User/List"><h5>用户表</h5></a>
            </li>
            <li>
                <a href="/Admin/Collect/List"><h5>用户收藏</h5></a>
            </li>
            <li>
                <a href="/Admin/Mistake/List"><h5>用户错题</h5></a>
            </li>
            <li>
                <a href="/Admin/FeedBack/List"><h5>题目反馈</h5></a>
            </li>
        </ul>
    </li>
    <li class="dropdown pull-right">
        <a href="/Admin/LoginOut"><h4>用户退出</h4></a>
    </li>
</ul>