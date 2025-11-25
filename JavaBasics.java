// public class JavaBasics {
//   public static void main(String[] args) {
//     int a = 10;
//     int b= 15;
//     int c = a%b;
//     System.out.println("hello sachin " +c);
//   }
// }



// import java.util.Scanner;
// public class JavaBasics {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int n =sc.nextInt();
//     int sum = 0;
//     int i =1;
//     while(i<=n){
//       sum += i;  // sum = sum + i 
//       i++;
//     }
//     System.out.println("sum is :" +sum );
//   }
// }



// reverse number
public class JavaBasics {
  public static void main(StringDemo[] args) {
    int n = 10899;
    while(n>0){
      int lastDigit = n%10;
      System.out.print(lastDigit);
      n = n/10;
    }
    System.out.println();
  }
}