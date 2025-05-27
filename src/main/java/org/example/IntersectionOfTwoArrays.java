package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        intersect(nums1,nums2);
    }
    public static void intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for( int num : nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num2 : nums2){
            if(map.containsKey(num2) && map.get(num2) > 0){
                map.put(num2, map.get(num2)-1);
                list.add(num2);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0;i< list.size();i++){
            res[i]= list.get(i);
            System.out.println(res[i]);
        }
    }
}