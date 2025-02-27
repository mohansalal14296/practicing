package org.example;

public class TargetFirstLast {
    public static void main(String[] args) {
        int[] arr = {5,7,7,7,7,8,8,10};
        int target = 7;
        int firstPosition = firstPosition(arr, target,true);
        if(firstPosition == -1){
            System.out.println("Element not found");
        }
        int lastPosition = firstPosition(arr, target,false);
        System.out.println("First Position of the target is: " + firstPosition + " Last Position of the target is: " + lastPosition);
    }

    private static int firstPosition(int[] arr, int target, boolean b) {
        int start = 0;
        int end = arr.length;
        int posibleAns = -1;
        while(start <= end){
            int mid=start+(end-start)/2;
            if(arr[mid] == target){
                posibleAns = mid;
                if(b){
                    end = mid - 1;
                }else{
                    start=mid+1;
                }
            }else if(arr[mid] < target) {
                start = mid + 1;
            }else{
                end=mid-1;
            }
        }
        return posibleAns;
    }

}
