<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2020/11/13
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>selectById</title>
</head>
<body>
    <div>
        <form action="update" method="post">
            <input type="hidden" name="id" value="${teacher.id}" ><br>
            <input name="teacherName" value="${teacher.teacherName}"><br>
            <input name="teacherAddr" value="${teacher.teacherAddr}"><br>
            <input name="age" value="${teacher.age}"><br>
            <input type="submit" value="修改提交">
        </form>
    </div>

</body>
</html>
