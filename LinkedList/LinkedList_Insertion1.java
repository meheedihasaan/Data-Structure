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
public class LinkedList_Insertion1 {
    
    //Head denotes the first Node
    Node head;
    
    //Static Class so that the Main() can access
    static class Node{
        int data;
        Node next;
        
        //Constructor
        Node(int d){
            data = d;
            next = null;
        }
    }
    
    
    //Insert Node at the beginning
    public void push(int newData){
        //Insert New Node
        Node newNode = new Node(newData);
        
        //New Node now points the previous head.
        newNode.next = head;
        
        //New Node is now new Head
        head = newNode;
    }
    
    
    //Insert Node after previous Node
    public void insertAfter(Node prevNode, int newData){
        //Check if the previous Node is null
        if(prevNode == null){
            System.out.println("The Previous Node should not be null.");
        }
        else{
            
            //Insert New Node
            Node newNode = new Node(newData);
            
            //New Node now points the previous Node's next.
            newNode.next = prevNode.next;
            
            //Previous Node now points the new Node.
            prevNode.next = newNode;
        }
    }
    
    
    //Insert new Node at any index
    public void insertAt(int index, int newData){
        //Insert New Node
        Node newNode = new Node(newData);
        if(index == 0){
            newNode.next = head;
            head = newNode;
        }
        else{
            //Find the previous Node
            Node n = head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;   //If index = 3, then we have to traverse till 1
            }
            
            //NewNode now points the previous Node's next
            newNode.next = n.next;
            
            //The Previous Node now points the NewNode
            n.next = newNode;
        }
        
        
    }
    
    
    //Insert new Node at the end of the Linked List.
    public void append(int newData){
        //Insert new Node
        Node newNode = new Node(newData);
        
        //Check if the head is null
        if(head == null){
            //If the head is null then the head will be the new Node.
            head = newNode;
        }
        else{
            //Find the previous last Node with null next.
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            
            //The Previous last node's next now points the new Node.
            last.next = newNode;
        }
    }
    
    
    //Show Element
    public void show(){
        Node n = head;
        while(n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    
    //The Main Method
    public static void main(String[] args) {
        LinkedList_Insertion1 ls1 = new LinkedList_Insertion1();
        
        ls1.append(12);   //{12}
        ls1.append(15);   //{12, 15}
        ls1.push(10);     //{10, 12, 15}
        ls1.append(20);   //{10, 12, 15, 20}
        ls1.insertAfter(ls1.head.next.next, 25);  //After Third Node  {10, 12, 15, 25, 20}
        ls1.insertAt(3, 18);  //{10, 12, 15, 18, 25, 20}
        
        ls1.show();
    }
    
}
