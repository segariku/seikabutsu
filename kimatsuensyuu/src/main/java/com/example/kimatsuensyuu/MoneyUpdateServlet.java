package com.example.kimatsuensyuu;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import util.moneyDAO;

@WebServlet("/MoneyUpdateServlet")
public class MoneyUpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = "/WEB-INF/view/moneyupdate.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");

        // フォームからIDと差額を受け取る
        int id = Integer.parseInt(request.getParameter("id"));
        int sagaku = Integer.parseInt(request.getParameter("sagaku"));

        // データベース内の既存の差額を更新する
        moneyDAO.update(id, sagaku);

        // HomeServletにリダイレクトする
        response.sendRedirect("HomeServlet");
    }
}