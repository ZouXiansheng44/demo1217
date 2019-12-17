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
                        <form role="form" action="/Admin/Question/findById" method="get">
                            <div class="input-group" style="margin: 10px;float: right;" >
                                <input type="text" class="form-control" style="width: 150px" placeholder="编号搜索" name="questionId">
                                <button type="submit" class="btn btn-default">搜索</button>
                            </div>
                        </form>
                        <#--<a href="/Admin/Question/Detail">点我跳转哦</a>-->
                        <#--<a href="/Admin/Collect/List">点我跳转收藏</a>-->
                        <thead>
                        <tr>
                            <th width="50px">编号</th>
                            <th>题目内容</th>
                            <th width="500px">题目选项</th>
                            <th width="50px">答案</th>
                            <th width="100px">题目类型</th>
                            <th>科目</th>
                            <th width="50px">状态</th>
                            <th width="100px">创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list questionBankPage.content as questionBank>
                            <tr>
                                <td>${questionBank.questionId}</td>
                                <td>${questionBank.questionContent}</td>
                                <td>${questionBank.questionOption}</td>
                                <td>${questionBank.questionAnswer}</td>
                                <td>${questionBank.getQuestionType().msg}</td>
                                <td>${questionBank.questionSubject}</td>
                                <td>
                                    <#if questionBank.questionStatus==0 >在线
                                    <#elseif questionBank.questionStatus==1>下线
                                    </#if>
                                </td>
                                <td>${questionBank.createTime}</td>
                                <td width="50px"><a href="/Admin/Question/Detail?questionId=${questionBank.questionId}">详情信息</a></td>
                                <td width="50px"><a href="/Admin/Question/Status?questionId=${questionBank.questionId}">更改状态</a></td>
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
                            <li><a href="/Admin/Question/List?page=${currentPage - 1}&size=${size}">上一页</a></li>
                        </#if>

                        <#list 1..questionBankPage.getTotalPages() as index>
                            <li>
                                <a href="/Admin/Question/List?page=${index}&size=${size}">${index}</a>
                            </li>
                        </#list>

                        <#if currentPage gte questionBankPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/Admin/Question/List?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>