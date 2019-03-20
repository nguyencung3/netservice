package com.cvc.netservice.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goods")
public class Goods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "good_name")
    private String goodName;

    @Column(name = "description")
    private String description;

    @Column(name = "cost_price")
    private Double costPrice;

    @Column(name = "name_unit")
    private String nameUnit;

    @Column(name = "basic_unit_id")
    private Long basicUnitId;

    @Column(name = "exchange_value")
    private Long exchangeValue;

    @Column(name = "quantity_in_stock")
    private String quantityInStock;

    @Column(name = "status")
    private String status;

    @Column(name = "is_remove")
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
