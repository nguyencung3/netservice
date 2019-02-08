package com.cvc.netservice.service.dto;

import java.io.Serializable;
import java.util.List;

public class OrderDetailDTO implements Serializable {

    private Long id;

    private Long orderId;

    private Long orderStaffId;

    private Long orderCustomerId;

    private Long productId;

    private Double unitPrice;

    private Double discount;

    private Double quantity;

    private String typeOrder;

    private String productName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderStaffId() {
        return orderStaffId;
    }

    public void setOrderStaffId(Long orderStaffId) {
        this.orderStaffId = orderStaffId;
    }

    public Long getOrderCustomerId() {
        return orderCustomerId;
    }

    public void setOrderCustomerId(Long orderCustomerId) {
        this.orderCustomerId = orderCustomerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
