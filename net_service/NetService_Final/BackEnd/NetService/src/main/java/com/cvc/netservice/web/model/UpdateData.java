package com.cvc.netservice.web.model;

import javax.validation.constraints.NotNull;

public class UpdateData {

    private Long id;

    @NotNull
    private String key = null;

    private Object value = null;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
