package com.example.currencyconversionservice.beans;

import java.math.BigDecimal;

public class ConversionBean {

    Long id;
    String from;
    String to;
    BigDecimal multiple;
    int port;
    BigDecimal quantity;
    BigDecimal calculatedAmount;

    public ConversionBean(){}
    public ConversionBean(Long id, String from, String to, BigDecimal multiple, int port, BigDecimal quantity, BigDecimal calculatedAmount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.multiple = multiple;
        this.port = port;
        this.quantity = quantity;
        this.calculatedAmount = calculatedAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getMultiple() {
        return multiple;
    }

    public void setMultiple(BigDecimal multiple) {
        this.multiple = multiple;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(BigDecimal calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }
}
