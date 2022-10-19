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
public class LinkedList_Traversal {
    
    //First Element of the LinkedList
    Node head;
    
    //Static Class - so that the main method can access this
    static class Node{
        int data;
        Node next;
        
        //Constructor
        Node(int d){
            data = d;
            next = null;
        }
    }
    
    //Item Traversal Method
    public void printList(){
        Node n = head;
        while(n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }
    
    public static void main(String[] args) {
        //List Start with Empty
        LinkedList_Traversal ls = new LinkedList_Traversal();
        
        //Three nodes have been allocated dynamically. 
        //We have refferences to three nodes as head, second and third.
        ls.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        
        //Linked First Node Whith The Second Node
        ls.head.next = second;
        
        //Linked Second Node Whith The First Node
        second.next = third;
        
        //Print Element
        ls.printList();
    }
    
}
