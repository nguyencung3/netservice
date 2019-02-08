package project.cuongpg.finalproject.model;

public class ModelComputerFee {

    private String customerName, time;
    private Double price;

    public ModelComputerFee(String customerName, String time, Double price) {
        this.customerName = customerName;
        this.time = time;
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
