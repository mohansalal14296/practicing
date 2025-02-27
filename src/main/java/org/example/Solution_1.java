package org.example;

import java.util.*;

class Solution_1 {
    public static void main(String[] args) {
      //  System.out.println(reverse(1534236469));
        int[] nums = {-1,0,1,2,-1,-4};
      //  System.out.println(threeSum(nums));
        dfs("abc","");

    }
    public static void dfs(String str,String perm){
        if(str.length()==0){
            System.out.println(perm);
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String tmp = str.substring(0,i)+str.substring(i+1);
            dfs(tmp,ch+perm);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int left,sum=0,right;
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            left = i+1;
            right=nums.length-1;
            while(left < right){
                sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int n = s.length();
        int result=0;
        for(int i=0;i<n;i++){
            if(i<n-1 && (map.get(s.charAt(i)) < map.get(s.charAt(i+1)))){
                result -=map.get(s.charAt(i));
            }else{
                result +=map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static double myPow(double x, int n) {
        double pow=1;
        int temp=n;
        while(n!=0){
            if(n%2==1){
                pow *=x;
                n--;
            }
            x = x*x;
            n = n/2;
        }
        return temp < 0 ? (1/pow) : pow;
    }
    public static int reverse(int x) {
        int digit,rev=0;
        int min = Integer.MIN_VALUE;
        int max= Integer.MAX_VALUE;
        int temp = x;    
        while(x != 0){
            if(rev <  (min/10) || rev > (max/10))
                return 0;

                rev = rev *10 + x %10;
                x/=10;
        }
    
        if(temp < 0){
        //    rev = (rev * (-1));
           System.out.println(rev);
        }        
        return rev;
    }
}