<%--
  Created by IntelliJ IDEA.
  User: 晏梦阳
  Date: 2020/6/17
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改图书信息</title>
    <style>
        body {
            text-align: center;
        }

        div {
            text-align: center;
        }

        table {
            margin: auto;
        }
        #button{
            text-align: center;
        }
        select{
            width: 150px;
        }
        td{
            padding: 2px;
            border: 1px #99DDFF;
        }
    </style>
</head>

<body>
<h2>图书信息修改</h2>
<div>
    <form action="/UpdateUserServlet" method="post">
        <table border="1" cellspacing="0" cellpadding="0">
            <input style="display: none" id="id" name="id" value="${user.getId()}"/>
            <tr>
                <th>姓名</th>
                <td><input type="text" id="username" name="username" value="${user.getUsername()}"></td>
            </tr>
            <tr>
                <th>年宁</th>
                <td><input type="text" id="age" name="age" value="${user.getAge()}"></td>
            </tr>
            <tr>
                <th>性别</th>
                <td><input type="text" id="sexid" name="sexid" value="${user.getSexid()}"></td>
            </tr>

            <tr>
                <th>生日</th>
                <td><input type="text" id="birthday" name="birthday" value="${user.getBirthday()}"></td>
            </tr>
            <tr>
                <th>部门</th>
                <td><select id="department" name="department"></select></td>
            </tr>
            <tr id="button">
                <td colspan="2">
                    <input type="submit" value="确定">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</div>

<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script>
    var department= ${user.getDepartment()};
</script>
<script type="text/javascript" src="../js/updateUser.js"></script>
</body>
</html>
