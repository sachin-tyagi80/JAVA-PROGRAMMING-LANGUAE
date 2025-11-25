public class RemoveNthnodefromEnd {
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
    // Delete the nth node from end
    public void delete(int n){
      // cal size
      int sz = 0;
      Node temp = head;
      while(temp != null) {
        temp = temp.next;
        sz++;        
      }
      if(n == sz){
        head = head.next; // removeFirs
        return;
        }
        // sz-n
        int i =1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind){
          prev = prev.next;
          i++;

        }
        prev.next = prev.next.next;
        return;

    }

   

  public static void main(String[] args) {
    RemoveNthnodefromEnd l1 = new RemoveNthnodefromEnd();
    l1.addFirst(2);
    l1.addFirst(1);
    l1.addLast(4);
    l1.addLast(5);
    l1.print();           
    l1.add(2, 3);   
    l1.print();           
    l1.delete(3);
    l1.print();
  }
}
