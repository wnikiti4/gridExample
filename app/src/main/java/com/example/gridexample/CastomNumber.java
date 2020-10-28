package com.example.gridexample;

public class CastomNumber {
    static int a;
    static Color color;

    CastomNumber(int a){
        this.a = a;
        this.color = (a % 2 == 0) ? Color.RED : Color.BLUE;
    }
}
