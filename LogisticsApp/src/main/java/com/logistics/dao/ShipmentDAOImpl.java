package com.logistics.dao;
import java.sql.*;
import java.util.*;
import com.logistics.model.Shipment;
import com.logistics.util.DBConnection;
public class ShipmentDAOImpl implements ShipmentDAO {
    public void addShipment(Shipment shipment) {
        try {
        	Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO shipment(sender,receiver,origin,destination) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, shipment.getSender());
            ps.setString(2, shipment.getReceiver());
            ps.setString(3, shipment.getOrigin());
            ps.setString(4, shipment.getDestination());
            int rows = ps.executeUpdate();
            System.out.println("Rows inserted: " + rows);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public List<Shipment> getAllShipments() {
        List<Shipment> list = new ArrayList<>();
        try {
        	Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM shipment";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Shipment s = new Shipment();
                s.setShipmentid(rs.getInt("shipmentid"));
                s.setSender(rs.getString("sender"));
                s.setReceiver(rs.getString("receiver"));
                s.setOrigin(rs.getString("origin"));
                s.setDestination(rs.getString("destination"));
                list.add(s);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void deleteShipment(int shipmentId) {
        try {
        	Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM shipment WHERE shipmentid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, shipmentId);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void updateShipment(Shipment shipment) {
        try {
        	Connection con = DBConnection.getConnection();
            String sql = "UPDATE shipment SET sender=?, receiver=?, origin=?, destination=? WHERE shipmentid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, shipment.getSender());
            ps.setString(2, shipment.getReceiver());
            ps.setString(3, shipment.getOrigin());
            ps.setString(4, shipment.getDestination());
            ps.setInt(5, shipment.getShipmentid());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public Shipment getShipmentById(int shipmentId) {
        Shipment s = null;    
        try {
        	Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM shipment WHERE shipmentid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, shipmentId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                s = new Shipment();
                s.setShipmentid(rs.getInt("shipmentid"));
                s.setSender(rs.getString("sender"));
                s.setReceiver(rs.getString("receiver"));
                s.setOrigin(rs.getString("origin"));
                s.setDestination(rs.getString("destination"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}