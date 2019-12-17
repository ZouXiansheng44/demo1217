<!DOCTYPE html>
<html lang="en">
<#include "../nav/link.ftl">
<head>
    <meta charset="UTF-8">
</head>
<body>
<div id="page-content-wrapper">
    <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <#include "../nav/nav.ftl">
                <form role="form" method="post" action="/Admin/Question/Update">
                        <input type="hidden" class="form-control" name="questionId" value="${(questionDetail.questionId)!''}" />
                    <div class="form-group">
                        <label for="exampleInputEmail1">题目内容</label><input name="questionContent" class="form-control" value="${(questionDetail.questionContent)!''}" />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">题目选项</label><input name="questionOption" class="form-control" value="${(questionDetail.questionOption)!''}" />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">题目答案</label><input name="questionAnswer" class="form-control" value="${(questionDetail.questionAnswer)!''}" />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">题目类型</label><input name="questionType" oninput = "value=value.replace(/[^\d]/g,'')" class="form-control" value="${(questionDetail.getQuestionType().code)!''}" />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">题目科目</label><input name="questionSubject" class="form-control" value="${(questionDetail.questionSubject)!''}" />
                    </div>
                    <#--<div class="form-group">-->
                        <#--<label for="exampleInputPassword1">题目状态</label><input name="questionStatus" class="form-control" value="${(questionBank.questionStatus)!''}" />-->
                    <#--</div>-->
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>