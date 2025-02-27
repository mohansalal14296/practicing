package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 4;
        int n = arr.length;
       // kLargestOrdinaryApproach(arr, k);
        kLargestPriorityQueue(arr, k);
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
