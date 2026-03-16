package com.logistics.dao;
import java.util.List;
import com.logistics.model.Shipment;
public interface ShipmentDAO {
    void addShipment(Shipment shipment);
    List<Shipment> getAllShipments();
    void deleteShipment(int shipmentId);
    void updateShipment(Shipment shipment);
	Shipment getShipmentById(int int1);
}