package org.example;

/**
 * Definition for singly-linked list. */
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode sum = new ListNode(0);
       ListNode head = sum;
       
       int carry = 0;
        System.out.println(l1.next.next);
       while(l1 != null){
            System.out.println(l1.val+" "+ l2.val);
            int summ= l1.val+l2.val+carry;
            carry = carry % 10;
            System.out.println(summ);
            ListNode temp = new ListNode(summ/10);
            sum.next = temp;
            System.out.println(sum.val);
        }

        return sum;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(3);
        ListNode l2 = new ListNode(2);
        System.out.println(addTwoNumbers(l1,l2).val);
    }
}