<%--
  Created by IntelliJ IDEA.
  User: 晏梦阳
  Date: 2020/6/17
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>人事管理</title>
    <style>
        body {
            text-align: center;
        }

        div {
            text-align: center;
        }

        table {
            width: 80%;
            margin: auto;
        }

        thead {
            backgroundColor: #66CCFF;
        }
    </style>
</head>
<body>
<h2>人事管理系统</h2>
<div>
    <table id="tal" border="1" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>生日</th>
            <th>部门</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${requestScope.get('userList')}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getUsername()}</td>
                <td>${user.getAge()}</td>
                <td>${user.getSexid()}</td>
                <td>${user.getBirthday()}</td>
                <td>${user.getDepartmentname()}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/ShowUserServlet?id=${user.getId()}">修改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    window.onload = function () {
        //1、获取表格
        var tab = document.getElementById("tal");
        //2、获取表格中tbody的行数
        var len = tab.tBodies[0].rows.length;
        //alert(len)
        //3、开始循环，设置颜色
        for (var i = 0; i < len; i++) {
            if (i % 2 == 0) {
                tab.tBodies[0].rows[i].style.backgroundColor = "#FFFFCC";
            } else {
                tab.tBodies[0].rows[i].style.backgroundColor = "#FFFFFF";
            }
        }
    }
</script>
</body>
</html>
