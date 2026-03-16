package com.logistics.servlet;
import com.logistics.dao.ShipmentDAO;
import com.logistics.dao.ShipmentDAOImpl;
import com.logistics.model.Shipment;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UpdateShipmentServlet")
public class UpdateShipmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ShipmentDAO dao = new ShipmentDAOImpl();
        Shipment shipment = dao.getShipmentById(id);
        if (shipment == null) {
            request.setAttribute("errorMessage", "Shipment with ID " + id + " not found in database.");
            request.getRequestDispatcher("update_shipment.jsp").forward(request, response);
            return;
        }
        request.setAttribute("shipment", shipment);
        request.getRequestDispatcher("update_shipment.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int    id          = Integer.parseInt(request.getParameter("id"));
        String sender      = request.getParameter("sender");
        String receiver    = request.getParameter("receiver");
        String origin      = request.getParameter("origin");
        String destination = request.getParameter("destination");
        ShipmentDAO dao = new ShipmentDAOImpl();
        Shipment existing = dao.getShipmentById(id);
        if (existing == null) {
            request.setAttribute("errorMessage", "Shipment with ID " + id + " not found. Update failed.");
            request.getRequestDispatcher("update_shipment.jsp").forward(request, response);
            return;
        }
        Shipment shipment = new Shipment();
        shipment.setShipmentid(id);
        shipment.setSender(sender);
        shipment.setReceiver(receiver);
        shipment.setOrigin(origin);
        shipment.setDestination(destination);
        dao.updateShipment(shipment);
        response.sendRedirect("ViewShipmentServlet");
    }
}