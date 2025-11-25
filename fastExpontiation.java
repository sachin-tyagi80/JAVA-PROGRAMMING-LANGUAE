public class fastExpontiation {
  public double myPow(double x, int n) {
        double ans = 1;
        while(n>0){
            if((n & 1) != 0){
                ans = ans *x;
            }
            x = x*x;
            n = n>>1;
        }
        return ans;
  }
  public static void main(String[] args) {
  fastExpontiation obj = new fastExpontiation();
  System.out.println(obj.myPow(3,5));
  }
  
}
