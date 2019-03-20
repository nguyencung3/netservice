package com.cvc.netservice.service.dto;

import java.io.Serializable;

public class GoodsDTO implements Serializable {

    private Long id;

    private String goodName;

    private String description;

    private Double costPrice;

    private String nameUnit;

    private Long basicUnitId;

    private Long exchangeValue;

    private String quantityInStock;

    private String status;

    private Boolean remove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public String getNameUnit() {
        return nameUnit;
    }

    public void setNameUnit(String nameUnit) {
        this.nameUnit = nameUnit;
    }

    public Long getBasicUnitId() {
        return basicUnitId;
    }

    public void setBasicUnitId(Long basicUnitId) {
        this.basicUnitId = basicUnitId;
    }

    public Long getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(Long exchangeValue) {
        this.exchangeValue = exchangeValue;
    }

    public String getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(String quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
