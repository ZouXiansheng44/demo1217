<!DOCTYPE html>
<html lang="en">
<#include "../nav/link.ftl">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="toggled" id="wrapper">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <#include "../nav/nav.ftl">

                    <table class="table">
                        <form role="form" action="/Admin/Answer/FindById" method="get">
                            <div class="input-group" style="margin: 10px;float: right;" >
                                <input type="text" class="form-control" style="width: 150px" placeholder="编号搜索" name="questionId">
                                <button type="submit" class="btn btn-default">搜索</button>
                            </div>
                        </form>
                        <thead>
                        <tr>
                            <th>题目编号</th>
                            <th>题目内容</th>
                            <th>创建时间</th>
                            <th>答案解析</th>
                            <th>操作</th>
                            <#--<th colspan="2">操作</th>-->
                        </tr>
                        </thead>
                        <tbody>
                        <#list answerDTOPage.content as answerDTO>
                        <tr>
                            <td>${answerDTO.questionId}</td>
                            <td>${answerDTO.questionContent}</td>
                            <td>${answerDTO.createTime}</td>
                            <td>${answerDTO.analysisContent}</td>
                            <td><a href="/Admin/Answer/Detail?analysisId=${answerDTO.analysisId}">修改解析</a></td>
                        </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>

                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else >
                            <li><a href="/Admin/Collect/List?page=${currentPage - 1}&size=${size}">上一页</a></li>
                        </#if>
                        <#list 1..answerDTOPage.getTotalPages() as index>
                            <li>
                                <a href="/Admin/Collect/List?page=${index}&size=${size}">${index}</a>
                            </li>
                        </#list>
                        <#if currentPage gte answerDTOPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/Admin/Collect/List?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>
<#--<ul class="nav nav-tabs" style="margin-top: 10px">-->
<#--<li class="active">-->
<#--<a><h4>后台管理系统</h4></a>-->
<#--</li>-->
<#--<li>-->
<#--<a href="/Admin/Question/List"><h4>题目库</h4></a>-->
<#--</li>-->
<#--<li>-->
<#--<a href="/Admin/Collect/List"><h4>用户收藏</h4></a>-->
<#--</li>-->
<#--<li>-->
<#--<a href="/Admin/Collect/Answer"><h4>答案解析</h4></a>-->
<#--</li>-->
<#--<li class="dropdown pull-right">-->
<#--<a href="/Admin/LoginOut"><h4>用户退出</h4></a>-->
<#--</li>-->
<#--</ul>-->
</body>
</html>