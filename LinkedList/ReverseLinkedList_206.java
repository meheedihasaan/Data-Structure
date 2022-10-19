/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Acer
 */


public class Day3_ReverseLinkedList_206 {
    
    class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
    
}
