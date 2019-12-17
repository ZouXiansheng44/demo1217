<!DOCTYPE html>
<html lang="en">
<#include "../nav/link.ftl">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="page-content-wrapper">
    <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <#include "../nav/nav.ftl">
                <form role="form" method="post" action="/Admin/Answer/Update">
                    <input type="hidden" class="form-control" name="analysisId" value="${(answer.analysisId)!''}" />
                    <div class="form-group">
                        <label for="exampleInputEmail1">题目编号</label><input name="questionId" class="form-control" value="${(answer.questionId)!''}" />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">答案解析</label><input name="analysisContent" class="form-control" value="${(answer.analysisContent)!''}" />
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>