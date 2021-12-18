package com.senoJmartMH.jmart_android.model;

/**
 * Class Product - class untuk mendefinisikan object product
 *
 * @author Seno Aji Wicaksono
 * @version 18-12-2021
 */

public class Product extends Serializable{
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;

    @Override
    public String toString(){
        return name;
    }
}
