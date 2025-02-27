package org.example;

import java.time.LocalTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(
                "Thread " + Thread.currentThread().getName());
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            MultithreadingDemo object1
                    = new MultithreadingDemo();
            MultithreadingDemo object2 = new MultithreadingDemo();
          //  object1.start();
           // object1.start(); it will throw exception
            object1.setName("Thread1");
            //object2.start();
            object2.setName("Thread2");
        }
        Test<Integer> test = i -> i < 0  ;
        System.out.println("test of lambda "+ test.isNegative(-2));

        Add<Integer,Float> add = (a,b) -> a+b;
        Predicate<Integer> predicate = i -> i%2==0;
        System.out.println("Addition of 2 number " + add.add(2, 3.5f));
        System.out.println("Number is even " + predicate.test(4));
        BiPredicate<Integer,String> predicate1 = (a,b) -> b.length() == a;

        System.out.println("lenght is equal to 5 = " + predicate1.test(5,"MohanSalal"));


        Supplier<LocalTime> localTime = () -> LocalTime.now();
        System.out.println("Current time is "+localTime.get());

        Supplier<Double> rndm = () -> (Math.random());
        System.out.println("Random number is "+rndm.get());

        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Hello World");

        List<String> lst =new ArrayList<>();
        lst.add("Mohan");
        lst.add("Salal");
        lst.forEach(consumer);

        BiConsumer<String,String> biconsumerPrint = (a,b) -> System.out.println("First name is "+ a +" second name "+ b);
        Map<String,String> map =new HashMap<>();
        BiConsumer<String,String> mapConsumer = (a,b) ->map.put(a,b);
        mapConsumer.accept("Mohan","Salal");
        mapConsumer.accept("Rahul","Salal");
        map.forEach(biconsumerPrint);


        Function<String,Integer> func = s -> s.length();
        System.out.println("lenght of func is "+func.apply("mohan"));
        BiFunction<String,String,String> func2 = (a,b) -> a.concat(b);
        System.out.println("Concat of 2 string is "+func2.apply("Mohan","Salal"));

        List<String> str = Arrays.asList("Mohan1","Salal","Rahul1","Salal22");

        str.stream().peek(System.out::println).filter(s -> {
            System.out.println("filter "+s);
            return s.length() > 5;
        }).forEach(System.out::println);

        System.out.println("Break for new things");
        str.forEach(System.out::println);

        Stream.iterate(1, i -> i+1).limit(10).forEach(System.out::println);

        str.stream().reduce((a,b) -> a.length() > b.length() ? a : b).ifPresent(System.out::println);
        System.out.println("Break for new things");
        int length = str.stream().reduce(0, (n0,s) -> n0+s.length(), (n1,n2) -> n1+n2);
        System.out.println("Length of string is "+length);

        Collection<String> col = Arrays.asList("Mohan","Salal","Rahul","Salal");
        col.add("Mohan");
        col.stream().forEach(System.out::println);
    }
}

interface Test<T>{
    boolean isNegative(T t);
}

interface Add<T,V> {
    V add(T t,V v);
}
class MultithreadingDemo extends Thread {
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                    "Thread " + Thread.currentThread().getName()
                            + " is running");
            System.out.println(" Daemon Thread check "+Thread.currentThread().isDaemon() + "Priority"+Thread.currentThread().getPriority());
            //Thread.currentThread().sleep(100000);
           // Thread.currentThread().wait(10000);
           // Thread.currentThread().notify();

            //System.out.println("done");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}