package com.example.smashnotes_back;

public class Item {
    private int itemNo;
    private String itemDesc;
    private float itemprice;

    public Item(int itemNo, String itemDesc, float itemprice){
        super();
        this.itemNo=itemNo;
        this.itemDesc=itemDesc;
        this.itemprice=itemprice;
    }

    public int getItemNo(){
        return itemNo;
    }

    public void getItemNo(int itemNo){
        this.itemNo=itemNo;

    }



    public String getItemDesc(){
        return itemDesc;
    }

    public void setItemDesc(String itemDesc){
        this.itemDesc=itemDesc;
    }

    public float getItemprice(){
        return itemprice;
    }

    public void setItemPrice(float itemPrice){
        this.itemprice=itemPrice;
    }



    }




