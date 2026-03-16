package com.logistics.servlet;
import com.logistics.dao.ShipmentDAO;
import com.logistics.dao.ShipmentDAOImpl;
import com.logistics.model.Shipment;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewShipmentServlet")
public class ViewShipmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShipmentDAO dao = new ShipmentDAOImpl();
        List<Shipment> shipments = dao.getAllShipments();
        request.setAttribute("shipments", shipments);
        RequestDispatcher rd = request.getRequestDispatcher("view_shipment.jsp");
        rd.forward(request, response);
    }
}