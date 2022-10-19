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
public class Day4_LinkedListCycle_142 {
    
    public class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
        }
        ListNode(int data, ListNode next){
            this.data = data;
            this.next = next;
        }
    }
    
    public static ListNode hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        boolean foundCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;  //Move by one step
            fast = fast.next.next;  //Move by two step
            if(slow == fast){
                foundCycle = true;
                break;
            }
        }
        
        //If Cycle is not found
        if(!foundCycle){
            return null;
        }
        
        //If Cycle is found
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
}
