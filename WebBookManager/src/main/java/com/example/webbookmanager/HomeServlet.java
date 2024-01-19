package com.example.webbookmanager;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utils.GoogleBooksAPI;
import utils.bookBean;
import utils.bookDAO;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if ( session.getAttribute("name") != null ) {
            int user_id = (int) session.getAttribute("user_id");
            ArrayList<String> result = bookDAO.select(user_id);

            request.setAttribute("isbn_list",result);

            String path = "/WEB-INF/view/home.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(""); // indexへ
        }
    }
}