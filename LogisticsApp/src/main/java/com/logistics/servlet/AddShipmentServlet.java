package com.logistics.servlet;
import com.logistics.dao.*;
import com.logistics.model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddShipmentServlet")
public class AddShipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String sender = request.getParameter("sender");
	        String receiver = request.getParameter("receiver");
	        String origin = request.getParameter("origin");
	        String destination = request.getParameter("destination");
	        Shipment shipment = new Shipment();
	        shipment.setSender(sender);
	        shipment.setReceiver(receiver);
	        shipment.setOrigin(origin);
	        shipment.setDestination(destination);
	        ShipmentDAO dao = new ShipmentDAOImpl();
	        dao.addShipment(shipment);
	        response.sendRedirect("ViewShipmentServlet");
	
	}

}
