package com.example.kimatsuensyuu;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import util.moneyDAO;

@WebServlet("/MoneyRegisterServlet")
public class MoneyRegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = "/WEB-INF/view/moneyregister.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        int sagaku = Integer.parseInt(request.getParameter("sagaku"));

        moneyDAO.insert(id, sagaku);

        response.sendRedirect("HomeServlet");
    }
}