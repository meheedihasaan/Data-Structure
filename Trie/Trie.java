/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trie;

/**
 *
 * @author User
 */

class Node{
    Node links[] = new Node[26];
    boolean flag = false;
    
    Node(){
        
    }
    
    public boolean containsKey(char c){
        if(links[c-'a'] == null){
            return false;
        }
        return true;
    }
    
    public Node get(char c){
        return links[c-'a'];
    }
    
    public void put(char c, Node node){
        links[c] = node;
    }
    
    public void setEnd(){
        flag = true;
    }
    
    public boolean isEnd(){
        return flag;
    }
}

public class Trie {
    Node root;
    
    public Trie(){
        root = new Node();
    }
    
    public void insert(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    public boolean search(String word){
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.containsKey(c)){
                return false;
            }
            node = node.get(c);
        }
        
        if(node.isEnd()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean startsWith(String prefix){
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!node.containsKey(c)){
                return false;
            }
            node = node.get(c);
        }
        return true;
    }
}
