package com.java2novice.algos;
 
import java.util.HashSet;
import java.util.Set;
 
public class LinkedListLoopCount {
 
    static class Node {
        int data;
        Node next;
        Node(int tmp) {data = tmp;}
    }
 
    public static void main(String[] a){
 
        Node n1 = new Node(34);
        Node n2 = new Node(25);
        Node n3 = new Node(31);
        Node n4 = new Node(56);
        Node n5 = new Node(45);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
 
        System.out.println("Loop count: "+identifyLoopCount(n1));
    }
 
    static int identifyLoopCount(Node head) {
 
        Node slowMv = head;
        Node fastMv = head;
        while (slowMv != null && fastMv != null && fastMv.next != null) {
            slowMv = slowMv.next;
            fastMv = fastMv.next.next;
            if(slowMv == fastMv) {
                return loopCount(slowMv);
            }
        }
        return 0;
    }
 
    static int loopCount(Node node) {
 
        int count = 1;
        Node tmp = node;
        while(tmp.next != node) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }
}
