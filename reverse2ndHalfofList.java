/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
	}

    public static ListNode reverseSecondHalfList(ListNode head) {
        if (head == null || head.next == null)  return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode newHead = reverseList(slow.next);
        slow.next = newHead;

        return head;
    }
    
    public static ListNode reverseList(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode prev = null;
    	while (head != null) {
    		ListNode next = head.next;
    		head.next = prev;
    		prev = head;
    		head = next;
    	}
    	return prev;
    }
    
    public static void printList(ListNode head) {
    	while (head != null) {
    		System.out.println(head.val);
    		head = head.next;
    	}
    }
     
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        
        
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        System.out.println("Original List:");
        printList(head);
        ListNode rvalue = reverseSecondHalfList(head);
        System.out.println("New List:");
        printList(rvalue);
    }
}
