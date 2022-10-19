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
public class NewClass {
   
    Node head;
    
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    
    public void push(int newData){
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }
    
    public void append(int newData){
        Node newNode = new Node(newData);
        if(head == null){
            head = newNode;
        }
        else{
            Node n = head;
            while(n.next != null){
                n = n.next;
            }
            n.next = newNode;
        }
    }
    
    public void insertAt(int index, int newData){
        Node newNode = new Node(newData);
        if(index == 0){
            newNode.next = head;
            head = newNode;
        }
        else{
            Node n = head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            newNode.next = n.next;
            n.next = newNode;
        }
    }
    
    public void insertAfter(Node prevNode, int newData){
        if(head == null){
            System.out.println("Linked can not be initially empty!");
        }
        else{
            Node newNode = new Node(newData);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }      
    }
    
    public void deleteAt(int index){
        if(head == null){
            return;
        }
        
        if(index == 0){
            head = head.next;
        }
        else{
            Node temp = null;
            Node n = head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            temp = n.next;
            n.next = temp.next;
            
            temp = null;
        }
    }
    
    public void show(){
        Node n = head;
        while(n != null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        NewClass nc = new NewClass();
        
        nc.push(10);        //{10}
        nc.push(12);        //{12, 10}
        nc.append(20);      //{12, 10, 20}
        nc.push(15);        //{15, 12, 10, 20}
        nc.insertAt(0, 25); //{25, 15, 12, 10, 20}
        nc.insertAfter(nc.head.next, 100);  //{25, 15, 100, 12, 10, 20};
        nc.deleteAt(3);     //{15, 15, 100,   , 10, 20}
        
        nc.show();
    }
    
}
