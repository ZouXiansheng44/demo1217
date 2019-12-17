<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3><strong>${msg},</strong><a href="${url}" class="alert-link">1s后自动跳转</a></h3>
</body>
<script>
    setTimeout('location.href="${url}"',1000);
</script>
</html>