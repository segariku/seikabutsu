package com.example.webbookmanager;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utils.bookDAO;

@WebServlet("/BookRegisterServlet")
public class BookRegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String isbn = request.getParameter("isbn");

        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("user_id");
        bookDAO.insert(isbn, user_id);

        response.sendRedirect("SearchServlet");
    }
}