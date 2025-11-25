public class TowerOfHanoi {
  public static void tower(int n,String src,String helper,String dest){
    if (n == 1) { // Base case
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        tower(n-1, src, dest, helper); // Step 1 moves (n-1) from src to helper using dest 
        System.out.println("transfer disk " + n + " from " + src + " to " + dest); // Step 2
        tower(n-1, helper, src, dest); // Step 3 // moves(n-1) from helper to dest using src
  }
  public static void main(String[] args) {
    int n = 1;
    tower(n, "A", "B", "C");

  }
  
}
