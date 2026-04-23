package com.pacifico.sistemacitas.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/cita")
public class CitaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // 🔒 Validación de login
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // ✅ Si está logueado, continúa
        request.getRequestDispatcher("/WEB-INF/views/index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // 🔒 (Opcional pero recomendado) también validar aquí
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String nombre = request.getParameter("nombre");

        request.setAttribute("mensaje", "Cita registrada para: " + nombre);

        request.getRequestDispatcher("/WEB-INF/views/resultado.jsp")
                .forward(request, response);
    }
}