package org.example;

import java.util.*;

public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = new int[]{-3, 0, 1, 2, -1, 1, -2};
    System.out.println(searchTriplets(nums));
  }

  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> triplets = new ArrayList<>();
    Arrays.sort(arr);   //-3,-2,-1,0,1,1,2
    int left, right,sum=0,len = arr.length;
    for(int i=0;i<arr.length-2;i++){
      if(i>0 && arr[i] == arr[i-1]){
        continue;
      }
      left = i+1;
      right = len-1;
      while(left<right){
        sum=arr[i]+arr[left]+arr[right];
        if(sum==0){
          triplets.add(Arrays.asList(arr[i],arr[left],arr[right]));
          while(left < right && arr[left]==arr[left+1]){
            left++;
          }
          while(left < right && arr[right]==arr[right-1]){
            right--;
          }
          left++;
          right--;
        }else if(sum<0){
          left++;
        }else{
          right--;
        }
      }
    }
    System.out.println(triplets.size());
    return triplets;
  }
}
