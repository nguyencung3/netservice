package project.cuongpg.finalproject.model;

import java.io.Serializable;

public class ModelProduct implements Serializable {
    private Long id;
    private Double quantity;
    private String name, status, unit;
    Double costPrice;

    public ModelProduct(Long id, Double quantity, String name, String status, String unit, Double costPrice) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.status = status;
        this.unit = unit;
        this.costPrice = costPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }



}
