public class RemoveCycle {

  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;

  // ✅ Correct cycle removal method
  public static void removeCycle() {
    Node slow = head;
    Node fast = head;
    boolean cycle = false;

    // Detect cycle
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        cycle = true;
        break;
      }
    }

    if (!cycle) {
      return;
    }

    // Find metting point
    slow = head;
    Node prev = null; // to keep track of last node in the cycle
    while (slow != fast) {
      prev = fast;
      slow = slow.next;
      fast = fast.next;
    }

    // Remove cycle -> last.next = null
    prev.next = null;
  }

  // ✅ Add cycle checker
  public static boolean isCycle() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    head = new Node(1);
    Node temp = new Node(2);
    head.next = temp;
    head.next.next = new Node(3);
    head.next.next.next = temp;; // cycle: 1 -> 2 -> 3 -> 2

    System.out.println("Cycle detected: " + isCycle());
    removeCycle();
    System.out.println("Cycle detected after removal: " + isCycle());
  }
}
