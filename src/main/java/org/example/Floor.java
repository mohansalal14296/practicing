package org.example;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 12, 13, 19};
        int target = 11;
        System.out.println("Floor of the target is: " + floorFind(arr, target));
    }

    private static int floorFind(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while(start <= end){
            int mid=start+(end-start)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target) {
                start = mid + 1;
            }else{
                end=mid-1;
            }
        }
        return start;
    }

}
