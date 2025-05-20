package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargeElement {
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 4;
        int n = arr.length;
       // kLargestOrdinaryApproach(arr, k);
       kLargestPriorityQueue(arr, k);
      //  System.out.println(findKthLargest(arr, k));
        //kSmallestPriorityQueue(arr, k);
//        System.out.println("K'th smallest element is " + kLargestOrdinaryApproach(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq);
        return pq.peek();
    }

    private static void kSmallestPriorityQueue(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        System.out.println(pq);
        for(int i=k;i<arr.length;i++){
            if(pq.peek() > arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }

    private static void kLargestPriorityQueue(int[] arr, int k) {
        PriorityQueue<Integer> pQueue= new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pQueue.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++) {
            if (pQueue.peek() < arr[i]) {
               // System.out.println(pQueue);
                pQueue.poll();
                pQueue.add(arr[i]);
            }
        }
        System.out.println(pQueue);
    }

    private static void kLargestOrdinaryApproach(int[] arr, int k) {
        //Integer[] arr1= Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr);
        int[] reverse = new int[k];
        int n = arr.length;
        int j=0;
        for(int i=n-1;i>=(n-k);i--){
            reverse[j] = arr[i];
            System.out.println(reverse[j]);
            j++;
        }
    }



}
