public class ArraysFunctionArgument {
  public static void update(int marks[]) {
    for(int i=0;i<marks.length;i++){
      marks[i] = marks[i] + 1;
    }
    
  }
  public static void main(StringDemo[] args) {
    int marks[] = {90,50,80};
    update(marks);

    //print our marks
    for(int i=0;i<marks.length;i++){
      System.out.print(marks[i]+" ");

    }
    System.out.println();

    
  }
  
}
