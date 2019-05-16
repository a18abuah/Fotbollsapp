package com.example.fotbollsapp;

import java.util.HashMap;

public class Fotboll {
    private String name;
    private String location;
    private String league;
    private String category;
    private String currentcup;
   /* private int PremierLeaguewins;
    private int FaCupwins;*/
    private int cost;
    private int size;
    public Fotboll(String stringname, String inLeague, String stringcategory, String stringlocation, int intcost, int intsize){
        name=stringname;
        location=stringlocation;
        league=inLeague;
        currentcup="15";
        category=stringcategory;
        cost=intcost;
        size=intsize;
        /*this.PremierLeaguewins=premierLeaguewins;
        this.FaCupwins=faCupwins;*/
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

    public void setName(String inname) {
        this.name = inname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCurrentcup(String currentcup) {
        this.currentcup = currentcup;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        String inname=name;
        return inname;
    }

    public String getLocation() {
        return location;
    }

    public String getLeague() {
        return league;
    }

    public String getCategory() {
        return category;
    }

    public String getCurrentcup() {
        return currentcup;
    }

    public int getCost() {
        return cost;
    }

    public int getSize() {
        return size;
    }

    /*public void setPremierLeaguewins(int premierLeaguewins) {
        PremierLeaguewins = premierLeaguewins;
    }

    public void setFaCupwins(int faCupwins) {
        FaCupwins = faCupwins;
    }

    public int getPremierLeaguewins() {
        return PremierLeaguewins;
    }

    public int getFaCupwins() {
        return FaCupwins;
    }*/
}



