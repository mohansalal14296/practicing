package org.example;

public class LinkedListPartition {
    public static void main(String[] args) {

        // Create a new LinkedList and append values to it
        LinkedList ll = new LinkedList(3);
        ll.append(5);
        ll.append(8);
        ll.append(10);
        ll.append(2);
        ll.append(1);

        // Print the list before partitioning
      //  System.out.println("LL before partitionList:");
       ll.printList(); // Output: 3 5 8 10 2 1

        // Call the partitionList method with x = 5
      //  ll.partitionList(5);

        // Print the list after partitioning
        //System.out.println("LL after partitionList:");
       // ll.printList(); // Output: 3 2 1 5 8 10

        ll.reverseBetween(2,4);
        ll.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            LL before partition_list:
            3
            5
            8
            10
            2
            1
            LL after partition_list:
            3
            2
            1
            5
            8
            10

        */

    }

}

class LinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+"  ,  ");
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void partitionList(int x){
        Node temp = head;
        Node lesserNode = new Node(0);
        Node lesser = lesserNode;
        Node greaterNode = new Node(0);
        Node greater = greaterNode;

        while(temp != null){
            if(temp.value < x){
                lesser.next=temp;
                lesser = temp;
            }else{
                greater.next = temp;
                greater = temp;
            }
            temp=temp.next;
        }
        greater.next=null;
        lesser.next=greaterNode.next;
        head= lesserNode.next;
    }


    public void reverseBetween(int m, int n) {
        System.out.println(" m & n are "+m+" "+n);
        Node dummy = new Node(0);
        dummy.next = head;
        Node beforeLeft = dummy;
        for(int i=0;i<m;i++){
            beforeLeft = beforeLeft.next;
        }
        Node prev = null;
        Node current = beforeLeft.next;
        System.out.println(current.value);
        for(int i=m;i<=n;i++){
            // System.out.println(temp.val);
            Node next = current.next;
            current.next = prev;
            prev= current;
            current=next;
        }
        beforeLeft.next.next = current;
        beforeLeft.next = prev;
    }

}

