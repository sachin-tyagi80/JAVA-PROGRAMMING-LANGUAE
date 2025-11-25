public class LinkedListPalindrome {
  public static class Linkedlist {
    public static class Node {
      int data;
      Node next;
      public Node(int data) {
        this.data = data;
        this.next = null;
      }
    }

    Node head;
    Node tail;

    // Add a node at the beginning
    public void addFirst(int data) {
      Node newNode = new Node(data);
      if (head == null) {
        head = tail = newNode;
      } else {
        newNode.next = head;
        head = newNode;
      }
    }

    // Add a node at the end
    public void addLast(int data) {
      Node newNode = new Node(data);
      if (head == null) {
        head = tail = newNode;
      } else {
        tail.next = newNode;
        tail = newNode;
      }
    }

    // Add a node at specific index
    public void add(int index, int data) {
      if (index == 0) {
        addFirst(data);
        return;
      }
      Node newNode = new Node(data);
      Node temp = head;
      for (int i = 0; i < index - 1 && temp != null; i++) {
        temp = temp.next;
      }
      if (temp == null) {
        System.out.println("Index out of bounds");
        return;
      }
      newNode.next = temp.next;
      temp.next = newNode;
      if (newNode.next == null) tail = newNode; // uupdate tail if added at the end
    }

    // Print the list
    public void print() {
      Node temp = head;
      while (temp != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
      }
      System.out.println("null");
    }

    // check a LinkedList is Palindrome
    // slow - fast opparoch
    public Node findMid(Node head){
      Node slow = head;
      Node fast = head;

      while (fast != null && fast.next != null){
        slow = slow.next; // +1
        fast = fast.next.next; // +2
      }
      return slow; // slow is my Node

    }
    public boolean checkPalindrome(){
      if(head == null || head.next == null){
        return true;
      }
      //step-1 find mid
      Node miNode = findMid(head);

      //STEP-2 Reverse 2 half
      Node prev = null;
      Node curr = miNode;
      Node next;
      while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      Node right = prev;
      Node left = head; // right half head

      // step-3 check left & right half
      while (right != null) {
        if(left.data != right.data){
          return false;
        }
        left = left.next; // update
        right = right.next;
      }

      return true;

    }

  }

  public static void main(String[] args) {
    Linkedlist l1 = new Linkedlist();
    l1.addLast(1);
    l1.addLast(2);
    l1.addLast(2);
    l1.addLast(1);
    l1.print(); // 1->2->2->1
    System.out.println(l1.checkPalindrome());
    
  }
}
