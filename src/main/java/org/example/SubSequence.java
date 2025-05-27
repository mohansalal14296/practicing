package org.example;

public class SubSequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n=t.length();
        int j=0;
        for(int i=0;i<n;i++){
            if(j<m && s.charAt(j) == t.charAt(i)){
                j++;
            }
            if(j==(m-1)){
                return true;
            }
        }
        return false;
    }
}