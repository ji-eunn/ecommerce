package com.project.ecommerce.controller;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {



//        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        LocalDate now = LocalDate.now();

//        DateTime

        System.out.println(new Date());
        System.out.println(now);
//        cal.set(date.getYear(),date.getMonth(),date.getDate());

        cal.set(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth());
        System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//        System.out.println(now.getDayOfMonth());
    }
}


// https://dpdpwl.tistory.com/111
// https://hianna.tistory.com/607
