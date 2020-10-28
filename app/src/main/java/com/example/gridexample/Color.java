package com.example.gridexample;

public enum Color {
    RED("#FF0000"),
    BLUE("#0000FF"),
    GREEN("#00FF00");
    private String code;
    Color(String code){
        this.code = code;
    }
    public String getCode(){ return code;}
}
