package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DDFWithDataProvider {

    @DataProvider
    public Object [][] testData() {
        String[][] data = {
                {"Person of Interest", "10"},
                {"Sherlock", "9"},
                {"Breaking Bad", "9"},
                {"The Office", "8"},
                {"Friends", "7"},
                {"Westworld", "10"},
                {"Gotham", "9"},
                {"Dark", "8"}
        };
        return data;
    }
     @DataProvider
     public Object [][] dataFamily(){

         String [][] data = {{"Sam", "27","Driver" },{"Jan","24","Student"}, {"Heidi", "35","Housewife"}

        } ;
        return data;

    }


    @Test(dataProvider ="testData")
    public void test1(String tvshow,String rating){
        System.out.println("Tv show: "+tvshow +" has rating "+rating);

    }

    @Test(dataProvider = "dataFamily")
    public void test2(String name, String age, String job){
        System.out.println("name= " + name + " age= " + age + " job= " + job);


    }




}