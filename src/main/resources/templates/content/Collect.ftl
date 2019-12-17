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
                        <thead>
                        <tr>
                            <th>题目编号</th>
                            <th>题目内容</th>
                            <th>创建时间</th>
                            <th>收藏数</th>
                            <#--<th colspan="2">操作</th>-->
                        </tr>
                        </thead>
                        <tbody>
                        <#list questionCollect.content?sort_by(["questionId"])as questionCollect>
                            <tr>
                                <td>${questionCollect.questionId}</td>
                                <td>${questionCollect.questionContent}</td>
                                <td>${questionCollect.createTime}</td>
                                <td>${questionCollect.count}</td>
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
                        <#list 1..questionCollect.getTotalPages() as index>
                            <li>
                                <a href="/Admin/Collect/List?page=${index}&size=${size}">${index}</a>
                            </li>
                        </#list>

                        <#if currentPage gte questionCollect.getTotalPages()>
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
</body>
</html>