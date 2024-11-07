package com.util.utile;

import java.util.Date;

public class emailTimeStamp {

    public static String emailStamp (){
        Date date = new Date();
        String timeStump = date.toString().replace(" ", "_").replace(":", "_");
        return "seleniumpanda"+timeStump+"@gmail.com";
    }
}
