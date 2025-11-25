public class function{
  public static boolean isPrime(int n){
    boolean isPrime = true;
    for(int i=2;i<=n-1;i++){
      if(n%i == 0){
        isPrime = false;
        return isPrime;
      }
    }
    return isPrime;
  }
  public static void main(StringDemo args[]){
    int n = 5;
    System.out.println(isPrime(n));
  }
}
