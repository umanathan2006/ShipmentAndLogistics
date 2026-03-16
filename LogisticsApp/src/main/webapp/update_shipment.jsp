<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.logistics.model.Shipment" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Shipment</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="card">
    <h2>Update Shipment</h2>
    <p>Edit the shipment details below</p>
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
        <p style="color:#e74c3c; font-weight:bold; font-size:14px;"><%= errorMessage %></p>
        <a href="ViewShipmentServlet" class="home-link">← Back to Shipment List</a>
    <%
            return;
        }
    %>
    <%
        Shipment shipment = (Shipment) request.getAttribute("shipment");
        if (shipment == null) {
            response.sendRedirect("ViewShipmentServlet");
            return;
        }
    %>
    <form method="post" action="UpdateShipmentServlet">
        <input type="hidden" name="id" value="<%= shipment.getShipmentid() %>">
        <div class="form-group">
            <label>Sender</label>
            <input type="text" name="sender" value="<%= shipment.getSender() %>">
        </div>
        <div class="form-group">
            <label>Receiver</label>
            <input type="text" name="receiver" value="<%= shipment.getReceiver() %>">
        </div>
        <div class="form-group">
            <label>Origin</label>
            <input type="text" name="origin" value="<%= shipment.getOrigin() %>">
        </div>
        <div class="form-group">
            <label>Destination</label>
            <input type="text" name="destination" value="<%= shipment.getDestination() %>">
        </div>
        <input type="submit" value="Update Shipment">
    </form>
    <a href="index.jsp" class="home-link">← Back to Home</a>
</div>
</body>
</html>