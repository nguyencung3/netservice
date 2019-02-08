package project.cuongpg.finalproject.model;

import java.io.Serializable;

public class ModelFoodDrink implements Serializable {
    private String customerName, time, foodName;
    private Double price,quantity;

    public ModelFoodDrink(String customerName, String time, String foodName, Double price, Double quantity) {
        this.customerName = customerName;
        this.time = time;
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
    }

    public ModelFoodDrink() {
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }


}
