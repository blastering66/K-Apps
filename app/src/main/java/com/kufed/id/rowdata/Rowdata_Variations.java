package com.kufed.id.rowdata;

/**
 * Created by macbook on 8/3/16.
 */
public class Rowdata_Variations {
    public String variation_id, variation_name, color_name, size;
    public int stock_current;

    public Rowdata_Variations(String variation_id, String variation_name, int stock_current, String color_name, String size) {
        this.variation_id = variation_id;
        this.variation_name = variation_name;
        this.stock_current = stock_current;
        this.color_name = color_name;
        this.size = size;
    }


}
