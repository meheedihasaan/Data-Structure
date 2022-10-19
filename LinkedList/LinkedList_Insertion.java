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
public class LinkedList_Insertion {
    //First Node Of The LinkedList
    Node head;
    
    
    //Static Class so tha the main() can access
    static class Node{
        int data;
        Node next;
        public Node(int d){
            data = d;
            next = null;
        }
    }
    
    //Insert Node At Front Of The List
    public void push(int newData){
        //Allocate the new node and put in the data
        Node newNode = new Node(newData);
        
        //newNode now points the previous head
        newNode.next = head;
        
        //Now newNode is the head element
        head = newNode;
    }
    
    //Insert the new node after the giver previous node
    public void insertAfter(Node prevNode, int newData){
        //Check if the given previous node is null
        if(prevNode == null){
            System.out.println("Previous Node can not be null!");
            return;
        }
        
        //Allocate the new node and put in the data
        Node newNode = new Node(newData);
        
        
        //NewNode now points the previous node's next node.
        newNode.next = prevNode.next;
        
        //Previous node now points the new node
        prevNode.next = newNode;
    }
    
    //Inserts a new node at the end of the list
    public void append(int newData){
        //Check if the list is empty then, make the newNode as head
        if(head == null){
            head = new Node(newData);
            return;
        }
        
        //Allocate the newNode, put in the data, set next as null
        Node newNode = new Node(newData);
        
        //This node is going to be the last node. So it's next should be null
        newNode.next = null;
        
        
        //Traverse till the previous next node
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        
        //The previous last node now points the new last node.
        last.next = newNode;
        return;
    }
    
    //Linked List Traversal
    public void printList(){
        Node n = head;
        while(n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
    }
    
    public static void main(String[] args) {
        //List Start with Empty
        LinkedList_Insertion lsi = new LinkedList_Insertion();
        
        //Insert as head
        lsi.append(5);           //Second Node    {5}
        
        //Insert at the end
        lsi.append(10);          //Fourth Node    {5, 10}
        
        //Insert at front
        lsi.push(4);              //First Node    {4, 5, 10}
        
        //Insert between second and Fourth node
        lsi.insertAfter(lsi.head.next, 6);      //Third Node     {4, 5, 6, 10}
        lsi.printList();
    }
    
}
