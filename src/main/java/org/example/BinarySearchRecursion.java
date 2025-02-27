package org.example;

public class BinarySearchRecursion
{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 9;
        System.out.println(binarySearchRecursion(arr, target, 0, arr.length - 1));
    }

    private static int binarySearchRecursion(int[] arr, int target, int start, int end) {
        boolean foundTarget = false;
        if(start> end){
            return -1;
        }
        int mid = start+(end-start)/2;
        if(arr[mid] == target) foundTarget= true;
        else if(arr[mid]>target) end = mid-1;
        else start = mid+1;

        if(foundTarget)
                return mid;
        return binarySearchRecursion(arr,target,start,end);
    }
}
