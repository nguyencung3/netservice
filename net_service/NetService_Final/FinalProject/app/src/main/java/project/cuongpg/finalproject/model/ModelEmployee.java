package project.cuongpg.finalproject.model;

import java.io.Serializable;

public class ModelEmployee implements Serializable {
    private String birthdate, status, address, phone, email, fullname, photo;
    private String workingShift, storeName, role;
    private Long id;


    public ModelEmployee(String birthdate, String status, String fullname) {
        this.birthdate = birthdate;
        this.status = status;
        this.fullname = fullname;
    }

    public ModelEmployee(Long id, String birthdate, String status, String fullname, String photo, String workingShift, String storeName, String role, String address, String phone, String email) {
        this.id = id;
        this.birthdate = birthdate;
        this.status = status;
        this.fullname = fullname;
        this.photo = photo;
        this.workingShift = workingShift;
        this.storeName = storeName;
        this.role = role;
        this.phone = phone;
        this.address = address;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getWorkingShift() {
        return workingShift;
    }

    public void setWorkingShift(String workingShift) {
        this.workingShift = workingShift;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
