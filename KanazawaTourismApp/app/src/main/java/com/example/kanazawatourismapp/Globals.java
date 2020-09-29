package com.example.kanazawatourismapp;
import android.app.Application;
import java.util.ArrayList;

public class Globals extends Application {

    public ArrayList<Integer> spot = new ArrayList<>();
    public ArrayList<String> Global_data= new ArrayList<String>();

    public void dataadd1(String data1) {
        Global_data.add(data1);
    }
    public void dataadd2(String data2) {
        Global_data.add(data2);
    }
    public void dataadd3(String data3) {
        Global_data.add(data3);
        System.out.println(Global_data);
    }
    public void spotadd1(int pos){
        spot.add((pos));
    }
    public void spotadd2(int pos){
        spot.add((pos));
    }
    public void spotadd3(int pos){
        spot.add((pos));
        System.out.println(spot);
    }
    public String get1() {
        String data1 = Global_data.get(0);
        return data1;
    }
    public String get2() {
        String data2 = Global_data.get(1);
        return data2;
    }
    public String get3() {
        String data3 = Global_data.get(2);
        return data3;
    }
    public int spotget(int i){
        int destination = spot.get(i);
        return destination;
    }
    public void remove() {
        Global_data.remove(0);
        spot.remove(0);
        System.out.println(Global_data);
    }
    public void clear() {
        Global_data.clear();
        spot.clear();
        System.out.println(Global_data);
    }


    public int size() {
        return Global_data.size();
    }
}

