<%@ page import="com.app.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.controller.CustomerController" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-12">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#Id</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Salary</th>
                    <th>Option</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Customer> allCustomers = new CustomerController().findAllCustomer();
                    for(Customer c: allCustomers){
                %>
                <tr>
                    <td><%=c.getId()%></td>
                    <td><%=c.getName()%></td>
                    <td><%=c.getAddress()%></td>
                    <td><%=c.getSalary()%></td>
                    <td>
                        <a class="btn btn-success" href="edit_customer.jsp?id=<%=c.getId()%>">Update</a> |
                        <a class="btn btn-danger" href="delete_customer.jsp?id=<%=c.getId()%>">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
