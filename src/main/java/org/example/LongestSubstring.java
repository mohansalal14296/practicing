package org.example;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring  {

    public static void main(String[] args) {
        String str ="abcabcbb";
        int len = lengthOfLongestSubstring(str);
        System.out.println(len);
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left=0,ans=0;
        for(int right =0;right < s.length();right++){
            char ch = s.charAt(right);
            if(!map.containsKey(ch)){
                map.put(ch,right);
            }else{
                left = Math.max(left,map.get(ch)+1);
                map.put(ch,right);
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}