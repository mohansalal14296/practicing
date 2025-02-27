package org.example;

public class FibonacciSeries
{
    public static void main(String[] args)
    {
        int n = 4;
       System.out.println(" recursion "+fib(n, true));
        int a=1,b=0,s=0;
        for(int i=1;i<n;i++){
            s =a+b;
            b=a;
            a=s;
        }
        System.out.println(" Normal way "+s);
    }

    private static int fib(int n, boolean isFirst)
    {
        System.out.println("Calculating fib(" + n + ") and isFirst = "+isFirst);

        if (n <= 1)
            return n;
        return fib(n - 1,true) + fib(n - 2,false);
    }
}
