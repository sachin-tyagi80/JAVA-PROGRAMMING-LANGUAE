
// public class PrintPower {
//   public static int Power(int x,int n){
//     if(n == 0){
//       return 1;
//     }
//     return x * Power(x,n-1);
//   }
  
//   public static void main(String[] args) {
//     System.out.println(Power(2, 10));
//   }
// }



//Optimized power code
public class PrintPower {
  public static int OptimizedPower(int x,int n){
    if(n == 0){
      return 1;
    }
    //n is even
    int halfPower = OptimizedPower(x, n/2);
    int halfPowersq = halfPower * OptimizedPower(x, n/2);
    // n is add
    if(n%2 != 0){
      halfPowersq = x * halfPowersq;
    }
    return halfPowersq;
  }
  
  public static void main(String[] args) {
    System.out.println(OptimizedPower(2, 10));
  }
}
