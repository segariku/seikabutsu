package com.example.kimatsuensyuu;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet("/MoneyServlet")
public class MoneyServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = "/WEB-INF/view/money.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int goal = Integer.parseInt(request.getParameter("goal"));
        int now = Integer.parseInt(request.getParameter("now"));

        int sagaku = goal-now;

        request.setAttribute("sagaku", sagaku);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/sagaku.jsp");
        dispatcher.forward(request, response);
        }

    }
