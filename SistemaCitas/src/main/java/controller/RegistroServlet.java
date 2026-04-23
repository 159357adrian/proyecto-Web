package com.pacifico.sistemacitas.controller;

import com.pacifico.sistemacitas.config.Conexion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("nuevoUsuario");
        String pass = request.getParameter("nuevaPassword");

        try (Connection con = Conexion.getConexion()) {

            String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);

            ps.executeUpdate();

            response.sendRedirect(request.getContextPath() + "/login");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}