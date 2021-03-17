<%--
  Created by IntelliJ IDEA.
  User: yxl15
  Date: 2021/3/15
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试客户端传入集合（json数据），后端获取并封装</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function testJson(){
            var userList = new Array();
            userList.push({name:"zhangsan",age:8});
            userList.push({name:"lisi",age:9});

            $.ajax({
                url : "${pageContext.request.contextPath}/user2/quick4",
                type : "POST",

                // data表示发送的数据
                data : JSON.stringify(userList),
                // contentType表示发送的请求的数据格式是Json字符串
                contentType : "application/json;charset=UTF-8",

                // 成功响应的结果
                success: function (data) {
                    if (data != null) {
                        alert("userList已成功接收，大小为：" + userList.length);
                    }
                }
            })
        }
    </script>
</head>
<body>
    <form>
        用户名：<input type="text" name="name"><br/>
        年&nbsp;龄：<input type="text" name="age"><br/>
        <input type="button" value="测试json交互" onclick="testJson()"/>
    </form>
</body>
</html>
