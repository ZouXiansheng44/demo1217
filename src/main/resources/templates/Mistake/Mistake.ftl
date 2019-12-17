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
                            <th>做错人数</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list questionMistakePage.content?sort_by(["questionId"]) as questionMistakePage>
                            <tr>
                                <td>${questionMistakePage.questionId}</td>
                                <td>${questionMistakePage.questionContent}</td>
                                <td>${questionMistakePage.createTime}</td>
                                <td>${questionMistakePage.count}</td>
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
                        <li><a href="/Admin/Mistake/List?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..questionMistakePage.getTotalPages() as index>
                    <li>
                        <a href="/Admin/Mistake/List?page=${index}&size=${size}">${index}</a>
                    </li>
                </#list>

                <#if currentPage gte questionMistakePage.getTotalPages()>
                <li class="disabled"><a href="#">下一页</a></li>
                <#else >
                <li><a href="/Admin/Mistake/List?page=${currentPage + 1}&size=${size}">下一页</a></li>
            </#if>
            </ul>
        </div>
    </div>
</div>
</div>
</div>
</body>
</html>