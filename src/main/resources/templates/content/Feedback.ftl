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
                                <th>用户名称</th>
                                <th>反馈内容</th>
                                <th>创建时间</th>
                            </tr>
                        </thead>
                        <tbody>
                        <#list QuestionFeedbackPage.content?sort_by(["question_id"]) as QuestionFeedbackPage>
                            <tr>
                                <td>${QuestionFeedbackPage.question_id}</td>
                                <td>${QuestionFeedbackPage.user_name}</td>
                                <td>${QuestionFeedbackPage.feedback_content}</td>
                                <td>${QuestionFeedbackPage.create_time}</td>
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
                            <li><a href="/Admin/FeedBack/List?page=${currentPage - 1}&size=${size}">上一页</a></li>
                        </#if>

                        <#list 1..QuestionFeedbackPage.getTotalPages() as index>
                            <li>
                                <a href="/Admin/FeedBack/List?page=${index}&size=${size}">${index}</a>
                            </li>
                        </#list>

                        <#if currentPage gte QuestionFeedbackPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/Admin/FeedBack/List?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>