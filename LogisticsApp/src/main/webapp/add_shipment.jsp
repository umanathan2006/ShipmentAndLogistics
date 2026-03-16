<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Shipment</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="card">
    <h2> Add Shipment</h2>
    <p>Fill in the details below</p>
    <form method="post" action="AddShipmentServlet">
        <div class="form-group">
            <label>Sender</label>
            <input type="text" name="sender" placeholder="Enter sender name">
        </div>
        <div class="form-group">
            <label>Receiver</label>
            <input type="text" name="receiver" placeholder="Enter receiver name">
        </div>
        <div class="form-group">
            <label>Origin</label>
            <input type="text" name="origin" placeholder="Enter origin city">
        </div>
        <div class="form-group">
            <label>Destination</label>
            <input type="text" name="destination" placeholder="Enter destination city">
        </div>
        <input type="submit" value="Add Shipment">
    </form>
    <a href="index.jsp" class="home-link">← Back to Home</a>
</div>
</body>
</html>