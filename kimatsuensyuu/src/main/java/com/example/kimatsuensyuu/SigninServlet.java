package com.example.kimatsuensyuu;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import util.GenerateHash;
import util.userBean;
import util.userDAO;

@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String pw = request.getParameter("pw");

        // ログイン処理
        // 1. DB検索(ID)
        userBean result = userDAO.selectById(id);

        // 2. pw比較
        if (GenerateHash.checkPassword(pw, result.getPw())) {
            // ログイン情報をセッションに登録
            HttpSession session = request.getSession();
            session.setAttribute("name", result.getName());
            session.setAttribute("user_id", result.getId());

            // 3. 一致したらhomeにリダイレクト
            response.sendRedirect("HomeServlet");
        } else {
            // 一致しない
            response.sendRedirect("");
        }


    }
    }
