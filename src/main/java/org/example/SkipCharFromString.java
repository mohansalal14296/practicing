package org.example;

public class SkipCharFromString {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        System.out.println(skip("mohansalal","a",str));
    }

    private static String skip(String mohan, String a,StringBuilder ss) {
        if(mohan.length() == 0){
            return ss.toString();
        }
        char firstChar = mohan.charAt(0);
        if(a.charAt(0) != firstChar){
            ss.append(firstChar);
        }
        return skip(mohan.substring(1),a,ss);
    }

}
