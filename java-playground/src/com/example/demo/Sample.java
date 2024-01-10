package com.example.demo;

public class Sample {

    public String mat(String... part){
        String joined ="";

        for (String parts:part
             ) {
            joined += parts+", ";
        }

        return joined;
    }
    public void kat(int... a){
        int sum=0;
        for (int ax:a) {
             sum+=ax;
        }
        System.out.println(sum);
       // return sum;
    }

    public String join(String... parts){
        StringBuilder sb = new StringBuilder();

        for(String part:parts){
            sb.append(part);
            sb.append(", ");
        }
        return sb.toString();
    }
}
