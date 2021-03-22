<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: yxl15
  Date: 2021/3/16
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试文件下载</title>
</head>
<body>
<a href="${pageContext.request.contextPath}uploadAndDownload/download?filename=<%=URLEncoder.encode("土星第二奶油糖_4efec368-8658-4a15-9f46-55c5afd142b4_image-20210128113237706.png","utf-8")%>">
    文件下载
</a>
</body>
</html>
