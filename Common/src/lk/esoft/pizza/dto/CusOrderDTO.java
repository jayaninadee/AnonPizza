package lk.esoft.pizza.dto;

import java.io.Serializable;

public class CusOrderDTO implements Serializable {
    private int odId;
    private String cusName;
    private String cusTel;
    private String cusAddress;
    private String pizza;
    private int qty;
    private int status;
    private String coUn;
    private String chUn;
    private String startTime;
    private String finishTime;
    private String orderTime;

    public CusOrderDTO(int odId, String finishTime) {
        this.odId = odId;
        this.finishTime = finishTime;
    }

    public CusOrderDTO(int odId, String chUn, String startTime) {
        this.odId = odId;
        this.chUn = chUn;
        this.startTime = startTime;
    }

    public CusOrderDTO(int odId, String cusName, String cusTel, String cusAddress, String pizza, int qty, int status, String coUn, String chUn, String startTime, String finishTime, String orderTime) {
        this.odId = odId;
        this.cusName = cusName;
        this.cusTel = cusTel;
        this.cusAddress = cusAddress;
        this.pizza = pizza;
        this.qty = qty;
        this.status = status;
        this.coUn = coUn;
        this.chUn = chUn;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.orderTime = orderTime;
    }

    public int getOdId() {
        return odId;
    }

    public void setOdId(int odId) {
        this.odId = odId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusTel() {
        return cusTel;
    }

    public void setCusTel(String cusTel) {
        this.cusTel = cusTel;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCoUn() {
        return coUn;
    }

    public void setCoUn(String coUn) {
        this.coUn = coUn;
    }

    public String getChUn() {
        return chUn;
    }

    public void setChUn(String chUn) {
        this.chUn = chUn;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
