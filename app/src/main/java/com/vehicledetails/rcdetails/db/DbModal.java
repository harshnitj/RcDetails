package com.vehicledetails.rcdetails.db;

import java.io.Serializable;

public class DbModal implements Serializable {
    private int id;
    private  String regNo;
    private String regAuth;
    private String regDate;
    private String chasis;
    private String engine;
    private String fuel;
    private String model;
    private String manufact;
    private String owner;
    private  String finacer;
    private String fitness;
    private String insuranceExp;
    private String vehicleClass;
    private  String vehiclePermit;
    private String vehiclePermitDate;

    public DbModal( String regNo, String regAuth, String regDate, String chasis, String engine, String fuel, String model, String manufact, String owner, String finacer, String fitness, String insuranceExp, String vehicleClass, String vehiclePermit, String vehiclePermitDate) {
        this.regNo = regNo;
        this.regAuth = regAuth;
        this.regDate = regDate;
        this.chasis = chasis;
        this.engine = engine;
        this.fuel = fuel;
        this.model = model;
        this.manufact = manufact;
        this.owner = owner;
        this.finacer = finacer;
        this.fitness = fitness;
        this.insuranceExp = insuranceExp;
        this.vehicleClass = vehicleClass;
        this.vehiclePermit = vehiclePermit;
        this.vehiclePermitDate = vehiclePermitDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getRegAuth() {
        return regAuth;
    }

    public void setRegAuth(String regAuth) {
        this.regAuth = regAuth;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getFinacer() {
        return finacer;
    }

    public void setFinacer(String finacer) {
        this.finacer = finacer;
    }

    public String getFitness() {
        return fitness;
    }

    public void setFitness(String fitness) {
        this.fitness = fitness;
    }

    public String getInsuranceExp() {
        return insuranceExp;
    }

    public void setInsuranceExp(String insuranceExp) {
        this.insuranceExp = insuranceExp;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public String getVehiclePermit() {
        return vehiclePermit;
    }

    public void setVehiclePermit(String vehiclePermit) {
        this.vehiclePermit = vehiclePermit;
    }

    public String getVehiclePermitDate() {
        return vehiclePermitDate;
    }

    public void setVehiclePermitDate(String vehiclePermitDate) {
        this.vehiclePermitDate = vehiclePermitDate;
    }
}
