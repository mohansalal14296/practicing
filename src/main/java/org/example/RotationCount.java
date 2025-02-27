package org.example;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.PriorityQueue;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 4;
        int n = arr.length;
       // kLargclass Solution {
        //    public int reverse(int x) {
        //        int digit,rev=0;
        //        int temp = x;
        //        while(x != 0){
        //                rev = rev *10 + x %10;
        //                x/=10;
        //        }
        //        if(rev < -2147483648  && rev > 2147483647)
        //            return 0;
        //
        //        if(temp < 0){
        //            rev = (rev * (-1));
        //           // System.out.println(rev);
        //        }
        //        return rev;
        //    }
        //}estOrdinaryApproach(arr, k);
     //   kLargestPriorityQueue(arr, k);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime newTime = DateTime.now().minusSeconds(43500);
        System.out.println(formatter.print(newTime));

//        System.out.println("K'th smallest element is " + kLargestOrdinaryApproach(arr, k));
    }

    private static void kLargestPriorityQueue(int[] arr, int k) {
        PriorityQueue<Integer> pQueue= new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pQueue.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++) {
            if (pQueue.peek() < arr[i]) {
                System.out.println(pQueue);
                pQueue.poll();
                pQueue.add(arr[i]);
            }
        }
        System.out.println(pQueue);
        System.out.println((int)(7/2));
    }}
