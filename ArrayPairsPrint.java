public class ArrayPairsPrint {
  public static void printPairs(int numbers[]){
    int tp =0;
    for(int i=0;i<numbers.length;i++){
      int curr = numbers[i];
      for(int j=i+1;j<numbers.length;j++){
        System.out.print("(" +curr + "," +numbers[j] + ") ");
        tp++;
      }
      System.out.println();
    }
    System.out.println("total pairs:" +tp);
  }
  public static void main(StringDemo[] args) {
    int number[] = {2,4,6,8,10};
    printPairs(number);
  }
  
}
