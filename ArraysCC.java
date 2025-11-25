import java.util.*;

public class ArraysCC {
  public static void main(StringDemo[] args) {
    int marks[] = new int[100];
    Scanner sc = new Scanner(System.in);
    marks[0] = sc.nextInt();
    marks[1] = sc.nextInt();
    marks[2] = sc.nextInt();

    System.out.println("phy :"+marks[0]);
    System.out.println("math :"+marks[1]);
    System.out.println("chm :"+marks[2]);

    marks[2] = 100;  //update marks
    System.out.println("chm :"+marks[2]);
    System.out.println("length of arrays :" +marks.length);
    
  }
  
}