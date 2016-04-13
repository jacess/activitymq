<%--
  Created by IntelliJ IDEA.
  User: yangh
  Date: 15/12/15
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
    <script type="application/javascript" src="../../js/jquery.js"></script>
    <script type="application/javascript">
        function tip() {
            $.ajax({
                type: "post",
                url: "ajaxAction",
                data: {countryName:123, name:"yangh"},
                dataType: "json",
                success: function (resp) {
                    var d = eval("("+resp+")");
                    alert(d.name);
                    alert(d.countryName);
                }
            });
        }
    </script>
</head>
<body>
    <input type="button" onclick="tip()" value="点我" />
</body>
</html>
