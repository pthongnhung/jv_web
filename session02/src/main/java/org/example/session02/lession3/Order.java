package org.example.session02.lession3;


import java.util.Date;

public class Order {
    private String code;
    private String product;
    private double total;
    private Date date;

    public Order(String code, String product, double total, Date date) {
        this.code = code;
        this.product = product;
        this.total = total;
        this.date = date;
    }

    // Getter & Setter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
