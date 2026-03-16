package com.logistics.model;
public class Shipment {
    private int shipmentid;
    private String sender;
    private String receiver;
    private String origin;
    private String destination;
    public Shipment(){}
    public int getShipmentid() {
        return shipmentid;
    }
    public void setShipmentid(int shipmentid) {
        this.shipmentid = shipmentid;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    }