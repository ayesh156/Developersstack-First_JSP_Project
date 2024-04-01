package com.app.servlets;

import com.app.controller.CustomerController;
import com.app.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save")
public class CustomerSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");

        Customer customer = new Customer(
                Long.parseLong(id), name,address,Double.parseDouble(salary)
        );
        System.out.println(customer);
        if (new CustomerController().saveCustomer(customer)){
            System.out.println("saved");
            resp.sendRedirect("new_customer.jsp");
        }else{
            System.out.println("error");
        }

    }
}
