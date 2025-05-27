package org.example;

public class FindMaxSumSubArray {
  public static void main(String[] args) {
    int[] arr = new int[]{2, 1, 5, 1, 3, 2};
    System.out.println(findMaxSumSubArray(3, arr));
  }

  public static int findMaxSumSubArray(int k, int[] arr) {
    // TODO: Write your code here
    int left = 0, sum = 0, max = 0, newSum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (left < k) {
        sum = Math.max(arr[i], arr[i] + sum);
        newSum = sum;
        left++;
      } else {
        newSum = newSum - arr[i - k] + arr[i];
        sum = Math.max(sum, newSum);
      }
      max = Math.max(max, sum);
    }
    return max;
  }
}
