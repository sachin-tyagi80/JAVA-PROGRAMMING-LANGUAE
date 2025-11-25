public class TillingProblem {
  public static int tills(int n){ // 2 * n (floor size)
    if(n == 0 || n == 1){
      return 1;
    }
     

    //kaam
    //vertical choice

    int fnm1 = tills(n-1);

    //horiozontal
    int fnm2 = tills(n-2);

    int totalWays = fnm1 + fnm2;
    return totalWays;
  }

  public static void main(String[] args) {
    System.err.println(tills(4));
  }
  
}
