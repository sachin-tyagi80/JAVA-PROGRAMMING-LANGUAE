import java.util.Arrays;
public class MinAbsoluteDiff {
  public static void main(String[] args) {
   int A[] = {4,1,8,7};
   int B[] = {2,3,6,5};
   Arrays.sort(A);
   Arrays.sort(B);
   int minDiff = 0;
   for(int i=0;i<A.length;i++){
     minDiff += Math.abs(A[i]-B[i]);
   }

   System.out.println("Minimum absolute difference of pairs = " + minDiff);


  }
}

// "I use a Greedy approach. First, I sort both arrays in ascending order. Then I pair the smallest element of the first array with the smallest element 
// of the second array, the second smallest with the second smallest, and so on. This minimizes the absolute difference for every pair, 
// resulting in the minimum total difference."
