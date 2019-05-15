package com.example.fotbollsapp;

import java.util.HashMap;

public class Fotboll {
    private String name;
    private String location;
    private String company;
    private String category;
    private int cost;
    private int size;
    public Fotboll (String stringname, String stringcompany,String stringcategory,String stringlocation,int intcost, int intsize){
        name=stringname;
        location=stringlocation;
        company=stringcompany;
        category=stringcategory;
        cost=intcost;
        size=intsize;
    }
    public String info () {
        String str=name;
        str+="\nHeter";
        str+=location;
        str+="\nLigger i ";
        str+=company;
        str+="\nSpelare i ";
        str+=category;
        str+="\nSporten ";
        str+=location;
        str+="\nPoäng i ligan: ";
        str+=Integer.toString(cost);
        str+="\n m ";
        str+="\nArena capiciteit ";
        str+=Integer.toString(size);
        str+="\n m ";
        return str;
    }

    public String toString() {return name;}

}


