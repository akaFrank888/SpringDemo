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
    <script>
        /*判断是否填写了上传人和已选择上传文件*/
        function check() {
            const name = $("#name").val();
            const file = $("#file").val();

            // 下面两个if的条件是写null还是“”呢？
            if (name == null) {
                alert("请填写上传人");
                return false;
            }
            if (file == null) {
                alert("请选择上传的文件");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <%--当form表单的enctype属性为multipart/form-data时，浏览器就会采用二进制流的方式来处理表单数据，服务器端在对文件上传的请求进行解析处理--%>

    <%--若虚拟路径为 / ,则pageContext.request.contextPath为 空 --%>
    <form action="${pageContext.request.contextPath}uploadAndDownload/upload"
          method="post" enctype="multipart/form-data" onsubmit="return check()">  <%--对onsubmit事件return false的意义是：阻止浏览器对事件的默认动作(在这里是提交表单)--%>

        上传人：<input id="name" type="text" name="name"/><br/>
        <%--input元素的multiple属性是HTML5的新属性。若使用了该属性，可实现多文件上传--%>
        请选择文件：<input id="file" type="file" name="uploadFileName" multiple="multiple"/><br/>
        <input type="submit" value="提交">

    </form>
</body>
</html>
