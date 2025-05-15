package org.example;

public class EqualsMethodAndEqualsOperator {
    public static void main(String[] args) {
        String str1 = "Salal";
        String str2 ="Salal";
        String str3 = new String("Salal");
        System.out.println(str1==str2); //true
        System.out.println(str1==str3); //false
        System.out.println(str1.equals(str2)); //true
        System.out.println(str1.equals(str3)); //true
    }
}
