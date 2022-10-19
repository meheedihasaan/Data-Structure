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
public class LinkedList_Deletion {
    
    //First node of the list
    Node head;
    
    //Static class so that main() can access
    static class Node{
        int data;
        Node next;
        
        //Constructor
        Node(int d){
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
    
    //Delete Node According To  Data
    public void deleteNode(int key){
        //Store head node into temp
        Node temp = head;
        Node prev = null;
        
        //If head node itself holds the key  to be deleted
        if(temp != null && temp.data == key){
            head = temp.next;
            return;
        }
             
        //Search for the key to be deleted
        while(temp != null && temp.data != key){
            prev = temp;
            temp = temp.next;   //Deleteing node at the end of the loop
        }
        
        //If key is not present in the linked list
        if(temp == null){
            return;
        }
        
        //Unlink the node from the linked list
        prev.next = temp.next;
    }
    
    
    //Delete Node From The Specific Index
    public void deleteAt(int index){
        //Check if the Linked List is initially empty
        if(head == null){
            return;
        }
        
        //Check If the index is 0
        if(index == 0){
            Node temp = head.next;
            head = temp;
        }
        else{
            Node temp = null;
            
            //Find previous Node
            Node n = head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;  //If the index is 3, then traverse till 1
            }
            
            //Assign deleting node to temp
            temp = n.next;
            
            //Previous Node now points the temp Node's next.
            n.next = temp.next;
            
            //For Garbage Collection
            temp = null;
        }
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
        ///List Start with Empty
        LinkedList_Deletion lsd = new LinkedList_Deletion();
        
        //Insert Node At Front of the list
        lsd.push(1);
        lsd.push(2);
        lsd.push(3);
        lsd.push(4);
        lsd.push(5);  //{5, 4, 3, 2, 1}
        
        //Delete the value(2)
        lsd.deleteNode(2);  //{5, 4, 3, 1}
        
        //Delete the index-1(4)
        lsd.deleteAt(1);    //{5, 3, 1}
        
        //Print list
        lsd.printList();
        
    }
    
}
