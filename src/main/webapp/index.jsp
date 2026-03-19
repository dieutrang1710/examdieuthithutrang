<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>

<style>
    body {
        font-family: Arial;
        background: #f5f5f5;
        margin: 0;
    }
    .header {
        background: #6f8f6f;
        color: white;
        padding: 15px;
        text-align: center;
        font-size: 28px;
        font-weight: bold;
    }
    .title {
        text-align: center;
        font-size: 24px;
        margin: 10px 0;
    }
    .container {
        width: 90%;
        margin: auto;
    }
    .btn {
        background: #4CAF50;
        color: white;
        padding: 8px 15px;
        text-decoration: none;
        border-radius: 5px;
        margin-right: 5px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
        margin-top: 10px;
    }
    th {
        background: #4CAF50;
        color: white;
        padding: 10px;
    }
    td {
        padding: 8px;
        text-align: center;
    }
    tr:nth-child(even) {
        background: #eee;
    }
</style>

<div class="header">Student Information System</div>
<div class="title">Student Information</div>

<div class="container">

    <a class="btn" href="add-student.jsp">+ Student</a>
    <a class="btn" href="add-score.jsp">+ Score</a>
    <a class="btn" href="list">Refresh</a>

    <table>
        <tr>
            <th>Id</th>
            <th>Student Id</th>
            <th>Student Name</th>
            <th>Subject Name</th>
            <th>Score 1</th>
            <th>Score 2</th>
            <th>Credit</th>
            <th>Grade</th>
        </tr>

        <%
            List<Map<String,Object>> list = (List<Map<String,Object>>) request.getAttribute("list");
            int i = 1;
            if(list != null){
                for(Map<String,Object> s : list){
        %>
        <tr>
            <td><%=i++%></td>
            <td><%=s.get("code")%></td>
            <td><%=s.get("name")%></td>
            <td><%=s.get("subject")%></td>
            <td><%=s.get("score1")%></td>
            <td><%=s.get("score2")%></td>
            <td><%=s.get("credit")%></td>
            <td><%=s.get("grade")%></td>
        </tr>
        <% }} %>

    </table>

</div>