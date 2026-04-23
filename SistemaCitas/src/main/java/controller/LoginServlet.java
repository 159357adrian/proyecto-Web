package com.pacifico.sistemacitas.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.pacifico.sistemacitas.config.Conexion;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // 🔐 Login simple sin base de datos
        if ("admin".equals(user) && "1234".equals(pass)) {

            HttpSession session = request.getSession();
            session.setAttribute("usuario", user);

            response.sendRedirect(request.getContextPath() + "/home");

        } else {
            request.setAttribute("errorLogin", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }

}
