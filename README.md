 Shipment Logistics Management System
A simple web-based Shipment Logistics Management System built with Java Servlets and JSP (JavaServer Pages). It allows users to add, view, update, and delete shipment records through a clean, card-style UI.
Features
Add Shipment — Register a new shipment with sender, receiver, origin, and destination details.
View All Shipments — Display all shipments in a tabular format.
Update Shipment — Edit the details of an existing shipment.
Delete Shipment — Remove a shipment after a confirmation step.


 Project Structure
ShipmentLogistics/
│
├── WebContent/
│   ├── index.jsp               # Home page with navigation
│   ├── add_shipment.jsp        # Form to add a new shipment
│   ├── view_shipment.jsp       # Table view of all shipments
│   ├── update_shipment.jsp     # Form to update an existing shipment
│   ├── delete_shipment.jsp     # Confirmation page before deletion
│   └── style.css               # Shared stylesheet for all pages
│
└── src/
    └── com/logistics/
        ├── model/
        │   └── Shipment.java           # Shipment model (POJO)
        └── servlet/
            ├── AddShipmentServlet.java
            ├── ViewShipmentServlet.java
            ├── UpdateShipmentServlet.java
            └── DeleteShipmentServlet.java
