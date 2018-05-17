package com.cybernaptics.rfidv3;

public class DataProviderProduct {

    private String name;
    private String weight;
    private String bin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public  DataProviderProduct(String name, String weight, String bin){
        this.name = name;
        this.weight = weight;
        this.bin = bin;
    }
}
