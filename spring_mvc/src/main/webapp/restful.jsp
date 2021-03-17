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
    <title>SpringMVC中Restful风格的编程</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function testRestful(){

            // #name是指 取id=name 的值
            const name = $("#name").val();

            $.ajax({
                url : "${pageContext.request.contextPath}/user2/oneUser/"+name,
                type : "GET",

                // 成功响应的结果
                success: function (data) {
                    if (data.name != null) {
                        alert("您查询的user的name为" + data.name);
                    } else {
                        alert("暂时没有查到该用户欸...");
                    }
                }
            })
        }
    </script>
</head>
<body>
    <form>
        编号：<input type="text" name="name" id="name"/>
        <input type="button" value="搜索" onclick="testRestful()"/>
    </form>
</body>
</html>
