<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.logistics.model.Shipment" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Shipment</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="card" style="width: 600px;">
    <h2>Delete Shipment</h2>
    <p class="warning-text">Are you sure you want to delete this shipment?</p>
    <%
        Shipment shipment = (Shipment) request.getAttribute("shipment");
        if (shipment == null) {
            response.sendRedirect("ViewShipmentServlet");
            return;
        }
    %>
    <table>
        <tr>
            <th>ID</th>
            <th>Sender</th>
            <th>Receiver</th>
            <th>Origin</th>
            <th>Destination</th>
        </tr>
        <tr>
            <td><%= shipment.getShipmentid() %></td>
            <td><%= shipment.getSender() %></td>
            <td><%= shipment.getReceiver() %></td>
            <td><%= shipment.getOrigin() %></td>
            <td><%= shipment.getDestination() %></td>
        </tr>
    </table>
    <div class="action-links">
        <a href="DeleteShipmentServlet?id=<%= shipment.getShipmentid() %>" class="btn-red">Delete</a>
        <a href="ViewShipmentServlet" class="btn-grey">Go Back</a>
    </div>
    <a href="index.jsp" class="home-link">← Back to Home</a>
</div>
</body>
</html>