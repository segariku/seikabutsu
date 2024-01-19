package com.example.webbookmanager;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utils.bookDAO;


@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = "/WEB-INF/view/bookdelete.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        request.setCharacterEncoding("UTF-8");
        int user_id = Integer.parseInt(request.getParameter("user_id"));

        // DBからユーザーを削除
        bookDAO.Signout(user_id);

        // サインアウト完了ページにリダイレクト
        response.sendRedirect("HomeServlet");
    }
}