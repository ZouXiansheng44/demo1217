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
                            <th>编号</th>
                            <th>科目名称</th>
                            <th>科目成绩</th>
                            <th>创建时间</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list userPage.content as userPage>
                            <tr>
                                <td>${userPage.gradeId}</td>
                                <td>${userPage.questionSubject}</td>
                                <td>${userPage.gradeValue}</td>
                                <td>${userPage.createTime}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <li><a href="/Admin/User/List">返回</a> </li>
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else >
                            <li><a href="/Admin/User/List?page=${currentPage - 1}&size=${size}">上一页</a></li>
                        </#if>

                        <#list 1..userPage.getTotalPages() as index>
                            <li>
                                <a href="/Admin/User/List?page=${index}&size=${size}">${index}</a>
                            </li>
                        </#list>

                        <#if currentPage gte userPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/Admin/User/List?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>