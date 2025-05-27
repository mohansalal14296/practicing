package org.example;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5};
        System.out.println(productExceptSelf(nums));
    }
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        // ToDo: Write Your Code Here.
        left[0] = 1;
        for(int i=1;i<len;i++){
            left[i] = left[i-1] * nums[i-1];
        }
        right[len-1]=1;
        for(int i=len-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        for(int i=0;i<len;i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
