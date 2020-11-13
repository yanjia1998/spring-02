<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2020/11/12
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>selectAll</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" />

</head>
<body>
    <div>
        <table  class="table table-bordered  table table-striped" style="width: 800px" align="center">
            <tr>
                <td colspan="5" align="center">
                    <a href="selectByIdInsert.jsp"><button type="button" class="btn btn-success" >新增教师</button></a>

                </td>
            </tr>
            <tr>
                <th>教师编号</th>
                <th>教师姓名</th>
                <th>教师住址</th>
                <th>教师年龄</th>
                <th>操作</th>
            </tr>
            <c:forEach var="teacher" items="${teachers}">
                <tr>
                    <td>${teacher.id}</td>
                    <td>${teacher.teacherName}</td>
                    <td>${teacher.teacherAddr}</td>
                    <td>${teacher.age}</td>
                    <td>
                        <a href="selectById?id=${teacher.id}"><button type="button" class="btn btn-success">修改</button></a>
                        <a href="delete?id=${teacher.id}"><button type="button" class="btn btn-success">删除</button></a>
                    </td>
                </tr>

            </c:forEach>

        </table>
        <div align="center">
            <tr>
                <td colspan="5">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <c:if test="${pageinfo.isFirstPage}">
                                    <a  aria-label="Previous">
                                        <span aria-hidden="false">&laquo;</span>
                                    </a>
                                </c:if>
                                <c:if test="${!pageinfo.isFirstPage}">
                                    <a href="selectAll?pageNum=${pageinfo.pageNum-1}" aria-label="Previous">
                                         <span aria-hidden="true">&laquo;</span>
                                     </a>
                                </c:if>
                            </li>
                            <li><a >${pageinfo.pageNum}</a></li>

                            <li>
                                <c:if test="${!pageinfo.isLastPage}">
                                    <a href="selectAll?pageNum=${pageinfo.pageNum+1}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </c:if>
                                <c:if test="${pageinfo.isLastPage}">
                                    <a  aria-label="Next">
                                        <span aria-hidden="false">&raquo;</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a>共${pageinfo.pages}页</a></li>
                        </ul>
                    </nav>
                </td>
            </tr>

        </div>

    </div>

</body>
</html>
