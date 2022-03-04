package com.cydeo;

public class TestJavaSingleton {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();

        System.out.println(a==b);

        ClassicSingleton c = ClassicSingleton.getInstance();
        ClassicSingleton d = ClassicSingleton.getInstance();
        System.out.println(c==d);
    }
}



class Singleton {

    private static Singleton singleton = new Singleton( );

    private Singleton(){}

    public static Singleton getInstance(){
        return singleton;
    }
}

class ClassicSingleton {

    private static ClassicSingleton instance = null;
    private ClassicSingleton() {
        // Exists only to defeat instantiation.
    }

    public static ClassicSingleton getInstance() {
        if(instance == null) {
            instance = new ClassicSingleton(); // Lazy instantiation
        }
        return instance;
    }
}