import java.util.*;

public class ZigZag {
  public static class Node {
    int data;
    Node next;
    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  Node head;

  public void addLast(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      return;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public void zig() {
    // find mid
    Node slow = head;
    Node fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    Node mid = slow;

    // reverse 2nd half
    Node curr = mid.next;
    mid.next = null;
    Node prev = null;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    Node left = head;
    Node right = prev;
    Node nextL, nextR;

    // alternate merge
    while (left != null && right != null) {
      nextL = left.next;
      left.next = right;
      nextR = right.next;
      right.next = nextL;

      left = nextL;
      right = nextR;
    }
  }

  public static void main(String[] args) {
    ZigZag l1 = new ZigZag();
    l1.addLast(1);
    l1.addLast(2);
    l1.addLast(3);
    l1.addLast(4);
    l1.addLast(5);

    System.out.println("Original:");
    l1.printList();

    l1.zig();

    System.out.println("ZigZag:");
    l1.printList();
  }
}
