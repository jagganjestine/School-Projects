//Jaggan Jestine
//CS 3345.001
//Project 1
//Generic Linked List
package genlinkedlist;

import java.util.*;
import java.io.*;

public class GenLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    int size = 0;

    //a
    //adds a new node to the front
    public void addFront(T element) {
        Node<T> newNode = new Node<>(element, null);
        if (size == 0) {
            tail = newNode; //if list is empty, it makes head = tail
        } else {
            newNode.next = head; //else a newNode is made as the head
        }
        head = newNode;
        size++;
    }

    //b
    //adds a new node to the end
    public void addEnd(T element) {
        Node<T> newNode = new Node<>(element, null);
        if (size == 0) {
            head = newNode;//if list is empty, it makes head = tail
        } else {
            tail.next = newNode;//else a new node is added at the end as the new tail
        }
        tail = newNode;
        size++;
    }

    //c
    //removes the current head of the list
    public T removeFront() {
        T olddata = null;

        if (head == null) {
            throw new NoSuchElementException(); //if head is null
        }
        if (head == tail) {
            olddata = head.data;
            head = tail = null; //if head = tail, meaning the list size is 1, it makes the element null
        } else {
            olddata = head.data; //else it saves the node next to the head, deletes the current head, and moves the new head to the top
            head = head.next;
        }
        size--;
        return olddata;

    }

    //d
    //removes the current tail of the list
    public T removeEnd() {
        T olddata = null;
        if (head == null) {
            throw new NoSuchElementException(); //if head is null
        }

        if (head == tail) {
            olddata = tail.data;
            head = tail = null;  //if head = tail, meaning the list size is 1, it makes the element null
        } else {
            Node prev = head;
            while (prev.next != tail) {
                prev = prev.next;
            }
            olddata = tail.data; //else it saves the node next to the head, deletes the current head, and moves the new head to the top
            tail = prev;
            prev.next = null;
        }

        size--;
        return olddata;
    }

    //e
    //finds the element at the index and replaces it with the user input
    public void set(int index, T element) {
        Node<T> p = head;
        int count = 0;
        while (count != index) { //increment count until it matches the index
            count++;
            p = p.next; //the iterator makes it move nodes until it reaches the index
        }
        p.data = element; //changing the element to user input at index
    }

    //f
    //return the element at a given index
    public T get(int index) {
        Node<T> p = head;
        int count = 0;
        while (count != index) { //increment count until index is found
            count++;
            p = p.next; //iterator case moves node until it reaches index
        }
        return p.data; //return the element in index
    }

    //g
    //swaps two nodes given two indexes
    public void swap(int index1, int index2)
    {
        Node<T> p1 = head; //first node
        Node<T> p2 = head; //second node
        int count1 = 0;
        int count2 = 0;
        while (count1 != index1) { //iterator find the first node index
            count1++;
            p1 = p1.next;
        }
        while (count2 != index2) { //2nd interator finds the second node index
            count2++;
            p2 = p2.next;
        }
        T temp = p1.data; //basic swap algorithm, swaps the nodes with temp variable
        p1.data = p2.data;
        p2.data = temp;
    }
    
    //h
    //shifts the list based on negative or positive user input
    public void shift(int shift)
    {
        Node<T> p1 = head;
        Node<T> p2 = tail;
        if(shift > 0) //if the user enters a + number
        {
            for(int i = 0; i < shift; i++) //loops through list and moves head to end until i matches the amount of shifts entered
            {
                addEnd(p1.data); //moves head to the tail
                removeFront(); //removes old head
                p1 = p1.next; //loops until break condition
            }
        }
        
        if(shift < 0)
        {
            int count = 0;
            while(count != shift) //loops through list and moves tail to front until count matches the amount of shifts entered
            {
                addFront(p2.data); //moves tail to the head
                removeEnd(); //removes old tail
                p2 = tail; //loops a new tail until break condition
                count--; //decrement shift counter
            }
        }
        
    }
    
    //i
    //remove matching element based on the index given
    //uses search helper method as a boolean to confirm if element exists
    public void removeMatching(T index)
    {
        if(this.search(index)) //boolean condition
        {
            Node prev = head;
            Node curr = head;
            while(curr!=null && !curr.data.equals(index)) //unless data equals the index, the node moves on
            {
                prev = curr;
                curr = curr.next;
            }
            if(curr == tail) //if matching is tail, use removeEnd() function
                removeEnd();
            else if(curr == head) //if matching is head, use removeFront function
                removeFront();
            else
            {
                prev.next = curr.next; //if matching index is found, then remove from the list and move next element up to fill in space
                size++;
            }
        }
        else
        {
            System.out.println(index + " is not in the list!"); //in case not in list, fails boolean
        }
    }
    
    //j
    //removes a set amount of elements starting at a given index
    public void erase(int index, int nofelements) {
        int count = 0;
       
        while (count != nofelements) { //removes element with remove helper method at the index, until the number of elements removed matches the count
            remove(index);
            count++;
        }
    }
    
    //k
    //inserts a new list into an existing list at a given index
    public void insertList(GenLinkedList<T> list2, int index)
    {
        Node prev = head;
        Node curr = head;
        
        int count = 0;
        while (count != (index)) { //loop until the index is at the position for element insertion
            count++;
            prev = curr;
            curr = curr.next;
        }
        for(int i = 0; i < list2.size; i++) //loop through the entire list2 and create newNodes for every item in list2 that is being added to list
        {
            Node newNode = new Node(list2.get(i), null); //newNode starting with the ith character in the list
            prev.next = newNode; //current element becomes the newNode in the list
            prev = newNode;  //newNode is now the previous element in list and loops until list is printed
        }
        
        prev.next = curr; //new current element after the newNode
    }
    
    
    //remove Node helper method
    //original remove method I had learned in CS 2336, with a tweak to make it generic. This helped me create basically all of my other methods in this list class.
    Node<T> remove(int index) {
        Node prev = head;
        Node curr = head;
        int count = 0;
        while (count != index) {   //if count doesn't match the index, then loop until it does
            count++;
            prev = curr;
            curr = curr.next;
        }
        if (curr == tail) { //remove from tail if thats the index
            removeEnd();
        } else if (curr == head) { //remove the head if thats the index
            removeFront();
        } else {
            prev.next = curr.next; //else remove the index and move the next element up
            size++;
        }
        return null;
    }
    
    //search helper method
    //small boolean function to help check if elements exist
    public boolean search(T index){
        Node p = head;
        while(p!=null && !p.data.equals(index)) //unless the data equals the key presented, the loop will move to next nodes
        {
            p = p.next;
        }
        return p!=null; //return true, that there is a value in the index
    }
    
    //toString function
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");

        Node p = head;
        while (p != null) {
            sb.append(p.data + " ");
            p = p.next;
        }

        sb.append(" ]");
        return new String(sb);
    }

    //Generic Node Class
    public static class Node<T> {

        Node(T d, Node n) {
            data = d;
            next = n;
        }

        T data;
        Node<T> next;
    }
    //l
    //main method where all the functions are tested
    public static void main(String[] args) {
        GenLinkedList<Integer> list = new GenLinkedList<>();
        
        System.out.println("New List: ");
        list.addFront(0);
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);
        list.addEnd(5);
        list.addEnd(6);
        list.addEnd(7);
        list.addEnd(8);
        System.out.println(list);//initial list
        
        System.out.println("\nSet index 0 to '7': ");
        list.set(0, 7); //test set function by setting the 0th index to "7"
        System.out.println(list);//new list after set() function
        
        System.out.println("\nGet index 0: ");
        System.out.println(list.get(0)); //test get() function by returning the new value made by the set() function
        
        System.out.println("\nSet index 0 to back to '0': ");
        list.set(0, 0); //test set function by setting the 0th index to "7"
        System.out.println(list);//new list after set() function

        System.out.println("\nSwap Nodes 3 and 4: ");
        list.swap(3, 4);
        System.out.println(list);//
        
        System.out.println("\nShift Nodes +2: ");
        list.shift(+2);
        System.out.println(list);//list after shifting nodes +2
        
        System.out.println("\nShift Nodes -2: ");
        list.shift(-2);
        System.out.println(list);//list after shifting nodes -2
        
        System.out.println("\nRemove all elements with '3': ");
        list.removeMatching(3);
        System.out.println(list);//list after removing elements matching '3'
        
        System.out.println("\nErase starting at index 2, up to 3 elements: ");
        list.erase(2,3);
        System.out.println(list);//list after erasing 3 nodes starting at index 2
        
        //new list to be inserted
        GenLinkedList<Integer> list2 = new GenLinkedList<>();
        list2.addFront(2);
        list2.addEnd(3);
        list2.addEnd(4);
        list2.addEnd(5);
        
        System.out.println("\nInsert List at index 2: ");
        list.insertList(list2, 2);
        System.out.println(list);//list after list2 has been inserted at position 2
        
        System.out.println("\nRemove Front Node: ");
        int a = list.removeFront();
        System.out.println(list);//list after removing Front Node
        
        System.out.println("\nRemove End Node: ");
        int b = list.removeEnd();
        System.out.println(list);//list after removing End Node
        
        System.out.println("\nFinal List: ");
        System.out.println(list);//final list

    }

}
