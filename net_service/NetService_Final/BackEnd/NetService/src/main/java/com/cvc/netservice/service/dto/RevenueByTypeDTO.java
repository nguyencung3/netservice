package com.cvc.netservice.service.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class RevenueByTypeDTO implements Serializable {

    private List<RevenueDetailDTO> listRevenueDetail;

    private Double totalRevenue;

    public RevenueByTypeDTO() {
        listRevenueDetail = new LinkedList<>();
    }

    public RevenueByTypeDTO(List<RevenueDetailDTO> listRevenueDetail, Double totalRevenue) {
        this.listRevenueDetail = listRevenueDetail;
        this.totalRevenue = totalRevenue;
    }

    public List<RevenueDetailDTO> getListRevenue() {
        return listRevenueDetail;
    }

    public void setListRevenue(List<RevenueDetailDTO> listRevenueDetail) {
        this.listRevenueDetail = listRevenueDetail;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
