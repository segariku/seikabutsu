package com.example.kimatsuensyuu;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

import util.moneyBean;
import util.moneyDAO;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (session.getAttribute("name") != null) {
            int userId = (int) session.getAttribute("user_id");

            List<moneyBean> moneyBeanList = moneyDAO.selectById(userId);

            request.setAttribute("moneyBeanList", moneyBeanList);

            String path = "/WEB-INF/view/home.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        }
    }
}
