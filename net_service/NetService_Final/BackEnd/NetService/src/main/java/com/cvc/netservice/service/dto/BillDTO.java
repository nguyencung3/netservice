package com.cvc.netservice.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BillDTO implements Serializable {

    private Long id;

    private String orderDate;

    private String nameCustomer;

    private String nameStaff;

    private Double totalPrice;

    private Double priceDiscount;

    private Double totalPriceDiscounted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Double priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public Double getTotalPriceDiscounted() {
        return totalPriceDiscounted;
    }

    public void setTotalPriceDiscounted(Double totalPriceDiscounted) {
        this.totalPriceDiscounted = totalPriceDiscounted;
    }
}
