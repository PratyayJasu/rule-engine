package com.example.ruleengine;

public class ResponseBack {
    private String nextPage;
    private double amount;
    private double flexLimit;
    private double pilLimit;
    private String primary;
    private String secondary;

    public String getNextPage() {
        return nextPage;
    }

    public double getAmount() {
        return amount;
    }

    public double getFlexLimit() {
        return flexLimit;
    }

    public double getPilLimit() {
        return pilLimit;
    }

    public String getPrimary() {
        return primary;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setFlexLimit(double flexLimit) {
        this.flexLimit = flexLimit;
    }

    public void setPilLimit(double pilLimit) {
        this.pilLimit = pilLimit;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }
}
