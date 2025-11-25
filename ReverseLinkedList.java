public class ReverseLinkedList {
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
      if (newNode.next == null) tail = newNode; // update tail if added at the end
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

    // Reverse the linked list
    public void reverse() {
      Node prev = null;
      Node curr = tail = head;
      Node next;

      while ((curr != null)) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;  
      }
      head = prev;
    }  
  }

  public static void main(String[] args) {
    Linkedlist l1 = new Linkedlist();
    l1.addFirst(2);
    l1.addFirst(1);
    l1.addLast(3);
    l1.addLast(4);
    l1.print();           // 1 -> 2 -> 3 -> 4 -> null
    l1.add(2, 9);         // Insert 9 at index 2
    l1.print();           // 1 -> 2 -> 9 -> 3 -> 4 -> null
    l1.reverse();         // Reverse the list
    l1.print();           // 4 -> 3 -> 9 -> 2 -> 1 -> null
  }
}
