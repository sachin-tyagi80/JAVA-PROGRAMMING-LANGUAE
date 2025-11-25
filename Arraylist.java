import java.util.ArrayList;

public class Arraylist {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    //list
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    //list.add(1,9);
    System.out.println(list);
    System.out.println(list.size());
    // iteration
    for(int i=0;i<list.size();i++){
      System.out.print(list.get(i) + " ");
    }
    System.err.println();

    // get operation
    //System.err.println(list.get(1));

    // remove element
    // list.remove(2);
    // System.out.println(list);

    // Set element at index
    // list.set(2,10);
    // System.out.println(list);

    // contains
    // System.out.println(list.contains(1));
    // System.out.println(list.contains(11));
  }  
}
