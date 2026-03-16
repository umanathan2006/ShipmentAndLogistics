package com.logistics.servlet;

import com.logistics.dao.ShipmentDAO;
import com.logistics.dao.ShipmentDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteShipmentServlet")
public class DeleteShipmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ShipmentDAO dao = new ShipmentDAOImpl();
        dao.deleteShipment(id);
        response.sendRedirect("ViewShipmentServlet");
    }
}