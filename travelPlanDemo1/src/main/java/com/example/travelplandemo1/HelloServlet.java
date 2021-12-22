package com.example.travelplandemo1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.example.travelplandemo1.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;

@WebServlet(name = "travelPlan", value = "/travelPlan")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/jason");

        // Hello
        ObjectMapper mapper = new ObjectMapper();

        Customer customer = new Customer();
        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);

        response.getWriter().print(mapper.writeValueAsString(customer));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonObject.getString("email");
        String firstName = jsonObject.getString("first_name");
        String lastName = jsonObject.getString("last_name");
        int age = jsonObject.getInt("age");


        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}