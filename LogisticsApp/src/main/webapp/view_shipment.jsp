<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.logistics.model.Shipment" %>
<%
    @SuppressWarnings("unchecked")
    List<Shipment> shipments = (List<Shipment>) request.getAttribute("shipments");
    if (shipments == null) {
        response.sendRedirect("ViewShipmentServlet");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Shipments</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="card" style="width: 750px;">
    <h2>All Shipments</h2>
    <p>List of all registered shipments</p>
    <a href="add_shipment.jsp" class="btn btn-green" 
       style="display:inline-block; width:auto; padding: 8px 16px; margin-bottom:20px;">
        Add New Shipment
    </a>
    <% if (shipments.isEmpty()) { %>
        <p style="color:#e74c3c;">No shipments found.</p>
    <% } else { %>
    <table>
        <tr>
            <th>ID</th>
            <th>Sender</th>
            <th>Receiver</th>
            <th>Origin</th>
            <th>Destination</th>
            <th>Actions</th>
        </tr>
        <% for (Shipment s : shipments) { %>
        <tr>
            <td><%= s.getShipmentid() %></td>
            <td><%= s.getSender() %></td>
            <td><%= s.getReceiver() %></td>
            <td><%= s.getOrigin() %></td>
            <td><%= s.getDestination() %></td>
            <td>
                <a href="UpdateShipmentServlet?id=<%= s.getShipmentid() %>" 
                   class="btn" 
                   style="display:inline-block; width:auto; padding:6px 12px; font-size:13px; margin:2px;">
                   Update
                </a>
                <a href="DeleteShipmentServlet?id=<%= s.getShipmentid() %>" 
                   class="btn-red" 
                   style="padding:6px 12px; font-size:13px; margin:2px;">
                    Delete
                </a>
            </td>
        </tr>
        <% } %>
    </table>
    <% } %>
    <a href="index.jsp" class="home-link">← Back to Home</a>
</div>
</body>
</html>