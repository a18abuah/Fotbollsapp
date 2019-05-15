package com.example.fotbollsapp;

import java.util.HashMap;

public class Fotboll {
    private String name;
    private String location;
    private String league;
    private String category;
    private String currentcup;
    private int cost;
    private int size;
    public Fotboll (String stringname, String inLeague,String stringcategory,String stringlocation,int intcost, int intsize){
        name=stringname;
        location=stringlocation;
        league=inLeague;
        currentcup="15";
        category=stringcategory;
        cost=intcost;
        size=intsize;
    }
    public String info () {
        String str=name;
        str+="\nHeter";
        str+=location;
        str+="\nLigger i ";
        str+=league;
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

    public void Setleague (String inleague) {league=inleague;}

    public String getLeague() {String inleague=league; return inleague;}



    public void setCurrentcup (String incup) {

        // f.currentCup("EuropaLeague");
        currentcup=incup;

    }

}


