<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>错误！！！<strong>${msg}</strong><a href="${url}" class="alert-link">3s后自动跳转</a></h3>
</body>
<script>
    setTimeout('location.href="${url}"',3000);
</script>
</html>