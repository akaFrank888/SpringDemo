<%--
  Created by IntelliJ IDEA.
  User: yxl15
  Date: 2021/3/16
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试文件上传</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user2/quick8" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"/><br/>
        文件<input type="file" name="uploadFile"/></br>
        文件<input type="file" name="uploadFile2"/></br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
