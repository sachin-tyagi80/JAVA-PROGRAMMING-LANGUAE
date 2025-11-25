public class Linkedlist {
  public static class Node{
    int data;
    Node next;
    public Node(int data){
      this.data = data;
      this.next = null;
    }
  }
  Node head;
  Node tail;
  int size;
  //add first Node
  public void addFirst(int data){
    //step1 - create new  node
    Node newNode = new Node(data);
    size++;
    if(head == null){
      head = tail = newNode;
      return;
    }
    
    // step2- newNode next = head
    newNode.next = head; // link

    //step3 - head = newNode
    head = newNode;
  }

  // add Last Node  
  public void addLast(int data){
    Node newNode = new Node(data);
    size++;
    if(head == null){
      head = tail = newNode;
      return;
    }
    tail.next = newNode;
    tail = newNode;
  }

  // print a linkedlist
  public void print(){
    if(head == null){
      System.out.println("null");
      return;
    }
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data+ "->");
      temp = temp.next;
    }
    System.out.println("null");
  }
  // Add in the middle
  public void add(int idx, int data){
    if(idx == 0){ // head data add 
      addFirst(data);
      return;
    }

    Node newNode = new Node(data);
    size++;  
    Node temp = head;
    int i =0;
    while(i < idx-1){
      temp = temp.next;
      i++;
    }
    // i = idx-1 => temp -> prev
    newNode.next = temp.next;
    temp.next = newNode;

  }
  // remove first linkeedList
  public int removeFirst(){
    if(size == 0){
      System.out.println("v1 is empty");
      return Integer.MIN_VALUE;
    }else if(size == 1){
        int val = head.data;
        head = tail = null;
        size = 0;
        return val;
    }
    int val = head.data;
    head = head.next;
    size--;
    return val;
  }

  //remove last LinkedList
   public int removeLast(){
    if(size == 0){
      System.out.println("v1 is empty");
      return Integer.MIN_VALUE;
    }else if(size == 1){
        int val = head.data;
        head = tail = null;
        size = 0;
        return val;
    }
    // prev : i = size-2
    Node prev = head;
    for(int i=0;i<size-2;i++){
      prev = prev.next;
    }

    int val = prev.next.data; // tail.data
    prev.next = null;
    tail = prev;
    size--;
    return val;

  }
  // Search index key(Iteration)

  public int itrSearch(int key){
    Node temp = head;
    int i = 0;
    while(temp != null){
      if(temp.data == key){ // key found
        return i;
      }
      temp = temp.next;
      i++;
    }
    // key not found
    return -1;
  }

  // Searching key(Recursion)
  public int helper(Node head, int key){
    if(head == null){
      return-1;
    }
    if(head.data == key){
      return 0;
    }
    int idx = helper(head.next, key);
    if(idx == -1){
      return -1;
    }
    return idx +1;
  }
  public int recSearch(int key){
    return helper(head, key);
  }






  public static void main(String[] args) {
    Linkedlist l1 = new Linkedlist();
    l1.addFirst(2);
    l1.addFirst(1);
    l1.addLast(3);
    l1.addLast(4);
    l1.print();
    l1.add(2, 9);// add data
    l1.print(); 
  
    System.out.println(l1.size);
    l1.removeFirst();
    l1.print();
    l1.removeLast();
    l1.print();

    //System.out.println(l1.itrSearch(3));
    System.out.println(l1.recSearch(3));

    
  }
  
}
