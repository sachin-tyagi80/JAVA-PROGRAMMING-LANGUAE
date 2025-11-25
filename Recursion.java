// print sum of n natural number
// public class Recursion {
//   public static int calSum(int n){
//     if(n ==1){
//       return 1;
//     }
//     return n  + calSum(n-1);
//   }


//   public static void main(String[] args) {
//     int n =5;
//     System.out.println(calSum(n));
//   }
  
// }


// calculate nth term in fibonacci
public class Recursion {
  public static int fib(int n){
    if(n ==0 || n == 1){
      return n;
    }
    return fib(n-1) + fib(n-2);
  }


  public static void main(String[] args) {
    int n =5;
    System.out.println(fib(n));
  }
  
}
