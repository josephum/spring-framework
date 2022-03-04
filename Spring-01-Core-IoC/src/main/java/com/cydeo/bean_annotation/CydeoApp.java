package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class,ConfigAny.class);

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);
        PartTimeMentor pt = container.getBean("p1",PartTimeMentor.class); // Extra "p1" to differentiate beans
        PartTimeMentor pt2 = container.getBean("p2",PartTimeMentor.class); // Extra "p2" to differentiate beans

        ft.createAccount();
        pt.createAccount();
        pt2.createAccount();

        String str = container.getBean(String.class);
        System.out.println(str);

        Integer i = container.getBean(Integer.class);
        System.out.println(i);



    }
}
